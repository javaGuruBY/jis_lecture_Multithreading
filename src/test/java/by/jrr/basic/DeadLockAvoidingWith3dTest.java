package by.jrr.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadLockAvoidingWith3dTest {

    @Test
    void perform() {
        var deadLock = new DeadLockAvoidingWith3d();
        deadLock.perform();
    }
}
