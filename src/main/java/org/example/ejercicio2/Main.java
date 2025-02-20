package org.example.ejercicio2;

import org.example.ejercicio2.model.*;
import org.example.ejercicio2.util.PriorityQueueUtil;
import org.example.ejercicio2.util.SetUtil;
import org.example.ejercicio2.util.UtilStack;
import org.example.ejercicio2.util.UtilQueue;

public class Main {
    public static void main(String[] args) {
        // ---------------- GenericStack Demo ----------------
        System.out.println("==== GenericStack Demo ====");

        // Crear un GenericStack de Integer y agregar elementos.
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.add(1);
        intStack.add(2);
        intStack.add(3);
        intStack.add(4);
        intStack.add(5);

        System.out.println("Stack original (Integer):");
        UtilStack.print(intStack);


        // Invertir el stack original
        UtilStack.invertirStackConQueue(intStack);
        System.out.println("Stack invertido (Integer):");
        UtilStack.print(intStack);

        // ---------------- GenericQueue Demo ----------------
        System.out.println("\n==== GenericQueue Demo ====");

        // Crear un GenericQueue de String y agregar elementos.
        GenericQueue<String> stringQueue = new GenericQueue<>();
        stringQueue.add("Alpha");
        stringQueue.add("Beta");
        stringQueue.add("Gamma");
        stringQueue.add("Delta");
        stringQueue.add("Epsilon");

        System.out.println("Queue original (String):");
        UtilQueue.printQueue(stringQueue);

        // Verificar que la queue original se conserva (volvemos a copiarla e imprimirla)
        System.out.println("Queue original tras copiar (debe conservar sus elementos):");
        UtilQueue.printQueue(stringQueue);
        // ===================== PriorityQueue Demo =====================
        System.out.println("==== PriorityQueue Demo ====");

        // Crear una PriorityQueue generica de String con prioridades de tipo Integer.
        GenericPriorityQueue<String, Integer> pq = new GenericPriorityQueue<>();

        // Agregar elementos con sus prioridades
        pq.add("Low", 1);
        pq.add("Medium", 5);
        pq.add("High", 10);
        pq.add("Medium2", 5);
        pq.add("Very High", 15);

        System.out.println("PriorityQueue original:");
        PriorityQueueUtil.print(pq);

        // Para demostrar la función copy, volvemos a agregar los elementos
        pq.add("Low", 1);
        pq.add("Medium", 5);
        pq.add("High", 10);
        pq.add("Medium2", 5);
        pq.add("Very High", 15);

        // Copiar la PriorityQueue
        GenericPriorityQueue<String, Integer> pqCopy = PriorityQueueUtil.copy(pq);
        System.out.println("Copia de la PriorityQueue:");
        PriorityQueueUtil.print(pqCopy);

        // ===================== Fin PriorityQueue Demo =====================


        // ===================== Set Demo =====================
        System.out.println("\n==== Set Demo ====");

        // Crear un Set generico de Integer
        SetT<Integer> set = new GenericSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(20); // Duplicado; no se agrega
        set.add(40);

        System.out.println("Set original:");
        SetUtil.print(set);

        // Copiar el set
        SetT<Integer> setCopy = SetUtil.copy(set);
        System.out.println("Copia del Set:");
        SetUtil.print(setCopy);

        // ===================== Fin Set Demo =====================
        // ---------------- Fin del Ejercicio 2: Programacion Generica ----------------
    }



}
