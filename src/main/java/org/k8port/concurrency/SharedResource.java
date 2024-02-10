package org.k8port.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    private int sharedValue = 0;
    private final Lock lock = new ReentrantLock();
    private final Semaphore semaphore = new Semaphore(1);

    public int getSharedValue() {
        return sharedValue;
    }

    public void incrementWithLock() {
        // Acquire lock to enter critical section
        lock.lock();
        try {
            sharedValue++;
            System.out.println(Thread.currentThread().getName() + " incremented: " + sharedValue);
        } finally {
            // Release lock to allow other threads entrance
            lock.unlock();
        }
    }

    public void incrementWithSemaphore() throws InterruptedException {
        //  Acquire permit from Semaphore
        semaphore.acquire();
        try {
            sharedValue++;
            System.out.println(Thread.currentThread().getName() + " incremented: " + sharedValue);
        } finally {
            // Release permit back to Semaphore
            semaphore.release();
        }
    }
}
