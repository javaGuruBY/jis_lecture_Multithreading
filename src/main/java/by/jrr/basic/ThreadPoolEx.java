package by.jrr.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolEx {

    Logger log = LoggerFactory.getLogger("ThreadPoolEx");

    ExecutorService singleEecutorService = Executors.newSingleThreadExecutor();
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    public static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
    public static ExecutorService steelingPool = Executors.newWorkStealingPool(2);

    public void perform() throws InterruptedException {

        for(Thread thread : getTreads(100)) {
            executorService.submit(thread);
        }
        log.info("jobs are finished");

    }

    public static void schedulled() {
        scheduledThreadPool.schedule(() -> System.out.println("ping google.com"), 2, TimeUnit.SECONDS);
        scheduledThreadPool.scheduleAtFixedRate(() -> System.out.println("ping yandex.ru"), 0,2, TimeUnit.SECONDS);
        scheduledThreadPool.scheduleWithFixedDelay(() -> System.out.println("ping amazon.com"), 3,2, TimeUnit.SECONDS);
    }

    private Runnable getTask() {
        return () -> {
            try{
                Thread.sleep(300);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            log.info("running {}", Thread.currentThread().getName());
        };
    }

    private List<Thread> getTreads(int i) {
        List<Thread> treadList = new ArrayList<>();
        while (i-- > 0) {
            treadList.add(new Thread(getTask(), "my #%s, i"));

        }
        return treadList;
    }
}
