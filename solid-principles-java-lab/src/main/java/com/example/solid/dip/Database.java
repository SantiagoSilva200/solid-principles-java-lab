package com.example.solid.dip;

import java.util.Map;

public interface Database {
    void save(String collection, Map<String, Object> data);
    Map<String, Object> findById(String collection, String id);
    void delete(String collection, String id);
    void update(String collection, String id, Map<String, Object> data);
    String getDatabaseType();
}