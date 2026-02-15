package com.example.solid.lsp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LSPTest {
    
    @Test
    void testGasCar() {
        GasCar car = new GasCar("Toyota Corolla");
        
        // Podemos usar Drivable
        Drivable drivable = car;
        drivable.drive();
        assertTrue(drivable.getSpeed() > 0);
        
        // Podemos usar Refuelable
        Refuelable refuelable = car;
        assertEquals(95, refuelable.getFuelLevel(), 0.1);
        refuelable.refuel();
        assertEquals(100, refuelable.getFuelLevel());
    }
    
    @Test
    void testElectricCar() {
        ElectricCar car = new ElectricCar("Tesla Model 3");
        
        // Podemos usar Drivable
        Drivable drivable = car;
        drivable.drive();
        assertTrue(drivable.getSpeed() > 0);
        
        // Podemos usar Chargeable
        Chargeable chargeable = car;
        assertEquals(92, chargeable.getBatteryLevel(), 0.1);
        chargeable.charge();
        assertEquals(100, chargeable.getBatteryLevel());
        
        // Verificamos que no implementa Refuelable
        assertFalse(car instanceof Refuelable);
    }
}