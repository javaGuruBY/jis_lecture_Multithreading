package by.jrr.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadLockAvoidingTest {

    @Test
    void perform() {
        var deadLock = new DeadLockAvoiding();
        deadLock.perform();
    }
}
