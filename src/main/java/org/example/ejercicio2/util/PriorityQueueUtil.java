package org.example.ejercicio2.util;

import org.example.ejercicio2.model.GenericPriorityQueue;

/**
 * Clase de utilidades para trabajar con PriorityQueue genérica.
 */
public class PriorityQueueUtil {

    /**
     * Copia la cola con prioridad.
     */
    public static <T, P extends Comparable<P>> GenericPriorityQueue<T, P> copy(GenericPriorityQueue<T, P> queue) {
        GenericPriorityQueue<T, P> aux = new GenericPriorityQueue<>();
        GenericPriorityQueue<T, P> aux2 = new GenericPriorityQueue<>();

        // Vaciar la cola original en aux y aux2 (se recorren todos los elementos)
        while (!queue.isEmpty()) {
            T element = queue.getFirst();
            P priority = queue.getPriority();
            aux.add(element, priority);
            aux2.add(element, priority);
            queue.remove();
        }
        // Restaurar la cola original desde aux2
        while (!aux2.isEmpty()) {
            T element = aux2.getFirst();
            P priority = aux2.getPriority();
            queue.add(element, priority);
            aux2.remove();
        }
        return aux;
    }

    /**
     * Imprime los elementos de la PriorityQueue con prioridad.
     */
    public static <T, P extends Comparable<P>> void print(GenericPriorityQueue<T, P> queue) {
        GenericPriorityQueue<T, P> aux = copy(queue);
        while (!aux.isEmpty()) {
            System.out.println(aux.getFirst() + " [priority: " + aux.getPriority() + "]");
            aux.remove();
        }
    }
}
