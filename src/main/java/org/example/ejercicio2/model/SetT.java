package org.example.ejercicio2.model;

/**
 * Interfaz que define la estructura de un conjunto (Set) genérico.
 */
public interface SetT<T> {

    /**
     * Agrega un elemento al conjunto.
     *
     * Precondición: No hay precondiciones.
     * Postcondición: El elemento se agrega al conjunto.
     */
    void add(T a);

    /**
     * Remueve un elemento del conjunto.
     *
     * Precondición: El elemento a remover debe existir en el conjunto.
     * Postcondición: El elemento se elimina del conjunto.
     */
    void remove(T a);

    /**
     * Indica si el conjunto está vacío.
     *
     * Precondición: No hay precondiciones.
     * Postcondición: Retorna true si el conjunto está vacío, false en caso contrario.
     *
     * @return true si el conjunto está vacío, false de lo contrario.
     */
    boolean isEmpty();

    /**
     * Retorna un elemento del conjunto de forma aleatoria.
     *
     * Precondición: No se puede elegir un elemento de un conjunto vacío.
     * Postcondición: Retorna un elemento del conjunto.
     *
     * @return un elemento del conjunto.
     */
    T choose();
}
