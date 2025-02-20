package org.example.ejercicio2.model;


public class GenericPriorityQueue<T, P extends Comparable<P>> implements PriorityQueueT<T, P> {
    private static final int MAX = 10000;
    private final Object[] values;
    private final Object[] priorities;
    private int count;

    public GenericPriorityQueue() {
        this.values = new Object[MAX];
        this.priorities = new Object[MAX];
        this.count = 0;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el valor de una cola vacía");
        }
        return (T) this.values[0];
    }

    @Override
    public P getPriority() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener la prioridad de una cola vacía");
        }
        return (P) this.priorities[0];
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public void add(T a, P priority) {
        if (this.count == MAX) {
            throw new RuntimeException("No se tiene capacidad para almacenar un nuevo elemento");
        }
        if (a == null) {
            throw new IllegalArgumentException("No se puede agregar un elemento null");
        }
        if (isEmpty()) {
            this.values[0] = a;
            this.priorities[0] = priority;
            this.count = 1;
            return;
        }
        if (((P) this.priorities[this.count - 1]).compareTo(priority) <= 0) {
            this.values[count] = a;
            this.priorities[count] = priority;
            this.count++;
            return;
        }
        if (((P) this.priorities[0]).compareTo(priority) > 0) {
            for (int i = this.count - 1; i >= 0; i--) {
                this.values[i + 1] = this.values[i];
                this.priorities[i + 1] = this.priorities[i];
            }
            this.values[0] = a;
            this.priorities[0] = priority;
            this.count++;
            return;
        }
        int index = findIndex(priority);
        if (index != -1) {
            int candidate = index;
            while (candidate < this.count && ((P) this.priorities[candidate]).compareTo(priority) == 0) {
                candidate++;
            }
            for (int i = this.count - 1; i >= candidate; i--) {
                this.values[i + 1] = this.values[i];
                this.priorities[i + 1] = this.priorities[i];
            }
            this.values[candidate] = a;
            this.priorities[candidate] = priority;
            this.count++;
            return;
        }
        int candidate = 0;
        while (candidate < this.count && ((P) this.priorities[candidate]).compareTo(priority) <= 0) {
            candidate++;
        }
        for (int i = this.count - 1; i >= candidate; i--) {
            this.values[i + 1] = this.values[i];
            this.priorities[i + 1] = this.priorities[i];
        }
        this.values[candidate] = a;
        this.priorities[candidate] = priority;
        this.count++;
    }

    private int findIndex(P priority) {
        for (int i = 0; i < this.count; i++) {
            if (((P) this.priorities[i]).compareTo(priority) == 0) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacía");
        }
        for (int i = 0; i < this.count - 1; i++) {
            this.values[i] = this.values[i + 1];
            this.priorities[i] = this.priorities[i + 1];
        }
        this.count--;
    }
}
