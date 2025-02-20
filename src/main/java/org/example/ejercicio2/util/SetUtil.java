package org.example.ejercicio2.util;

import org.example.ejercicio2.model.SetT;
import org.example.ejercicio2.model.GenericSet;

/**
 * Clase de utilidades para trabajar con conjuntos (Set) genericos.
 */
public class SetUtil {

    /**
     * Copia un conjunto generico.
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
