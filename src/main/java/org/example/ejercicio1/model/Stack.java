package org.example.ejercicio1.model;

/**
 * Interfaz que representa una estructura Stack.
 */
public interface Stack {

    /**
     * Retorna el elemento que se encuentra en la parte superior del stack sin eliminarlo.
     *
     * Pre: El stack no debe estar vacío.
     * Post: Retorna el elemento superior sin removerlo.
     *
     * @return el elemento superior del stack.
     */
    int getTop();

    /**
     * Indica si el stack está vacío.
     *
     * Pre: No hay precondiciones.
     * Post: Retorna true si el stack está vacío, false en caso contrario.
     *
     * @return true si el stack está vacío, false de lo contrario.
     */
    boolean isEmpty();

    /**
     * Agrega el elemento 'a' a la parte superior del stack.
     *
     * Pre: El stack debe tener capacidad para agregar un nuevo elemento.
     * Post: Se agrega el elemento 'a' en la cima del stack.
     *
     * @param a el elemento a agregar.
     */
    void add(int a);

    /**
     * Remueve el elemento que se encuentra en la parte superior del stack.
     *
     * Pre: El stack no debe estar vacío.
     * Post: Se elimina el elemento superior del stack.
     */
    void remove();
}
