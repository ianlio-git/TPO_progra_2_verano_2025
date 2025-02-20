package org.example.ejercicio1.model;

public class StaticQueueOfStack implements QueueOfStack {

    final int maxStacks;
    final StaticStack[] array;
    int count;

    public StaticQueueOfStack(int maxStacks) {
        if (maxStacks <= 2) {
            throw new IllegalArgumentException("El número de pilas debe ser mayor o igual a 2");
        }
        this.maxStacks = maxStacks;
        this.array = new StaticStack[maxStacks];
        this.count = 0;
    }

    @Override
    public Stack getFirst() {
        if (isQueueEmpty()) {
            throw new RuntimeException("QueueOfStack vacía");
        }
        return array[0];
    }

    @Override
    public void add(Stack s) {
        if (count >= maxStacks) {
            throw new RuntimeException("QueueOfStack llena");
        }
        if (s == null) {
            throw new RuntimeException("Null elemento");
        }
        array[count] = (StaticStack) s;
        count++;
    }

    @Override
    public void remove() {
        if (isQueueEmpty()) {
            throw new RuntimeException("QueueOfStack vacía");
        }
        for (int i = 0; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        array[count - 1] = null;
        count--;
    }

    @Override
    public boolean isQueueEmpty() {
        return count == 0 ;
    }
}