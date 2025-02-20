package org.example.ejercicio3.util;

import org.example.ejercicio3.model.Queue;
import org.example.ejercicio3.model.StaticQueue;
import org.example.ejercicio3.model.QueueOfQueue;
import org.example.ejercicio3.model.StaticQueueOfQueue;

/**
 * Utilidades para trabajar con QueueOfQueue sin destruir la estructura original.
 */
public class UtilQueueOfQueue {
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

    public static StaticQueue copyQueue(StaticQueue q) {
        StaticQueue copy = new StaticQueue();
        StaticQueue temp = new StaticQueue();
        while (!q.isEmpty()) {
            int elem = q.getFirst();
            q.remove();
            temp.add(elem);
            copy.add(elem);
        }
        while (!temp.isEmpty()) {
            int elem = temp.getFirst();
            temp.remove();
            q.add(elem);
        }
        return copy;
    }

    public static StaticQueueOfQueue copy(StaticQueueOfQueue qoq) {
        StaticQueueOfQueue copia = new StaticQueueOfQueue();
        StaticQueueOfQueue temp = new StaticQueueOfQueue();
        while (!qoq.isEmpty()) {
            StaticQueue qCopy = copyQueue((StaticQueue) qoq.getFirst());
            temp.add(qCopy);
            copia.add(qCopy);
            qoq.remove();
        }
        while (!temp.isEmpty()) {
            StaticQueue qCopy = (StaticQueue) temp.getFirst();
            temp.remove();
            qoq.add(qCopy);
        }
        return copia;
    }


    public static void printQueue(Queue q) {
        StaticQueue copy = copyQueue((StaticQueue) q);
        while (!copy.isEmpty()) {
            System.out.print(copy.getFirst() + " ");
            copy.remove();
        }
        System.out.println();
    }

    public static void printQueueOfQueue(QueueOfQueue qoq) {
        StaticQueueOfQueue copy = copy((StaticQueueOfQueue) qoq);
        while (!copy.isEmpty()) {
            Queue q = copy.getFirst();
            printQueue(q);
            copy.remove();
        }
    }
}
