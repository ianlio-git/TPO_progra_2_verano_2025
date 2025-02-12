package org.example.model;

public interface QueueOfStack {
    Stack getFirst();
    void add(int a);
    void remove();
    boolean isQueueEmpty();
}
