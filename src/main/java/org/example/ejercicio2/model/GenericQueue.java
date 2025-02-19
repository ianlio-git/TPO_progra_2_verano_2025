package org.example.ejercicio2.model;

/**
 * Implementacion generica de la interfaz QueueT.
 *
 * Este GenericQueue utiliza un array de objetos para almacenar los elementos.
 */
public class GenericQueue<T> implements QueueT<T> {

    private static final int DEFAULT_MAX = 10000;
    private final Object[] array;
    private int count;

    /**
     * Constructor.
     * Pre: -
     * Post: Se crea una cola generica con capacidad DEFAULT_MAX.
     */
    public GenericQueue() {
        this.array = new Object[DEFAULT_MAX];
        this.count = 0;
    }

    /**
     * Retorna el primer elemento de la cola sin eliminarlo.
     * Pre: La cola no debe estar vacia.
     * Post: Retorna el primer elemento sin eliminarlo.
     *
     * @return el primer elemento de la cola.
     */
    @Override
    public T getFirst() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        return (T) this.array[0];
    }

    /**
     * Indica si la cola esta vacia.
     * Pre: No hay precondiciones.
     * Post: Retorna true si la cola esta vacia, false en caso contrario.
     * @return true si la cola esta vacia, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Agrega un elemento a la cola (al final).
     * Pre: Existe capacidad en la cola.
     * Post: Se agrega el elemento a la cola.
     * @param a el elemento a agregar.
     */
    @Override
    public void add(T a) {
        if(this.count >= DEFAULT_MAX) {
            throw new RuntimeException("Queue is full");
        }
        this.array[count] = a;
        this.count++;
    }

    /**
     * Remueve el primer elemento de la cola.
     * Pre: La cola no debe estar vacia.
     * Post: Se elimina el primer elemento de la cola.
     */
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
