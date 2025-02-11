package org.example.model;

/**
 * Interfaz QueueOfStack que define el comportamiento de una estructura de datos
 * que combina características de una cola y una pila.
 */
public interface QueueOfStack {

    /**
     * Agrega un elemento a la estructura.
     * @param a El elemento entero que se agregará.
     */
    void add(int a);

    /**
     * Obtiene el elemento en la cima de la pila sin eliminarlo.
     * @return El valor del elemento en la cima.
     */
    int getTop();

    /**
     * Elimina el elemento en la cima de la pila.
     */
    void removeTop();

    /**
     * Elimina el primer elemento de la cola.
     */
    void removeQueue();

    /**
     * Obtiene el número de elementos en la estructura.
     * al definir la matriz nxn en el cons
     * @return El tamaño actual de la estructura.
     */
    int getSize();

    /**
     * Verifica si la estructura está vacía.
     * @return true si la estructura no contiene elementos, false en caso contrario.
     */
    boolean queueIsEmpty();


}
