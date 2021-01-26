package by.jrr.basic;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeadLock {

    //todo: now debug deadLock
    String one = " one ";
    String two = " two ";

    Logger log = LoggerFactory.getLogger("ThreadState");

    public void perform() { //Not For Production!
        Thread oneTwo = new Thread(this::oneTwo);
        Thread twoOne = new Thread(this::twoOne);

        oneTwo.start();
        twoOne.start();

    }

    @SneakyThrows
    public void oneTwo() {
        for (int i = 0; i < 1_000_000; i++) {
            synchronized (one) {
                log.info(" Lock one");
                Thread.sleep(1);
                synchronized (two) {
                    log.info(" Lock two");
                }
            }
        }
    }

    @SneakyThrows
    public void twoOne() {
        for (int i = 0; i < 1_000_000; i++) {
            synchronized (two) {
                log.info(" Lock two");
                Thread.sleep(1);
                synchronized (one) {
                    log.info(" Lock one");
                }
            }
        }
    }
}
