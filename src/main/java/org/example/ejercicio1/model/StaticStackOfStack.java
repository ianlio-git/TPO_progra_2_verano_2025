package org.example.ejercicio1.model;

public class StaticStackOfStack implements StackOfStack {

    private static final int MAX = 10000;
    private final Stack[] array;
    private int count;

    public StaticStackOfStack() {
        this.array = new StaticStack[MAX];
        this.count = 0;
    }

    @Override
    public Stack getTop() {
        if (isEmpty()) {
            throw new RuntimeException("StackOfStack vacío");
        }
        return array[count - 1];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void add(Stack s) {
        if (s == null) {
            throw new IllegalArgumentException("No se puede agregar un stack null");
        }
        if (count >= MAX) {
            throw new RuntimeException("StackOfStack está lleno");
        }
        array[count] = s;
        count++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("StackOfStack vacío");
        }
        array[count - 1] = null;
        count--;
    }
}
