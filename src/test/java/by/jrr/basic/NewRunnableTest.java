package by.jrr.basic;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class NewRunnableTest {

    @Test
    void run() {
        NewRunnable newRunnable = new NewRunnable();
        Thread thread = new Thread(newRunnable);
        thread.start();
    }

    @Test
    void anonymous() {
        Logger log = LoggerFactory.getLogger("anonymous");
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("new Runnable is running");
            }
        }).start();
    }

    @Test
    public void functionalApproach() {
        //todo: not shown in test log
        Thread thread = new Thread(() -> {
            Logger log = LoggerFactory.getLogger("lambda");
            log.info("new Runnable is running");
        });
        thread.start();
    }

    @Test
    public void functionalApproach2() {
        Logger log = LoggerFactory.getLogger("lambda");
        Thread thread = new Thread(() -> {
            log.info("new Runnable is running");
        });
        thread.start();
    }
}
