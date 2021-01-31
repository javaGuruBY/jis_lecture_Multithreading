package by.jrr.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HappensBeforeReentrantLock {

    Logger log = LoggerFactory.getLogger(NewThread.class);
    ReentrantLock lock_1 = new ReentrantLock();
//    ReentrantLock lock_2 = new ReentrantLock();

    public static int counter = 0;

    public void perform() throws InterruptedException {
        var thread = new Thread(job());

        log.info("Step 1");

        lock_1.lock();
        {
            thread.start();
            log.info("Step 2");
            Thread.sleep(ThreadLocalRandom.current().nextInt(600));
            log.info("Step 3");
        }
        lock_1.unlock();

        thread.join();

        log.info("Step 4");
    }

    private Runnable job() {
        return () -> {
            lock_1.lock();
            log.info("1. this always happens after Step 3");
            log.info("2. this always happens before Step 4");
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(100));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            log.info("3. job finished always happens after Step 3");
            log.info("4. job finished always happens before Step 4");
            lock_1.unlock();
        };
    }

    public void tryCatchFinallyExample() throws InterruptedException {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                lock1.lock();
                try {
                    counter++;
                    Thread.sleep(0);
                    log.info("{}", counter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock1.unlock();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                lock2.lock();
                try {
                    counter--;
                    Thread.sleep(0);
                    log.info("{}", counter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock2.unlock();
                }
            }
        });

        t1.start();
        t2.start();

        t2.interrupt();

        t1.join();
        t2.join();

        log.info("{}", counter);
    }

    public void syntax() throws InterruptedException {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Object obj1 = new Object();
        Object obj2 = new Object();


        Thread t1 = new Thread(() -> {
            synchronized (obj1) {
                log.info("{}", counter);
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (obj1) {
                log.warn("{}", counter);
            }
        });

        Thread t3 = new Thread(() -> {
            lock1.lock();
            {
                log.info("{}", counter);
            }
            lock1.unlock();
        });
        Thread t4 = new Thread(() -> {
            lock1.lock();
            {
                log.warn("{}", counter);
            }
            lock1.unlock();
        });

        t1.start();
        t2.start();

        t3.start();
        t4.start();
    }
}
