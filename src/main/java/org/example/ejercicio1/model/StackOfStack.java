package org.example.ejercicio1.model;

/**
 * Interfaz que define una estructura de "pila de pilas" (StackOfStack).
 */
public interface StackOfStack {

    /**
     * Retorna la pila que está en la parte superior sin removerla.
     *
     * Pre: La estructura no debe estar vacía.
     * Post: Retorna la pila superior.
     *
     * @return la pila que está en la parte superior.
     */
    Stack getTop();

    /**
     * Indica si la estructura de pila de pilas está vacía.
     *
     * Pre: No tiene precondiciones.
     * Post: Retorna true si la estructura está vacía; false en caso contrario.
     *
     * @return true si está vacía, false de lo contrario.
     */
    boolean isEmpty();

    /**
     * Agrega la pila s a la estructura.
     *
     * Pre: s no debe ser null.
     * Post: Se agrega la pila s a la estructura.
     *
     * @param s la pila a agregar.
     */
    void add(Stack s);

    /**
     * Remueve la pila que está en la parte superior de la estructura.
     *
     * Pre: La estructura no debe estar vacía.
     * Post: Remueve la pila superior.
     */
    void remove();
}
