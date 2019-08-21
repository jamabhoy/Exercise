package com.mckenzie;

import java.util.Vector;

public class LockFreeProducer  implements Runnable {

    Vector<Integer> sharedQueue;
    int queueSize;

    public LockFreeProducer(Vector<Integer> queue, int size) {
        sharedQueue = queue;
        queueSize=size;
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
            while (sharedQueue.size() == queueSize) {
                Thread.sleep(10);
            }
            sharedQueue.add(i);
        }
        catch (InterruptedException e) {
            System.out.println("Thread: " + Thread.currentThread().getName() + " interrupted failed to add to queue");
            System.out.println(e.getMessage());
        }
    }

}
