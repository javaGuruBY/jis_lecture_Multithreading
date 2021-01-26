package by.jrr.waitnotify;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MyHouse {
    private boolean pizzaArrived = false;

    Logger log = LoggerFactory.getLogger("MyHouse");

    public void nevrotic() throws InterruptedException {
        Thread waiting = new Thread(() -> nerveousWaitingForPizza());
        Thread delivering = new Thread(() -> pizzaGuy());

        waiting.start();
        Thread.sleep(100);
        delivering.start();

        waiting.join();
    }

    public void normal() throws InterruptedException {
        Thread waiting = new Thread(() -> waitPizza());
        Thread delivering = new Thread(() -> pizzaGuy());

        waiting.start();
        Thread.sleep(100);
        delivering.start();

        waiting.join();
    }

    @SneakyThrows
    public void waitPizza() {
        synchronized (this) {
            while (!pizzaArrived) {
                log.info("waiting");
                wait();
            }
            log.info("pizza delivered!");
        }
        log.info("yumyum..");
    }

    @SneakyThrows
    public void nerveousWaitingForPizza(){
        while (!pizzaArrived) {
            log.info("waiting");
        }
        log.info("pizza delivered!");
        log.info("yumyum..");
    }

    public void pizzaGuy() {
        synchronized (this) {
            log.info("starting delivery");
            this.pizzaArrived = true;
            log.info("delivered");
            notifyAll();
            log.info("Notified");
        }
    }
}
