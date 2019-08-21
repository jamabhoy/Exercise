package com.mckenzie;

import org.junit.Test;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestProducerConsumer {

    private final Vector<Integer> sharedQueue = new Vector<Integer>(4);
    private final int queueSize = 4;

    @Test
    public void test1() {
        ExecutorService producers = Executors.newFixedThreadPool(3);
        ExecutorService consumers = Executors.newFixedThreadPool(3);

        producers.submit(new Producer(sharedQueue, queueSize));
        producers.submit(new Producer(sharedQueue, queueSize));
        producers.submit(new Producer(sharedQueue, queueSize));
        consumers.submit(new Consumer(sharedQueue, queueSize));
        consumers.submit(new Consumer(sharedQueue, queueSize));
        consumers.submit(new Consumer(sharedQueue, queueSize));

        producers.shutdown();
        consumers.shutdown();
        try {
            producers.awaitTermination(2, TimeUnit.SECONDS);
            consumers.awaitTermination(2, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.out.println("Interrupted wail awaiting termination");
        }
    }
}
