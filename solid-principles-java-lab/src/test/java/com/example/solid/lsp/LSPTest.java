package com.example.solid.lsp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    void electricCarShouldDrive() {
        Drivable car = new ElectricCar();

        assertDoesNotThrow(car::drive);
    }

    @Test
    void fuelCarShouldDriveAndRefuel() {
        FuelCar car = new FuelCar();

        assertDoesNotThrow(car::drive);
        assertDoesNotThrow(car::refuel);
    }
}
