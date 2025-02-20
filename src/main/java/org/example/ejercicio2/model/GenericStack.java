package org.example.ejercicio2.model;


public class GenericStack<T> implements StackT<T> {

    private static final int DEFAULT_MAX = 10000;
    private Object[] array;
    private int count;


    public GenericStack() {
        this.array = new Object[DEFAULT_MAX];
        this.count = 0;
    }


    @Override
    public T getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("getTop() called on empty stack");
        }
        return (T) this.array[count - 1];
    }


    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }


    @Override
    public void add(T a) {
        if (count >= DEFAULT_MAX) {
            throw new RuntimeException("Stack overflow");
        }
        this.array[count++] = a;
    }


    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("remove() called on empty stack");
        }
        count--;
    }
}
