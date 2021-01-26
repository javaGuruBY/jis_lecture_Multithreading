package by.jrr.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadLockTest {

    @Test
    void perform() {
        var deadLock = new DeadLock();
        deadLock.perform();
    }
}
