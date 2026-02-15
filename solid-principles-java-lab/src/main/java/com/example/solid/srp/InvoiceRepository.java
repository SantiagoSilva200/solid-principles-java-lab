package com.example.solid.srp;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository {
    private List<GoodInvoice> database = new ArrayList<>();
    
    public void save(GoodInvoice invoice) {
        database.add(invoice);
        System.out.println("Factura " + invoice.getInvoiceNumber() + " guardada en base de datos");
    }
    
    public GoodInvoice findByNumber(String invoiceNumber) {
        return database.stream()
                .filter(inv -> inv.getInvoiceNumber().equals(invoiceNumber))
                .findFirst()
                .orElse(null);
    }
    
    public List<GoodInvoice> findAll() {
        return new ArrayList<>(database);
    }
}