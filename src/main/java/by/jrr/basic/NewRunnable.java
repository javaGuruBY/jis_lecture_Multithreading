package by.jrr.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewRunnable implements Runnable{

    Logger log = LoggerFactory.getLogger(NewThread.class);

    @Override
    public void run() {
        log.info("new Runnable is running");
    }
}
