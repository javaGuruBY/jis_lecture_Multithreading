package by.jrr.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

public class HappensBefore {

    Logger log = LoggerFactory.getLogger(NewThread.class);

    public void perform() throws InterruptedException {
        var thread = new Thread(job());

        log.info("Step 1");

        thread.start();

        log.info("Step 2");

        Thread.sleep(ThreadLocalRandom.current().nextInt(100));

        log.info("Step 3");

        thread.join();

        log.info("Step 4");
    }

    private Runnable job() {
        return () -> {
            log.info("this always happens before Step 4");
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(600));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            log.info("job finished always happens before Step 4");
        };
    }
}
