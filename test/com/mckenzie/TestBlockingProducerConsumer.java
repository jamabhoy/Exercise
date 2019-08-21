package com.mckenzie;

import org.junit.Test;

import java.util.Vector;
import java.util.concurrent.*;

public class TestBlockingProducerConsumer {
    private final BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>(4);
    private final int queueSize = 4;

    @Test
    public void test1() {
        ExecutorService producers = Executors.newFixedThreadPool(3);
        ExecutorService consumers = Executors.newFixedThreadPool(3);

        producers.submit(new BlockingProducer(sharedQueue));
        producers.submit(new BlockingProducer(sharedQueue));
        producers.submit(new BlockingProducer(sharedQueue));
        consumers.submit(new BlockingConsumer(sharedQueue));
        consumers.submit(new BlockingConsumer(sharedQueue));
        consumers.submit(new BlockingConsumer(sharedQueue));

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
