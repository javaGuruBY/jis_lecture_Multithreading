package by.jrr.basic;

public class DataRacesVolotile {

    volatile public static int COUNTER = 0;

    public int perform() throws InterruptedException {
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
            DataRacesVolotile.COUNTER++;
            //1. read value COUNTER to memory
            //2. add 1 to value in memory
            //3. store value from memory to COUNTER
        }
    }

    public void decrementCounter() {
        for (int i = 0; i < 1_000_000; i++) {
            DataRacesVolotile.COUNTER--;
            //1. read value COUNTER to memory
            //2. subtract 1 to value in memory
            //3. store value from memory to COUNTER
        }
    }
}
