package by.jrr.basic;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class ConcurrentCollection {

        Map<String, Long> numbers = new ConcurrentHashMap<>();
//        Map<String, Long> numbers = new HashMap<>();
        Long total = 0L;

        public void perform() throws InterruptedException {
//        ExecutorService pool = Executors.newFixedThreadPool(199);
//        for (int i = 0; i < 1000; i++) {
//            pool.submit(() -> numbers.put(LocalDateTime.now().toString(),
//                    ThreadLocalRandom.current().nextLong(1, 100)));  //new Runnable
//            pool.submit(() -> numbers.forEach((a, b) -> total = total + b));
//        }

            Runnable putting = () -> numbers.put(LocalDateTime.now().toString(),
                    ThreadLocalRandom.current().nextLong(1, 100));
            Runnable counting = () -> numbers.forEach((a, b) -> total = total + b);

            for (int i = 0; i < 1000; i++) {
                new Thread(putting).start();
                new Thread(counting).start();
            }
        }
    }
