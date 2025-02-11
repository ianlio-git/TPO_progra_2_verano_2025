package org.example.model;

public class StaticQueueOfStack implements QueueOfStack {
    private final int size;
    private int[][] queueOfStacks;
    private int countStack;
    private int countQueue;

    /**
     * Constructor de la clase StaticQueueOfStack.
     * @param n Tamaño de la cola de pilas.
     */
    public StaticQueueOfStack(int n) {
        this.size = n;
        this.queueOfStacks = new int[n][n]; // Matriz cuadrada de tamaño n x n
        this.countQueue = 0;
        this.countStack = 0;
    }

    /**
     * Verifica si la cola de pilas está vacía.
     * @return true si la cola de pilas está vacía, false en caso contrario.
     */
    @Override
    public boolean queueIsEmpty() {
        return countQueue == 0 && countStack == 0;
    } // O(c) -> Complejidad constante, solo verifica el estado de las variables

    /**
     * Agrega un elemento a la pila actual en la cola.
     * @param a Elemento a agregar.
     * @throws IllegalStateException si la cola de pilas está llena.
     */
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
    } // O(c) -> Complejidad constante, solo verifica condiciones y agrega el elemento

    /**
     * Elimina el elemento superior de la pila actual.
     * @throws IllegalStateException si la cola de pilas está vacía.
     */
    @Override
    public void removeTop() {
        if (queueIsEmpty()) {
            throw new IllegalStateException("La cola de pilas está vacía");
        }
        countStack--;
        if (countStack == 0 && countQueue > 0) {
            for (int i = 0; i < countQueue; i++) {
                for (int j = 0; j < size; j++) {
                    queueOfStacks[i][j] = queueOfStacks[i + 1][j];
                }
            }
            countQueue--;
            countStack = size;
        }
    } // O(n) -> Complejidad lineal, En el peor caso, se mueve toda la cola (recorre todos los elementos)

    /**
     * Elimina la primera pila de la cola.
     * @throws IllegalStateException si la cola de pilas está vacía.
     */
    @Override
    public void removeQueue() {
        if (queueIsEmpty()) {
            throw new IllegalStateException("La cola de pilas está vacía");
        }
        if (countQueue > 0) {
            for (int i = 0; i < countQueue; i++) {
                for (int j = 0; j < size; j++) {
                    queueOfStacks[i][j] = queueOfStacks[i + 1][j];
                }
            }
            countQueue--;
            countStack = size;
            return;
        }
        countStack = 0;
    } // O(n) -> Complejidad lineal, En el peor caso, se mueve toda la cola (recorre todos los elementos)

    /**
     * Obtiene el elemento superior de la pila actual.
     * @return El elemento superior de la pila actual.
     * @throws IllegalStateException si la cola de pilas está vacía.
     */
    @Override
    public int getTop() {
        if (queueIsEmpty()) {
            throw new IllegalStateException("La cola de pilas está vacía");
        }
        return queueOfStacks[0][countStack - 1];
    } // O(c) -> Complejidad constante, solo accede al elemento superior de la pila

    /**
     * Obtiene el tamaño de la cola de pilas.
     * @return El tamaño de la cola de pilas.
     */
    @Override
    public int getSize() {
        return size;
    } // O(c) -> Complejidad constante, solo devuelve el tamaño de la cola
}
