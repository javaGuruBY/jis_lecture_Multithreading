package by.jrr;

import by.jrr.basic.ConcurrentCollection;
import by.jrr.basic.DeadLock;
import by.jrr.basic.ThreadPoolEx;

import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws InterruptedException {

        ConcurrentCollection concurrentCollection = new ConcurrentCollection();
        concurrentCollection.perform();

    }
    private void shutdowingExecutor() {


        ThreadPoolEx.schedulled();

        try{
            System.out.println("shutdown");
            ThreadPoolEx.scheduledThreadPool.shutdown();
            System.out.println("awaiting");
            ThreadPoolEx.scheduledThreadPool.awaitTermination(5, TimeUnit.SECONDS);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("shutdownNow");
            ThreadPoolEx.scheduledThreadPool.shutdownNow();
        }
    }
}
