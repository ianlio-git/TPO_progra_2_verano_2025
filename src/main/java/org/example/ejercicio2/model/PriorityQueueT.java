package org.example.ejercicio2.model;

/**
 * Interfaz que define la estructura de una cola con prioridad genérica.
 */
public interface PriorityQueueT<T, P> {

    /**
     * Retorna el primer elemento de la cola con prioridad sin eliminarlo.
     *
     * Pre: La cola no debe estar vacía.
     * Post: Retorna el primer elemento según la política de prioridad.
     *
     * @return el primer elemento de la cola.
     */
    T getFirst();

    /**
     * Retorna la prioridad asociada al primer elemento de la cola.
     *
     * Pre: La cola no debe estar vacía.
     * Post: Retorna la prioridad del primer elemento.
     *
     * @return la prioridad del primer elemento.
     */
    P getPriority();

    /**
     * Indica si la cola con prioridad está vacía.
     *
     * Pre: No hay precondiciones.
     * Post: Retorna true si la cola está vacía, false en caso contrario.
     *
     * @return true si la cola está vacía, false de lo contrario.
     */
    boolean isEmpty();

    /**
     * Agrega un elemento junto con su prioridad a la cola.
     *
     * Pre: La cola no debe estar llena.
     * Post: Se agrega el elemento junto con su prioridad en la posición correspondiente,
     *                de acuerdo a la política de prioridad.
     *
     * @param a el elemento a agregar.
     * @param priority la prioridad asociada al elemento.
     */
    void add(T a, P priority);

    /**
     * Remueve el primer elemento de la cola con prioridad.
     *
     * Pre: La cola no debe estar vacía.
     * Post: Se elimina el primer elemento de la cola.
     */
    void remove();
}
