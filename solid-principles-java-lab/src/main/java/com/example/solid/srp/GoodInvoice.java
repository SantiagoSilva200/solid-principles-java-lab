package com.example.solid.srp;

// Clase con responsabilidad única: representar la factura
public class GoodInvoice {
    private String customer;
    private double amount;
    private String invoiceNumber;

    public GoodInvoice(String customer, double amount) {
        this.customer = customer;
        this.amount = amount;
        this.invoiceNumber = generateInvoiceNumber();
    }

    public double calculateTotal() {
        return amount * 1.21; // 21% IVA
    }

    public String getCustomer() { return customer; }
    public double getAmount() { return amount; }
    public String getInvoiceNumber() { return invoiceNumber; }

    private String generateInvoiceNumber() {
        return "INV-" + System.currentTimeMillis();
    }
}
