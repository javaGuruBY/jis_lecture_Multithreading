package by.jrr.basic;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLockWithLock {

    //todo: now debug deadLock
    String one = " one ";
    String two = " two ";

    public static ReentrantLock lockOne = new ReentrantLock();
    public static ReentrantLock lockTwo = new ReentrantLock();

    Logger log = LoggerFactory.getLogger("ThreadState");

    public void perform() throws InterruptedException { //Not For Production!
        Thread oneTwo = new Thread(this::oneTwo);
        Thread twoOne = new Thread(this::twoOne);

        oneTwo.start();
        twoOne.start();

//        oneTwo.join();

    }

    @SneakyThrows
    public void oneTwo() {
        for (int i = 0; i < 1_000_000; i++) {
            lockOne.lock();
                log.info(" Lock one");
                Thread.sleep(1);
                lockTwo.lock();
                    log.info(" Lock two");
                lockTwo.unlock();
            lockOne.unlock();
        }
    }

    @SneakyThrows
    public void twoOne() {
        for (int i = 0; i < 1_000_000; i++) {
            lockTwo.lock();
                log.info(" Lock two");
                Thread.sleep(1);
                lockOne.lock();
                    log.info(" Lock one");
                lockOne.unlock();
            lockTwo.unlock();
        }
    }
}
