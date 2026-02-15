package com.example.solid.isp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorkerTest {

    @Test
    void developerShouldOnlyWork() {
        Workable developer = new Developer();

        assertDoesNotThrow(developer::work);
    }

    @Test
    void humanWorkerShouldWorkAndEat() {
        HumanWorker worker = new HumanWorker();

        assertDoesNotThrow(worker::work);
        assertDoesNotThrow(worker::eat);
    }
}