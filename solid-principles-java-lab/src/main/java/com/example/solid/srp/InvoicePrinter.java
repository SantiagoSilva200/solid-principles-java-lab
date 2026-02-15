package com.example.solid.srp;

public class InvoicePrinter {
    
    public void printInvoice(GoodInvoice invoice) {
        System.out.println("=== FACTURA ===");
        System.out.println("Número: " + invoice.getInvoiceNumber());
        System.out.println("Cliente: " + invoice.getCustomer());
        System.out.println("Subtotal: $" + invoice.getAmount());
        System.out.println("Total (con IVA): $" + invoice.calculateTotal());
        System.out.println("================");
    }
    
    public String formatInvoiceAsString(GoodInvoice invoice) {
        StringBuilder sb = new StringBuilder();
        sb.append("Factura #").append(invoice.getInvoiceNumber()).append("\n");
        sb.append("Cliente: ").append(invoice.getCustomer()).append("\n");
        sb.append("Total: $").append(invoice.calculateTotal());
        return sb.toString();
    }
}