package org.example;

import org.example.model.QueueOfStack;
import org.example.model.SnailMatrix;
import org.example.model.StaticQueueOfStack;
import org.example.model.StaticSnailMatrix;
import org.example.util.UtilQueueOfStack;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        /**
         * 2.1.Ejercicio 1: Matrices
         * Dada una cola de n pilas, y cada pila de n elementos, esta tomará un aspecto matricial. Llamaremos a
         * estructura QueueOfStacks. Por ejemplo, una posible matriz de n × n para n = 3 es:
         * 1 2 3
         * 4 5 6
         * 7 8 9
         * −−−−→
         * 1. Desarrolle una función que reciba una instancia de QueueOfStacks, y calcule su traza, utilizando una
         * estructura que represente una pila de colas.
         */
        QueueOfStack qos = new StaticQueueOfStack(3);
        qos.add(1);
        qos.add(2);
        qos.add(3);
        qos.add(4);
        qos.add(5);
        qos.add(6);
        qos.add(7);
        qos.add(8);
        qos.add(9);
        UtilQueueOfStack.print(qos);
        System.out.println("La traza de la QueueOfStack es: " + UtilQueueOfStack.traza(qos) );
        /**
         * 2. Desarrolle una función que reciba una instancia de QueueOfStacks, y devuelva su traspuesta.
         */
        System.out.println("La transpuesta es: " );
        UtilQueueOfStack.print(UtilQueueOfStack.traspuesta(qos));
        /**
         * 3. Desarrolle una función que reciba un número n y genere una matriz caracol de dimensión n.
         * Calcule la complejidad computacional de los algoritmos anteriores.
         */
        SnailMatrix matrix = new StaticSnailMatrix(3);
        matrix.add(1);
        matrix.add(2);
        matrix.add(3);
        matrix.add(4);
        matrix.add(5);
        matrix.add(6);
        matrix.add(7);
        matrix.add(8);
        matrix.add(9);
        matrix.print();

    }
}