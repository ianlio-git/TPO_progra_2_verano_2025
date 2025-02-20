package org.example.ejercicio1.model;

/**
 * Interfaz que representa una estructura QueueOfStack.
 */
public interface QueueOfStack {

    /**
     * Retorna la primera pila de la QueueOfStack.
     *
     * Pre: La QueueOfStack no debe estar vacia.
     * Post: Retorna la primera pila (indice 0) sin eliminarla.
     *
     * @return la primera pila.
     */
    Stack getFirst();

    /**
     * Agrega un elemento a la QueueOfStack.
     *
     * Pre: La QueueOfStack no debe estar llena (existe capacidad para agregar un nuevo elemento).
     * Post: Se agrega el elemento a la pila actual; si la pila actual esta llena, se crea una nueva pila y se agrega ahi.
     *
     * @param a el elemento a agregar.
     */
    void add(Stack a);

    /**
     * Remueve la primera pila de la QueueOfStack.
     *
     * Pre: La QueueOfStack no debe estar vacia.
     * Post: Se elimina la primera pila (indice 0) de la QueueOfStack.
     */
    void remove();

    /**
     * Indica si la QueueOfStack esta vacia.
     *
     * Pre: No hay precondiciones.
     * Post: Retorna true si la QueueOfStack esta vacia (es decir, si la primera pila es nula o esta vacia),
     *       false en caso contrario.
     *
     * @return true si la QueueOfStack esta vacia, false en caso contrario.
     */
    boolean isQueueEmpty();

}
