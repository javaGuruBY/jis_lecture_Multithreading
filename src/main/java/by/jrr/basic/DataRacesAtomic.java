package by.jrr.basic;

import java.util.concurrent.atomic.AtomicInteger;

public class DataRacesAtomic {

    public static AtomicInteger COUNTER = new AtomicInteger(0);

    public AtomicInteger perform() throws InterruptedException {
        Thread increment = new Thread(() -> incrementCounter());
        Thread decrement = new Thread(() -> decrementCounter());

        increment.start();
        decrement.start();

        increment.join();
        decrement.join();

        return COUNTER;
    }

    public void incrementCounter() {
        for (int i = 0; i < 1_000_000; i++) {
            DataRacesAtomic.COUNTER.getAndIncrement();
        }
    }

    public void decrementCounter() {
        for (int i = 0; i < 1_000_000; i++) {
            DataRacesAtomic.COUNTER.getAndDecrement();
        }
    }
}
