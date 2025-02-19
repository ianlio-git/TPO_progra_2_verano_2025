package org.example.ejercicio3.util;

import org.example.ejercicio3.model.Queue;
import org.example.ejercicio3.model.QueueOfQueue;
import org.example.ejercicio3.model.StaticQueue;
import org.example.ejercicio3.model.StaticQueueOfQueue;

public class UtilQueueOfQueue {
    /**
     * Crea una instancia de StaticQueueOfQueue de muestra.
     * Cada cola interna es una StaticQueue de enteros.
     * Pre: -
     * Post: Retorna una StaticQueueOfQueue con 3 filas, cada una con 3 elementos.
     * @return una instancia de StaticQueueOfQueue de muestra.
     */
    public static StaticQueueOfQueue createSampleQueueOfQueue() {
        StaticQueue q1 = new StaticQueue();
        q1.add(1);
        q1.add(2);
        q1.add(3);

        StaticQueue q2 = new StaticQueue();
        q2.add(4);
        q2.add(5);
        q2.add(6);

        StaticQueue q3 = new StaticQueue();
        q3.add(7);
        q3.add(8);
        q3.add(9);

        // Crear la QueueOfQueue y agregar las colas en orden.
        StaticQueueOfQueue qoq = new StaticQueueOfQueue();
        qoq.add(q1);
        qoq.add(q2);
        qoq.add(q3);

        return qoq;
    }
    /**
     * Imprime los elementos de una Queue (StaticQueue) de enteros.
     * Este metodo es destructivo; la cola queda vacia al finalizar.
     *
     * Pre: La cola no es nula.
     * Post: Se imprimen todos los elementos de la cola.
     *
     * @param q la cola a imprimir.
     */
    public static void printQueue(Queue q) {
        System.out.print("");
        while (!q.isEmpty()) {
            System.out.print(q.getFirst() + " ");
            q.remove();
        }
        System.out.println("");
    }

    /**
     * Imprime los elementos de una QueueOfQueue.
     * Por cada cola interna se invoca printQueue.
     * Este metodo es destructivo; la QueueOfQueue queda vacia al finalizar.
     *
     * Pre: La QueueOfQueue no es nula.
     * Post: Se imprimen todas las colas internas.
     *
     * @param qoq la QueueOfQueue a imprimir.
     */
    public static void printQueueOfQueue(QueueOfQueue qoq) {
        while (!qoq.isEmpty()) {
            Queue q = qoq.getFirst();
            printQueue(q);
            qoq.remove();
        }
    }
}
