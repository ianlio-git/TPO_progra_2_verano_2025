package org.example;

import org.example.model.StaticQueueOfStack;
import org.example.model.SnailMatrix;
import org.example.model.StaticSnailMatrix;
import org.example.util.UtilQueueOfStack;

public class Ejercicio1 {
    public static void main(String[] args) {
        // ============================================================
        // Ejercicio 1.1: QueueOfStacks - Calcular la traza
        // ============================================================
        System.out.println("=== Ejercicio 1.1 - QueueOfStacks ===");

        // Crear una matriz 3x3 en una QueueOfStacks (cada pila tiene 3 elementos)
        StaticQueueOfStack qos = new StaticQueueOfStack(3);
        // Agregar elementos para formar la matriz:
        qos.add(1); qos.add(2); qos.add(3);
        qos.add(4); qos.add(5); qos.add(6);
        qos.add(7); qos.add(8); qos.add(9);

        System.out.println("Matriz original:");
        UtilQueueOfStack.print(qos);

        int traza = UtilQueueOfStack.traza(qos);   //   UtilQueueOfStack.traza() -> O(n^2)
        System.out.println("Traza de la matriz: " + traza);
        // ------------------- Fin Ejercicio 1.1 ----------------------

        // ============================================================
        // Ejercicio 1.2: QueueOfStacks - Calcular la traspuesta
        // ============================================================
        System.out.println("=== Ejercicio 1.2 - QueueOfStacks ===");
        StaticQueueOfStack traspuesta = UtilQueueOfStack.traspuesta(qos);
        System.out.println("Traspuesta de la matriz:");
        UtilQueueOfStack.print(traspuesta);   //   UtilQueueOfStack.traspuesta() -> O(n^3)
        // ------------------- Fin Ejercicio 1.2 ----------------------

        // ============================================================
        // Ejercicio 1.3: Matriz Caracol
        // ============================================================
        System.out.println("=== Ejercicio 1.3 - Matriz Caracol ===");
        SnailMatrix snail = new StaticSnailMatrix(3);// -> O(n^2)
        snail.print();
        // ------------------- Fin Ejercicio 1.3 ----------------------
    }
}
