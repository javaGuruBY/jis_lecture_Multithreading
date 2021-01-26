package by.jrr.basic;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeadLockAvoiding {

    String one = " one ";
    String two = " two ";

    Logger log = LoggerFactory.getLogger("ThreadState");

    public void perform() { //Not For Production!
        Thread oneTwo = new Thread(this::oneTwo1);
        Thread twoOne = new Thread(this::oneTwo2);

        oneTwo.start();
        twoOne.start();

//        try {
//            oneTwo.join();
//            twoOne.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @SneakyThrows
    public void oneTwo1() {
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
    public void oneTwo2() {
        for (int i = 0; i < 1_000_000; i++) {
            synchronized (one) {
                log.info(" Lock two");
                Thread.sleep(1);
                synchronized (two) {
                    log.info(" Lock one");
                }
            }
        }
    }

}
