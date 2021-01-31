package by.jrr.basic;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataRacesSyncWithLockTest {

    @Test
    void perform() throws InterruptedException {
        var dataRacesSyncWithLock = new DataRacesSyncWithLock();
        assertEquals(10, dataRacesSyncWithLock.perform());
    }
}
