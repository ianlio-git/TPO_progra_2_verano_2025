package org.example.ejercicio2.model;

/**
 * Interfaz que define la estructura de un Stack generico.
 */
public interface StackT<T> {
    /**
     * Retorna el elemento en la parte superior del stack.
     * Pre: El stack no debe estar vacio.
     * Post: Retorna el elemento superior sin eliminarlo.
     *
     * @return el elemento superior.
     */
    T getTop();

    /**
     * Indica si el stack esta vacio.
     * Pre: No hay precondiciones.
     * Post: Retorna true si el stack esta vacio, false de lo contrario.
     *
     * @return true si vacio, false si no.
     */
    boolean isEmpty();

    /**
     * Agrega un elemento al stack.
     * Pre: Debe haber capacidad para agregar un nuevo elemento.
     * Post: Se agrega el elemento a la parte superior del stack.
     *
     * @param a el elemento a agregar.
     */
    void add(T a);

    /**
     * Remueve el elemento en la parte superior del stack.
     * Pre: El stack no debe estar vacio.
     * Post: Se elimina el elemento superior.
     */
    void remove();
}
