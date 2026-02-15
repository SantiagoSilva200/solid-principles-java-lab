package com.example.solid.dip;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MySQLDatabase implements Database {
    private Map<String, Map<String, Map<String, Object>>> dataStore = new HashMap<>();
    
    @Override
    public void save(String collection, Map<String, Object> data) {
        dataStore.putIfAbsent(collection, new HashMap<>());
        String id = UUID.randomUUID().toString();
        data.put("id", id);
        dataStore.get(collection).put(id, new HashMap<>(data));
        System.out.println("MySQL: Guardando en colección '" + collection + "' con ID: " + id);
    }
    
    @Override
    public Map<String, Object> findById(String collection, String id) {
        if (dataStore.containsKey(collection)) {
            return dataStore.get(collection).get(id);
        }
        return null;
    }
    
    @Override
    public void delete(String collection, String id) {
        if (dataStore.containsKey(collection)) {
            dataStore.get(collection).remove(id);
            System.out.println("MySQL: Eliminado de colección '" + collection + "' ID: " + id);
        }
    }
    
    @Override
    public void update(String collection, String id, Map<String, Object> data) {
        if (dataStore.containsKey(collection) && dataStore.get(collection).containsKey(id)) {
            dataStore.get(collection).get(id).putAll(data);
            System.out.println("MySQL: Actualizando colección '" + collection + "' ID: " + id);
        }
    }
    
    @Override
    public String getDatabaseType() {
        return "MySQL";
    }
}