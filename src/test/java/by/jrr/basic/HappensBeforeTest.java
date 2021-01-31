package by.jrr.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HappensBeforeTest {

    @Test
    void perform() throws InterruptedException {
        var happensBefore= new HappensBefore();
        happensBefore.perform();
    }
}
