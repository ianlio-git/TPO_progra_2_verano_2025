package org.example.model;

public class StaticQueueOfStack implements QueueOfStack {
    private final int size;
    private int[][] queueOfStacks; // Matriz que almacena las pilas
    private int countStack; // Índice del último elemento en la pila actual
    private int countQueue; // Índice de la pila actual en la cola

    public StaticQueueOfStack(int n) {
        this.size = n;
        this.queueOfStacks = new int[n][n]; // Matriz cuadrada de tamaño n x n
        this.countQueue = 0; // Comienza en la primera pila
        this.countStack = 0; // Comienza sin elementos en la pila actual
    }

    @Override
    public boolean queueIsEmpty() {
        return countQueue == 0 && countStack == 0;
    }

    @Override
    public boolean stackIsFull() {
        return countStack == size;
    }



    @Override
    public void add(int a) {
        if (countQueue == size - 1 && countStack == size) {
            throw new IllegalStateException("La cola de pilas está llena");
        }
        if (countStack == size) {
            countQueue++;
            countStack = 0;
        }
        queueOfStacks[countQueue][countStack] = a;
        countStack++;
    }

    @Override
    public void removeTop() {
        if (queueIsEmpty()) {
            throw new IllegalStateException("La cola de pilas está vacía");
        }
        countStack--;
        if (countStack == 0) {
            // Si se vacía la pila actual, mover todo hacia arriba si hay más pilas
            if (countQueue > 0) {
                for (int i = 0; i < size; i++) {
                    queueOfStacks[0][i] = queueOfStacks[1][i];
                }
                for (int i = 1; i < countQueue; i++) {
                    for (int j = 0; j < size; j++) {
                        queueOfStacks[i][j] = queueOfStacks[i + 1][j];
                    }
                }
                countQueue--;
                countStack = size;
            }
        }
    }

    @Override
    public int getTop() {
        if (queueIsEmpty()) {
            throw new IllegalStateException("La cola de pilas está vacía");
        }
        return queueOfStacks[0][countStack - 1];
    }

    @Override
    public int getSize() {
        return size;
    }
}
