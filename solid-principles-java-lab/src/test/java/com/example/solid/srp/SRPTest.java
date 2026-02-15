package com.example.solid.srp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SRPTest {
    
    private GoodInvoice invoice;
    private InvoiceRepository repository;
    private InvoicePrinter printer;
    
    @BeforeEach
    void setUp() {
        invoice = new GoodInvoice("Juan Pérez", 1000.0);
        repository = new InvoiceRepository();
        printer = new InvoicePrinter();
    }
    
    @Test
    void testInvoiceCreation() {
        assertEquals("Juan Pérez", invoice.getCustomer());
        assertEquals(1000.0, invoice.getAmount());
        assertEquals(1210.0, invoice.calculateTotal());
        assertNotNull(invoice.getInvoiceNumber());
    }
    
    @Test
    void testInvoiceRepository() {
        repository.save(invoice);
        GoodInvoice found = repository.findByNumber(invoice.getInvoiceNumber());
        assertNotNull(found);
        assertEquals(invoice.getCustomer(), found.getCustomer());
    }
    
    @Test
    void testInvoicePrinter() {
        String formatted = printer.formatInvoiceAsString(invoice);
        assertTrue(formatted.contains("Juan Pérez"));
        assertTrue(formatted.contains("1210.0"));
    }
}