package com.mckenzie;

import java.util.concurrent.BlockingQueue;

public class BlockingConsumer implements  Runnable {

    BlockingQueue<Integer> sharedQueue;
    int queueSize;

    public BlockingConsumer(BlockingQueue<Integer> queue) {
        sharedQueue = queue;
    }

    public void run() {
        int item = -1;
        do {
            item = consume();
            System.out.println("Thread: " + Thread.currentThread().getName() + " received " + item + " from queue");
        }
        while (item != -1);
        return;
    }

    public int consume() {
        int val = -1;
        try {

            val = sharedQueue.take();
        }
        catch (InterruptedException e) {
            System.out.println("Thread: " + Thread.currentThread().getName() + " interrupted failed to remove from queue");
            System.out.println(e.getMessage());
            return -1;
        }

        return val;
    }

}
