package by.jrr.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class SemaphoreEx {

    Logger log = LoggerFactory.getLogger("SemaphoreEx");

    Semaphore writingSemaphore = new Semaphore(1);
    Semaphore readingSemaphore = new Semaphore(10);

    List<Thread> threads = new ArrayList<>();
    List<Object> sharedCollection = new ArrayList<>();

    public void perform() {

        for (int i = 0; i < 100; i++) {
            Thread reader = new Thread(logTotalElements());
            Thread writer = new Thread(addElement());
            reader.setName(String.format("Reader #%s", i));
            writer.setName(String.format("Writer #%s", i));
            threads.add(reader);
            threads.add(writer);
        }

        threads.forEach((Thread::start));
        threads.forEach((thread) -> {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        log.info("Result {}", sharedCollection.size());
    }

    private Runnable logTotalElements() {
        return () -> {
            try {
                log.info("[>>READ] waiting reading permit. Available permits {}", readingSemaphore.availablePermits());
                readingSemaphore.acquire();
                log.info("[!READ!] has reading permit. Permits left {}", readingSemaphore.availablePermits());
                log.info("[READ...] Number of elements: {}", sharedCollection.size());
                if(Thread.currentThread().getName().equals("Reader #45")) {
                    readingSemaphore.drainPermits();
                    log.info("[drained]");
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                readingSemaphore.release();
                log.info("[READ>>] lock released. Available permits {}", readingSemaphore.availablePermits());
            }
        };
    }

    private Runnable addElement() {
        return () -> {
            try {
                log.info("[>>WRITE] is waiting writing permit. Available permits {}", writingSemaphore.availablePermits());
                writingSemaphore.acquire();
                log.info("[!WRITE!] has writing permit. Permits left {}", writingSemaphore.availablePermits());
                sharedCollection.add(new Object());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                writingSemaphore.release();
                log.info("[WRITE>>] lock released. Available permits {}", writingSemaphore.availablePermits());
            }
        };
    }
}
