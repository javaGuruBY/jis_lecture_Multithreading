package by.jrr.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreadPoolExTest {

    @Test
    void perform() throws InterruptedException {
        var threadPoolEx = new ThreadPoolEx();
        threadPoolEx.perform();
    }
}
