package by.jrr.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadLockWithLockTest {

    @Test
    void perform() throws InterruptedException {
        var deadLockWithLock = new DeadLockWithLock();
        deadLockWithLock.perform();
    }
}
