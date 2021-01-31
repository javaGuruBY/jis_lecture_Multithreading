package by.jrr.basic;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class HbReadWriteLock {


    public void perform() {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        readWriteLock.readLock().lock();
        // only read operations allows
        readWriteLock.readLock().unlock();

        readWriteLock.writeLock().lock();
        // only write operations allowed
        readWriteLock.writeLock().unlock();
    }
}
