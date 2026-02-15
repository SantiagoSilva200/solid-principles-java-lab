package com.example.solid.isp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ISPTest {
    
    @Test
    void testDeveloper() {
        Developer dev = new Developer("Ana García");
        
        dev.work();
        assertEquals("Escribiendo código en Java", dev.getCurrentTask());
        assertEquals(8, dev.getWorkHours());
        
        // Developer no implementa Eatable
        assertFalse(dev instanceof Eatable);
    }
    
    @Test
    void testRobot() {
        Robot robot = new Robot("R2D2");
        
        robot.work();
        assertEquals("Ejecutando tareas automatizadas", robot.getCurrentTask());
        assertEquals(24, robot.getWorkHours());
        
        // Robot no implementa Eatable
        assertFalse(robot instanceof Eatable);
    }
    
    @Test
    void testHumanWorker() {
        HumanWorker human = new HumanWorker("Carlos López", "ensalada");
        
        human.work();
        human.eat();
        human.takeBreak();
        
        assertEquals(8, human.getWorkHours());
        assertEquals("ensalada", human.getMealPreference());
        
        // HumanWorker implementa ambas interfaces
        assertTrue(human instanceof Workable);
        assertTrue(human instanceof Eatable);
    }
}