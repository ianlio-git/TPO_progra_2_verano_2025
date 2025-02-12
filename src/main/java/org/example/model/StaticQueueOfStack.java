package org.example.model;

public class StaticQueueOfStack implements QueueOfStack {

    private final int size;
    private final StaticStack[] array;
    private int countQueue;

    public StaticQueueOfStack(int n) {
        this.size = n;
        this.array = new StaticStack[size];
        this.countQueue = 0;
    }

    @Override
    public Stack getFirst() {
        if (this.isQueueEmpty()) {
            throw new RuntimeException("getFirst() called on empty QueueOfStack");
        }
        return this.array[0];
    }

    @Override
    public void add(int a) {
        if (this.isQueueFull()){
            throw new RuntimeException("add() called on full QueueOfStack");
        }

        // Inicializar la primera pila si es necesario
        if (this.isQueueNull()) {
            this.array[countQueue] = new StaticStack();
        }

        // Si la pila actual está llena, pasa a la siguiente
        if (this.isStackFull()) {
            countQueue++;
            this.array[countQueue] = new StaticStack();
        }

        // Agregar el elemento a la pila actual
        this.array[countQueue].add(a);
    }

    @Override
    public void remove() {
        if (this.isQueueEmpty()) {
            throw new RuntimeException("remove() called on empty QueueOfStack");
        }
        for (int i = 0; i < countQueue; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.array[countQueue] = null;
        countQueue--;

    }

    @Override
    public boolean isQueueEmpty() {
        return this.countQueue == 0 && this.array[0].isEmpty();
    }

    public int pop(){
        if (this.isStackEmpty()) {
            this.remove();
        }
        int a = this.getFirst().getTop();
        this.getFirst().remove();
        return a;
    }

    private boolean isQueueFull() {
        return countQueue == size - 1 && isStackFull();
    }
    private boolean isStackFull() {
        return  this.array[countQueue] != null && this.array[countQueue].getCount() == size;
    }
    private boolean isQueueNull(){
        return this.array[countQueue] == null;
    }
    private boolean isStackEmpty() {
        return this.getFirst().isEmpty();
    }
    public int getSize() {
        return size;
    }
}
