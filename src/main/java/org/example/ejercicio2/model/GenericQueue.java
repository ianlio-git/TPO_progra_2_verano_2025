package org.example.ejercicio2.model;

/**
 * Implementacion generica de la interfaz QueueT.
 */
public class GenericQueue<T> implements QueueT<T> {

    private static final int DEFAULT_MAX = 10000;
    private final Object[] array;
    private int count;


    public GenericQueue() {
        this.array = new Object[DEFAULT_MAX];
        this.count = 0;
    }


    @Override
    public T getFirst() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        return (T) this.array[0];
    }


    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }


    @Override
    public void add(T a) {
        if(this.count >= DEFAULT_MAX) {
            throw new RuntimeException("Queue is full");
        }
        this.array[count] = a;
        this.count++;
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar de una cola vacia");
        }
        // Desplazar elementos a la izquierda.
        for (int i = 0; i < this.count - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.count--;
    }
}
