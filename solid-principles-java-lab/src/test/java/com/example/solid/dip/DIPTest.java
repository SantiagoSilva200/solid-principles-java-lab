package com.example.solid.dip;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DIPTest {
    
    private Order order;
    
    @BeforeEach
    void setUp() {
        order = new Order("María Rodríguez", 1500.0);
    }
    
    @Test
    void testOrderProcessorWithMySQL() {
        Database mySQL = new MySQLDatabase();
        OrderProcessor processor = new OrderProcessor(mySQL);
        
        processor.processOrder(order);
        assertEquals("PROCESSED", order.getStatus());
    }
    
    @Test
    void testOrderProcessorWithMongoDB() {
        Database mongoDB = new MongoDBDatabase();
        OrderProcessor processor = new OrderProcessor(mongoDB);
        
        processor.processOrder(order);
        assertEquals("PROCESSED", order.getStatus());
    }
    
    @Test
    void testDatabaseIndependence() {
        Database db1 = new MySQLDatabase();
        Database db2 = new MongoDBDatabase();
        
        OrderProcessor processor1 = new OrderProcessor(db1);
        OrderProcessor processor2 = new OrderProcessor(db2);
        
        assertDoesNotThrow(() -> {
            processor1.processOrder(new Order("Cliente 1", 100));
            processor2.processOrder(new Order("Cliente 2", 200));
        });
    }
    
    @Test
    void testOrderOperations() {
        Database db = new MySQLDatabase();
        OrderProcessor processor = new OrderProcessor(db);
        
        processor.processOrder(order);
        processor.updateOrderStatus(order.getOrderId(), "SHIPPED");
        processor.cancelOrder(order.getOrderId());
        
        assertTrue(true);
    }
}