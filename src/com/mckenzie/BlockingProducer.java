package com.mckenzie;

import java.util.concurrent.BlockingQueue;

public class BlockingProducer implements Runnable {

    BlockingQueue<Integer> sharedQueue;
    int queueSize;

    public BlockingProducer(BlockingQueue<Integer> queue) {
        sharedQueue = queue;
    }
    public void run() {

        for (int i = 0; i <= 100; ++i) {
            System.out.println("Thread: " + Thread.currentThread().getName() + " adding " + i + " to queue");
            produce(i);
        }
        produce(-1);
        return;
    }

    private void produce(int i) {
        try {
            sharedQueue.put(i);
        }
        catch (InterruptedException e) {
            System.out.println("Thread: " + Thread.currentThread().getName() + " interrupted failed to add to queue");
            System.out.println(e.getMessage());
        }
    }
}
