package org.example.ejercicio2.util;

import org.example.ejercicio2.model.GenericQueue;
import org.example.ejercicio2.model.GenericStack;

public class UtilQueue {

    /**
     * Metodo para copiar una GenericQueue.
     *
     * Pre: La queue no es nula.
     * Post: Retorna una nueva GenericQueue que contiene los mismos elementos en el mismo orden que la original.
     *       La queue original se restaura a su estado inicial.
     * @param queue la GenericQueue a copiar.
     * @return una copia de la GenericQueue.
     */
    public static <T> GenericQueue<T> copyQueue(GenericQueue<T> queue) {
        GenericQueue<T> aux = new GenericQueue<>();
        GenericQueue<T> copy = new GenericQueue<>();

        // Transferir elementos de la queue original a aux y copy.
        while (!queue.isEmpty()) {
            T elem = queue.getFirst();
            aux.add(elem);
            copy.add(elem);
            queue.remove();
        }
        // Restaurar la queue original desde aux.
        while (!aux.isEmpty()) {
            T elem = aux.getFirst();
            queue.add(elem);
            aux.remove();
        }

        return copy;
    }

    /**
     * Metodo auxiliar para imprimir los elementos de una GenericQueue.
     *
     * Pre: La queue no es nula.
     * Post: Se imprimen los elementos de la queue y esta queda vacia.

     * @param queue la GenericQueue a imprimir.
     */
    public static <T> void printQueue(GenericQueue<T> queue) {
        GenericQueue<T> aux = copyQueue(queue);
        while (!aux.isEmpty()) {             // O(n)
            System.out.print(aux.getFirst() + " ");  // O(c)
            aux.remove();                    // O(c)
        }
        System.out.println();                  // O(c)
    }
}
