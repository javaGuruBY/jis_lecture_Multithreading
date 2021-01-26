package by.jrr.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadLockAvoidingWithAtomicyTest {

    @Test
    void perform() {
        var deadLock = new DeadLockAvoidingWithAtomicy();
        deadLock.perform();
    }
}
