package com.example.solid.dip;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private String orderId;
    private String customerName;
    private double totalAmount;
    private LocalDateTime orderDate;
    private String status;
    
    public Order(String customerName, double totalAmount) {
        this.orderId = "ORD-" + System.currentTimeMillis();
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.orderDate = LocalDateTime.now();
        this.status = "PENDING";
    }
    
    public Map<String, Object> toMap() {
        Map<String, Object> data = new HashMap<>();
        data.put("orderId", orderId);
        data.put("customerName", customerName);
        data.put("totalAmount", totalAmount);
        data.put("orderDate", orderDate.toString());
        data.put("status", status);
        return data;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    // Getters
    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getTotalAmount() { return totalAmount; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public String getStatus() { return status; }
}