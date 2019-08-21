package com.mckenzie;

import java.util.Vector;

public class Consumer implements  Runnable {

    Vector<Integer> sharedQueue;
    int queueSize;

    public Consumer(Vector<Integer> queue, int size) {
        sharedQueue = queue;
        queueSize=size;
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
            while (sharedQueue.isEmpty()) {
                synchronized (sharedQueue) {
                    sharedQueue.wait();
                }
            }

            synchronized (sharedQueue) {
                val = sharedQueue.remove(0);
                sharedQueue.notifyAll();
            }
        }
        catch (InterruptedException e) {
            System.out.println("Thread: " + Thread.currentThread().getName() + " interrupted failed to remove from queue");
            System.out.println(e.getMessage());
            return -1;
        }

        return val;
    }
}
