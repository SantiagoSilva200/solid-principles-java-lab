package com.example.solid.dip;

public class OrderProcessor {
    private final Database database;
    
    public OrderProcessor(Database database) {
        this.database = database;
    }
    
    public void processOrder(Order order) {
        System.out.println("Procesando pedido para: " + order.getCustomerName());
        System.out.println("Total: $" + order.getTotalAmount());
        
        order.setStatus("PROCESSED");
        
        database.save("orders", order.toMap());
        
        System.out.println("Pedido procesado exitosamente usando " + database.getDatabaseType());
    }
    
    public void cancelOrder(String orderId) {
        System.out.println("Cancelando pedido: " + orderId);
        database.delete("orders", orderId);
    }
    
    public void updateOrderStatus(String orderId, String newStatus) {
        System.out.println("Actualizando estado del pedido: " + orderId);
        Map<String, Object> updates = new HashMap<>();
        updates.put("status", newStatus);
        database.update("orders", orderId, updates);
    }
}