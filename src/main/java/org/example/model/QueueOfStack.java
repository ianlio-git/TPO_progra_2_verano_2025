package org.example.model;

public interface QueueOfStack {
    boolean queueIsEmpty();
    boolean stackIsFull();
    void add(int a);
    int getTop();
    void removeTop();
    int getSize();
}
