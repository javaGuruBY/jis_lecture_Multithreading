package by.jrr.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewThread extends Thread {

    public NewThread(String name) {
        super(name);
    }

    Logger log = LoggerFactory.getLogger(NewThread.class);

    @Override
    public void run() {
        log.info("MyThread is running");
    }
}
