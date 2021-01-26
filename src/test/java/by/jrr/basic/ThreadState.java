package by.jrr.basic;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadState {

    Logger log = LoggerFactory.getLogger("ThreadState");

    @Test //IllegalThreadStateException
    public void state() throws InterruptedException {
        NewThread thread = new NewThread("my-1");
        log.info(thread.getState().toString());
        thread.start();
        log.info(thread.getState().toString());
        thread.join();
        log.info(thread.getState().toString());
        thread.start();
        thread.start();
    }
}
