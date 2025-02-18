package org.example.ejercicio3.model;

/**
 * Interfaz que define la estructura de una QueueOfQueue.
 *
 * Cada metodo cuenta con pre y post condiciones:
 *

 *
 * isEmpty():
 *   Pre: -
 *   Post: Retorna true si la QueueOfQueue esta vacia; false en caso contrario.
 *
 * add(Queue q):
 *   Pre: -
 *   Post: Agrega la Queue q al final de la QueueOfQueue.
 *
 * remove():
 *   Pre: La QueueOfQueue no debe estar vacia.
 *   Post: Remueve la primera Queue de la QueueOfQueue.
 *
 * concatenate(QueueOfQueue... queues):
 *   Pre: Se reciben instancias de QueueOfQueue.
 *   Post: Retorna una nueva instancia de QueueOfQueue que contiene todos los elementos de las instancias
 *         pasadas, en el orden en que se leyeron.
 *
 * flat():
 *   Pre: -
 *   Post: Retorna una Queue (StaticQueue) que contiene todos los elementos de las Queue internas,
 *         manteniendo el orden.
 *
 * reverseWithDepth():
 *   Pre: -
 *   Post: Retorna una nueva QueueOfQueue en la que el orden de las Queue se invierte, y ademas, cada
 *         Queue interna se invierte.
 */
public interface QueueOfQueue {

    Queue getFirst();
    boolean isEmpty();
    void add(Queue q);
    void remove();

    QueueOfQueue concatenate(QueueOfQueue... queues);
    Queue flat();
    QueueOfQueue reverseWithDepth();
}
