package org.example.ejercicio2.util;

import org.example.ejercicio2.model.GenericPriorityQueue;

/**
 * Clase de utilidades para trabajar con PriorityQueue generica.
 */
public class PriorityQueueUtil {

    /**
     * Copia la cola con prioridad.
     *
     * Pre: La cola no es nula.
     * Post: Retorna una nueva PriorityQueue que contiene los mismos elementos (en el mismo orden) que la cola original,
     * y restaura el estado de la cola original.
     *
     * @param <T> Tipo de elementos almacenados en la cola.
     * @param queue La PriorityQueue a copiar.
     * @return Una copia de la PriorityQueue.
     */
    public static <T> GenericPriorityQueue<T> copy(GenericPriorityQueue<T> queue) {
        GenericPriorityQueue<T> aux = new GenericPriorityQueue<>();
        GenericPriorityQueue<T> aux2 = new GenericPriorityQueue<>();

        // Vaciar la cola original en aux y aux2 (se recorren todos los elementos)
        while (!queue.isEmpty()) {
            aux.add(queue.getFirst(), queue.getPriority());
            aux2.add(queue.getFirst(), queue.getPriority());
            queue.remove();
        }

        // Restaurar la cola original desde aux2
        while (!aux2.isEmpty()) {
            queue.add(aux2.getFirst(), aux2.getPriority());
            aux2.remove();
        }

        return aux;
    }

    /**
     * Imprime los elementos de la PriorityQueue con prioridad.
     *
     * Pre: La cola no es nula.
     * Post: Se imprimen los elementos de la cola junto con su prioridad.
     * Este metodo es destructivo, es decir, la cola queda vacia al finalizar.
     *
     * @param <T> Tipo de elementos almacenados en la cola.
     * @param queue La PriorityQueue a imprimir.
     */
    public static <T> void print(GenericPriorityQueue<T> queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.getFirst() + " [priority: " + queue.getPriority() + "]");
            queue.remove();
        }
    }
}
