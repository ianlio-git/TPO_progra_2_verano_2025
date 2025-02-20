package org.example.ejercicio3.model;

/**
 * Interfaz que define la estructura de una QueueOfQueue.
 */
public interface QueueOfQueue {

    /**
     * Retorna la primera Queue sin eliminarla.
     *
     * Pre: La QueueOfQueue no debe estar vacía.
     * Post: Retorna la primera Queue.
     *
     * @return la primera Queue.
     */
    Queue getFirst();

    /**
     * Indica si la QueueOfQueue está vacía.
     *
     * Pre: -
     * Post: Retorna true si la QueueOfQueue está vacía; false en caso contrario.
     *
     * @return true si vacía, false de lo contrario.
     */
    boolean isEmpty();

    /**
     * Agrega la Queue q al final de la QueueOfQueue.
     *
     * Pre: La QueueOfQueue tiene capacidad para agregar un nuevo elemento.
     * Post: Se agrega la Queue q al final.
     *
     * @param q la Queue a agregar.
     */
    void add(Queue q);

    /**
     * Remueve la primera Queue de la QueueOfQueue.
     *
     * Pre: La QueueOfQueue no debe estar vacía.
     * Post: Se elimina la primera Queue.
     */
    void remove();

    /**
     * Concatena múltiples instancias de QueueOfQueue en una nueva.
     *
     * Pre: Se reciben instancias de QueueOfQueue.
     * Post: Retorna una nueva QueueOfQueue que contiene todos los elementos de las instancias
     *       pasadas, manteniendo el orden en que se leyeron.
     *
     * @param queues las instancias de QueueOfQueue a concatenar.
     * @return una nueva QueueOfQueue con todos los elementos.
     */
    QueueOfQueue concatenate(QueueOfQueue... queues);

    /**
     * Aplana la QueueOfQueue en una única Queue.
     *
     * Pre: -
     * Post: Retorna una Queue (por ejemplo, StaticQueue) que contiene todos los elementos de cada Queue interna,
     *       manteniendo el orden.
     *
     * @return una Queue con todos los elementos.
     */
    Queue flat();

    /**
     * Invierte la QueueOfQueue y, además, invierte cada Queue interna.
     *
     * Pre: -
     * Post: Retorna una nueva QueueOfQueue en la que el orden de las Queue se invierte y cada Queue interna también se invierte.
     *
     * @return una nueva QueueOfQueue invertida.
     */
    QueueOfQueue reverseWithDepth();
}
