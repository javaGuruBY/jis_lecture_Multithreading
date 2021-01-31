package by.jrr.basic;

import org.junit.jupiter.api.Test;

class HappensBeforeReentrantLockTest {

    @Test
    void perform() throws InterruptedException {
        var happensBefore= new HappensBeforeReentrantLock();
        happensBefore.perform();
    }

    @Test
    void tryCatchFinalyExample() throws InterruptedException {
        var happensBefore= new HappensBeforeReentrantLock();
        happensBefore.tryCatchFinallyExample();
    }
}
