package org.k8port.concurrency;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SharedResourceTest {

    private static SharedResource sharedResource;
    private static ExecutorService executorService;

    @BeforeAll
    public static void setUp() {
        sharedResource = new SharedResource();
        executorService = Executors.newFixedThreadPool(2);
    }

    @AfterAll
    public static void tearDown() {
        executorService.shutdown();
    }

    private static void run() {
        try {
            sharedResource.incrementWithSemaphore();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSemaphoreIncrementTask() {
        // Create two tasks for incrementing with Semaphore
        Runnable semaphoreIncrementTask = SharedResourceTest::run;

        // Start two threads executing task
        executorService.submit(semaphoreIncrementTask);
        executorService.submit(semaphoreIncrementTask);

        // Wait for threads to finish
        executorService.shutdown();
        while (!executorService.isTerminated() ) {
            // Wait
            System.out.println("...waiting");
        }

        // Assert final value of sharedResource
        assertEquals(2, sharedResource.getSharedValue());
    }

    @Test
    public void testLockIncrementTask() {
        // Create two tasks for incrementing with lock
        Runnable lockIncrementTask = () -> sharedResource.incrementWithLock();

        // Start two threads executing lockIncrementTask
        executorService.submit(lockIncrementTask);
        executorService.submit(lockIncrementTask);

        // Wait for threads to finish
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // Wait
            System.out.println("...waiting");
        }

        // Assert final value of sharedResource
        assertEquals(2, sharedResource.getSharedValue());
    }

}

