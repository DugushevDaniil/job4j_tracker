package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        int counter = 1;
        while (counter < count) {
            queue.poll();
            counter++;
        }
        String customer = queue.peek().name();
        queue.poll();
        return customer;
    }

    public String getFirstUpsetCustomer() {
        int counter = 1;
        while (counter <= count) {
            queue.poll();
            counter++;
        }
        return queue.peek().name();
    }
}