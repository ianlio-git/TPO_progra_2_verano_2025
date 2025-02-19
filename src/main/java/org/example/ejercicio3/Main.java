package org.example.ejercicio3;

import org.example.ejercicio3.model.Queue;
import org.example.ejercicio3.model.QueueOfQueue;
import org.example.ejercicio3.model.StaticQueueOfQueue;
import org.example.ejercicio3.util.UtilQueueOfQueue;

public class Main {
    public static void main(String[] args) {
        // ------------------ QueueOfQueue Original ------------------
        System.out.println("==== QueueOfQueue Original ====");
        StaticQueueOfQueue qoqOriginal = UtilQueueOfQueue.createSampleQueueOfQueue();
        System.out.println("Imprimiendo QueueOfQueue Original:");
        UtilQueueOfQueue.printQueueOfQueue(qoqOriginal);

        // ------------------ lat ------------------
        // Creamos otra instancia de muestra, ya que flat es destructivo.
        StaticQueueOfQueue qoqForFlat = UtilQueueOfQueue.createSampleQueueOfQueue();
        Queue flatQueue = qoqForFlat.flat(); // flat() retorna una StaticQueue con todos los elementos
        System.out.println("\n==== Flat Queue ====");
        UtilQueueOfQueue.printQueue(flatQueue);

        // ------------------ reverseWithDepth ------------------
        // Crear otra instancia de muestra para invertir.
        StaticQueueOfQueue qoqForReverse = UtilQueueOfQueue.createSampleQueueOfQueue();
        QueueOfQueue reversedQoq = qoqForReverse.reverseWithDepth();
        System.out.println("\n==== Reversed QueueOfQueue (with depth) ====");
        UtilQueueOfQueue.printQueueOfQueue(reversedQoq);

        // ------------------ Concatenate ------------------
        // Crear dos instancias de muestra y concatenarlas.
        StaticQueueOfQueue qoq1 = UtilQueueOfQueue.createSampleQueueOfQueue();
        StaticQueueOfQueue qoq2 = UtilQueueOfQueue.createSampleQueueOfQueue();
        // La concatenacion se hace manteniendo el orden en que se leen los valores de cada instancia.
        QueueOfQueue concatenated = qoq1.concatenate(qoq2);
        System.out.println("\n==== Concatenated QueueOfQueue ====");
        UtilQueueOfQueue.printQueueOfQueue(concatenated);
    }
}
