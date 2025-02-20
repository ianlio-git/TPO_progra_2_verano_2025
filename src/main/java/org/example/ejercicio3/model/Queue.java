package org.example.ejercicio3.model;

/**
 * Interfaz que representa una estructura Queue.
 */
public interface Queue {

    /**
     * Retorna el primer elemento de la cola sin eliminarlo.
     *
     * Pre: La cola no debe estar vacía.
     * Post: Retorna el primer elemento de la cola.
     *
     * @return el primer elemento de la cola.
     */
    int getFirst();

    /**
     * Indica si la cola está vacía.
     *
     * Pre: No hay precondiciones.
     * Post: Retorna true si la cola está vacía, false en caso contrario.
     *
     * @return true si la cola está vacía, false en caso contrario.
     */
    boolean isEmpty();

    /**
     * Agrega el elemento 'a' al final de la cola.
     *
     * Pre: La cola debe tener capacidad para agregar un nuevo elemento.
     * Post: Se agrega el elemento 'a' al final de la cola.
     *
     * @param a el elemento a agregar.
     */
    void add(int a);

    /**
     * Remueve el primer elemento de la cola.
     *
     * Pre: La cola no debe estar vacía.
     * Post: Se elimina el primer elemento de la cola.
     */
    void remove();
}
