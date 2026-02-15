package com.example.solid.dip;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderProcessorTest {

    @Test
    void shouldProcessOrderWithoutErrors() {
        Database database = new MySQLDatabase();
        OrderProcessor processor = new OrderProcessor(database);

        assertDoesNotThrow(processor::processOrder);
    }
}
