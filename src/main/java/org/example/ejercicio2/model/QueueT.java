package org.example.ejercicio2.model;

/**
 * Interfaz que define la estructura de una cola genérica.
 */
public interface QueueT<T> {

    /**
     * Retorna el primer elemento de la cola sin eliminarlo.
     *
     * Pre: La cola no debe estar vacía.
     * Post: Se retorna el primer elemento de la cola.
     *
     * @return el primer elemento de la cola.
     */
    T getFirst();

    /**
     * Indica si la cola está vacía.
     *
     * Pre: No hay precondiciones.
     * Post: Retorna true si la cola está vacía, false en caso contrario.
     *
     * @return true si la cola está vacía; false, de lo contrario.
     */
    boolean isEmpty();

    /**
     * Agrega un nuevo elemento al final de la cola.
     *
     * Pre: Existe capacidad en la cola para agregar un nuevo elemento.
     * Post: Se agrega el elemento al final de la cola.
     *
     * @param a el elemento a agregar.
     */
    void add(T a);

    /**
     * Remueve el primer elemento de la cola.
     *
     * Pre: La cola no debe estar vacía.
     * Post: Se elimina el primer elemento de la cola.
     */
    void remove();
}
