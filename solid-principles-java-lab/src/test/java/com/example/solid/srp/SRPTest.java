package com.example.solid.srp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InvoiceTest {

    @Test
    void shouldCalculateTotalWithTax() {
        Invoice invoice = new Invoice("Santiago", 100.0);

        double total = invoice.calculateTotal();

        assertEquals(121.0, total);
    }
}
