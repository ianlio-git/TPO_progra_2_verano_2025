package org.example.ejercicio2.util;

import org.example.ejercicio2.model.SetT;
import org.example.ejercicio2.model.GenericSet;

/**
 * Clase de utilidades para trabajar con conjuntos (Set) genericos.
 */
public class SetUtil {

    /**
     * Copia un conjunto generico.
     *
     * Pre: El conjunto no es nulo.
     * Post: Retorna una nueva instancia de SetT que contiene los mismos elementos que el conjunto original,
     *       restaurando el conjunto original a su estado inicial.
     * @param <T> Tipo de los elementos.
     * @param set El conjunto a copiar.
     * @return Una copia del conjunto.
     */
    public static <T> SetT<T> copy(SetT<T> set) {
        SetT<T> copy = new GenericSet<>();
        SetT<T> aux = new GenericSet<>();

        while (!set.isEmpty()) {
            T element = set.choose();
            copy.add(element);
            aux.add(element);
            set.remove(element);
        }

        while (!aux.isEmpty()) {
            T element = aux.choose();
            set.add(element);
            aux.remove(element);
        }

        return copy;
    }

    /**
     * Imprime los elementos de un conjunto generico.
     *
     * Pre: El conjunto no es nulo.
     * Post: Se imprimen los elementos del conjunto y este queda vacio.
     * @param <T> Tipo de los elementos.
     * @param set El conjunto a imprimir.
     */
    public static <T> void print(SetT<T> set) {
        // Para no afectar el conjunto original, se crea una copia.
        SetT<T> copy = copy(set);
        while (!copy.isEmpty()) {
            T element = copy.choose();
            System.out.print(element + " ");
            copy.remove(element);
        }
        System.out.println();
    }
}
