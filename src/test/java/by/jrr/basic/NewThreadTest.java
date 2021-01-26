package by.jrr.basic;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

class NewThreadTest {

    Logger log = LoggerFactory.getLogger(NewThreadTest.class);

    @Test
    void run() {
        NewThread newThread1 = new NewThread("my-1");
        NewThread newThread2 = new NewThread("my-2");
        NewThread newThread3 = new NewThread("my-3");
        newThread1.start();
        newThread2.start();
        newThread3.start();

        List.of(new NewThread("my-4"),
                new NewThread("my-5"),
                new NewThread("my-6"))
                .forEach(Thread::start);
    }

    @Test
    void threadInPlace() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                log.info("anonymous thread is running " + getName());
            }
        };

        thread.start();
        log.info(Thread.currentThread().getName());

        new Thread() {
            @Override
            public void run() {
                log.info("no class no link is running " + getName());
            }
        }.start();
    }


}
