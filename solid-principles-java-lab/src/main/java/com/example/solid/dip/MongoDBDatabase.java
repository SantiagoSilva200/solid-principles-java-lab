package com.example.solid.dip;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MongoDBDatabase implements Database {
    private Map<String, Map<String, Map<String, Object>>> documentStore = new HashMap<>();
    
    @Override
    public void save(String collection, Map<String, Object> data) {
        documentStore.putIfAbsent(collection, new HashMap<>());
        String id = UUID.randomUUID().toString();
        data.put("_id", id);
        documentStore.get(collection).put(id, new HashMap<>(data));
        System.out.println("MongoDB: Guardando documento en colección '" + collection + "' con _id: " + id);
    }
    
    @Override
    public Map<String, Object> findById(String collection, String id) {
        if (documentStore.containsKey(collection)) {
            return documentStore.get(collection).get(id);
        }
        return null;
    }
    
    @Override
    public void delete(String collection, String id) {
        if (documentStore.containsKey(collection)) {
            documentStore.get(collection).remove(id);
            System.out.println("MongoDB: Eliminado documento de colección '" + collection + "' ID: " + id);
        }
    }
    
    @Override
    public void update(String collection, String id, Map<String, Object> data) {
        if (documentStore.containsKey(collection) && documentStore.get(collection).containsKey(id)) {
            documentStore.get(collection).get(id).putAll(data);
            System.out.println("MongoDB: Actualizando documento en colección '" + collection + "' ID: " + id);
        }
    }
    
    @Override
    public String getDatabaseType() {
        return "MongoDB";
    }
}