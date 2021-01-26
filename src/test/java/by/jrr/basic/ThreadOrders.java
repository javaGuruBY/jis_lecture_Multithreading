package by.jrr.basic;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadOrders {

    Logger log = LoggerFactory.getLogger("ThreadState");

    @Test
    public void multipleThreads() {
        for (int i = 0; i< 100; i++) {
            new Thread(" littleTread # " + i) {
                public void run (){
                    log.info("Tread is running ");
                }
            }.start();
        }
    }

    @Test
    public void multipleThreadsPriority() throws InterruptedException {
        for (int i = 0; i< 100; i++) {
            while (i<25) {
                new Thread(" littleTread # " + i) {
                    @SneakyThrows
                    public void run (){
                        Thread.sleep(1000);
                        log.info("Tread is running [{}]", getPriority());
                    }
                }.start();
                i++;
            }

            while (i<50) {
                new Thread(" littleTread # " + i) {
                    @SneakyThrows
                    public void run (){
                        Thread.sleep(999);
                        setPriority(7);
                        log.info("Tread is running [{}]", getPriority());
                    }
                }.start();
                i++;
            }

            while (i<75) {
                new Thread(" littleTread # " + i) {
                    @SneakyThrows
                    public void run (){
                        Thread.sleep(998);
                        setPriority(Thread.MIN_PRIORITY);
                        log.info("Tread is running [{}]", getPriority());
                    }
                }.start();
                i++;
            }

            while (i<100) {
                new Thread(" littleTread # " + i) {
                    @SneakyThrows
                    public void run (){
                        Thread.sleep(990);
                        setPriority(Thread.MAX_PRIORITY);
                        log.info("Tread is running [{}]", getPriority());
                    }
                }.start();
                i++;
            }
        }
    }
}
