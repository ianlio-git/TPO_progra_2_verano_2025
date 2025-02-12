package org.example.model;

public class StaticStack implements Stack {

    private static final int MAX = 10000;

    private final int[] array;
    private int count;

    public StaticStack() {
        this.array = new int[MAX];
        this.count = 0;
    }

    @Override
    public int getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("getTop() called on empty stack");
        }
        return this.array[count - 1];
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public void add(int a) {
        this.array[count] = a;
        this.count++;
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("remove() called on empty stack");
        }
        this.count--;
    }

    public int getCount() {
        return count;
    }

}
