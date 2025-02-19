package org.example.ejercicio1.model;


public class StaticQueueOfStack implements QueueOfStack {

    private final int size;
    private final StaticStack[] array;
    private int countQueue;

    /**
     * Constructor que inicializa la QueueOfStack con la dimension n.
     * Pre: n debe ser mayor que 0.
     * Post: Se crea una QueueOfStack con n posiciones.
     *
     * @param n la dimension de la matriz (numero de pilas)
     */
    public StaticQueueOfStack(int n) {
        this.size = n; // O(c)
        this.array = new StaticStack[size]; // O(c)
        this.countQueue = 0; // O(c)
    }

    /**
     * Retorna la primera pila de la QueueOfStack.
     * Pre: La QueueOfStack no debe estar vacia.
     * Post: Retorna la pila ubicada en el indice 0.
     *
     * @return la primera pila.
     */
    @Override
    public Stack getFirst() {
        if (this.isQueueEmpty()) { // O(c)
            throw new RuntimeException("getFirst() called on empty QueueOfStack"); // O(c)
        }
        return this.array[0]; // O(c)
    }

    /**
     * Agrega un elemento a la QueueOfStack.
     * Pre: La QueueOfStack no debe estar llena.
     * Post: Se agrega el elemento a la pila actual; si esta llena, se crea una nueva pila.
     *
     * @param a el elemento a agregar.
     */
    @Override
    public void add(int a) {
        if (this.isQueueFull()) { // O(c)
            throw new RuntimeException("add() called on full QueueOfStack"); // O(c)
        }

        // Inicializar la pila actual si es necesario.
        if (this.isQueueNull()) { // O(c)
            this.array[countQueue] = new StaticStack(); // O(c)
        }

        // Si la pila actual esta llena, pasa a la siguiente.
        if (this.isStackFull()) { // O(c)
            countQueue++; // O(c)
            this.array[countQueue] = new StaticStack(); // O(c)
        }

        // Agregar el elemento a la pila actual.
        this.array[countQueue].add(a); // O(c)
    }

    /**
     * Remueve la primera pila de la QueueOfStack.
     * Pre: La QueueOfStack no debe estar vacia.
     * Post: Se elimina la primera pila (indice 0) de la QueueOfStack.
     */
    @Override
    public void remove() {
        if (this.isQueueEmpty()) { // O(c)
            throw new RuntimeException("remove() called on empty QueueOfStack"); // O(c)
        }

        // Caso: solo hay una pila (indice 0).
        if (countQueue == 0) { // O(c)
            this.array[0] = null; // O(c)
            return; // O(c)
        }

        // Caso: hay mas de una pila; desplazar todas una posicion hacia la izquierda.
        for (int i = 0; i < countQueue; i++) { // O(n) (n: cantidad de pilas)
            this.array[i] = this.array[i + 1]; // O(c)
        }
        this.array[countQueue] = null; // O(c)
        countQueue--; // O(c)
    }

    /**
     * Indica si la QueueOfStack esta vacia.
     * Pre: No hay precondiciones.
     * Post: Retorna true si la primera pila es nula o esta vacia; false en caso contrario.
     *
     * @return true si la QueueOfStack esta vacia, false de lo contrario.
     */
    @Override
    public boolean isQueueEmpty() {
        // Si hay mas de una pila en uso, la cola no esta vacia.
        if (countQueue > 0) { // O(c)
            return false; // O(c)
        }
        // Si solo hay una pila, la cola esta vacia si esa pila es nula o esta vacia.
        return (this.array[0] == null || this.array[0].isEmpty()); // O(c)
    }

    /**
     * Realiza un pop en la primera pila de la QueueOfStack.
     * Pre: La QueueOfStack no debe estar vacia.
     * Post: Retorna el elemento tope de la primera pila y lo elimina.
     *
     * @return el elemento tope de la primera pila.
     */
    public int pop(){
        if (this.isStackEmpty()) { // O(c)
            this.remove(); // O(c)
        }
        int a = this.getFirst().getTop(); // O(c)
        this.getFirst().remove(); // O(c)
        return a; // O(c)
    }

    // Metodos privados auxiliares

    /**
     * Retorna true si la QueueOfStack esta llena.
     *
     * @return true si esta llena, false en caso contrario.
     */
    private boolean isQueueFull() {
        return countQueue == size - 1 && isStackFull(); // O(c)
    }

    /**
     * Retorna true si la pila actual esta llena.
     *
     * @return true si la pila actual esta llena, false en caso contrario.
     */
    private boolean isStackFull() {
        return this.array[countQueue] != null && this.array[countQueue].getCount() == size; // O(c)
    }

    /**
     * Retorna true si la pila en la posicion actual es nula.
     *
     * @return true si la pila actual es nula, false en caso contrario.
     */
    private boolean isQueueNull(){
        return this.array[countQueue] == null; // O(c)
    }

    /**
     * Retorna true si la primera pila esta vacia.
     *
     * @return true si la primera pila esta vacia, false en caso contrario.
     */
    private boolean isStackEmpty() {
        return this.getFirst().isEmpty(); // O(c)
    }

    /**
     * Retorna la dimension de la QueueOfStack.
     *
     * @return el tamaño.
     */
    public int getSize() {
        return size; // O(c)
    }
}
