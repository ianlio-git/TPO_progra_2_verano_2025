package org.example.ejercicio1;

import org.example.ejercicio1.model.StaticQueueOfStack;
import org.example.ejercicio1.model.SnailMatrix;
import org.example.ejercicio1.model.StaticSnailMatrix;
import org.example.ejercicio1.util.UtilQueueOfStack;

public class Main {
    public static void main(String[] args) {

        // ============================================================
        // Ejercicio 1.1: QueueOfStacks - Calcular la traza
        // ============================================================
        System.out.println("=== Ejercicio 1.1 - QueueOfStacks ===");

        StaticQueueOfStack qos = UtilQueueOfStack.createSampleQueueOfStack();

        System.out.println("Matriz original:");
        UtilQueueOfStack.print(qos);

        // Complejidad: O(n^2)
        int traza = UtilQueueOfStack.traza(qos);
        System.out.println("Traza de la matriz: " + traza);
        System.out.println();

        // ============================================================
        // Ejercicio 1.2: QueueOfStacks - Calcular la traspuesta
        // ============================================================
        System.out.println("=== Ejercicio 1.2 - QueueOfStacks ===");


        // Complejidad: O(n^3)
        StaticQueueOfStack traspuesta = UtilQueueOfStack.traspuesta(qos);
        System.out.println("Traspuesta de la matriz:");
        UtilQueueOfStack.print(traspuesta);

        // ============================================================
        // Ejercicio 1.3: Matriz Caracol
        // ============================================================
        System.out.println("=== Ejercicio 1.3 - Matriz Caracol ===");

        // Complejidad: O(n^2)
        SnailMatrix snail = new StaticSnailMatrix(3);
        snail.print();
    }
}
