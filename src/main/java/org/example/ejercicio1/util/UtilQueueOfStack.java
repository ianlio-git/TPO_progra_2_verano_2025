package org.example.ejercicio1.util;

import org.example.ejercicio1.model.*;

/**
 * Clase de utilidades para operar sobre una QueueOfStack (cola de pilas).
 */
public class UtilQueueOfStack {
    private static final int MAX = 100000;

    public UtilQueueOfStack() {
    }

    public static StaticQueueOfStack createSampleQueueOfStack() {
        StaticStack s1 = new StaticStack();
        s1.add(1);
        s1.add(2);
        s1.add(3);

        StaticStack s2 = new StaticStack();
        s2.add(4);
        s2.add(5);
        s2.add(6);

        StaticStack s3 = new StaticStack();
        s3.add(7);
        s3.add(8);
        s3.add(9);

        StaticQueueOfStack qos = new StaticQueueOfStack(3);
        qos.add(s1);
        qos.add(s2);
        qos.add(s3);

        return qos;
    }

    /**
     * Retorna el número de pilas (filas) en la QueueOfStack sin modificarla.
     * Complejidad: O(n*m)
     */
    public static int size(StaticQueueOfStack qos) {
        int rows = 0;
        int columns = 0;
        // Contar elementos de la primera pila.
        StaticStack aux2 = UtilStack.copyStack(qos.getFirst());
        while (!aux2.isEmpty()) {
            aux2.remove();  // O(1) por iteración
            rows++;
        }
        // Se recorre la primera pila (m elementos) → O(m)

        // Contar la cantidad de pilas y verificar que cada una tenga la misma cantidad de elementos.
        StaticQueueOfStack aux = new StaticQueueOfStack(MAX);
        while (!qos.isQueueEmpty()){
            StaticStack auxStack = UtilStack.copyStack(qos.getFirst());
            int rows2 = 0;
            while (!auxStack.isEmpty()) {
                auxStack.remove();  // O(1)
                rows2++;
            }
            if (rows2 != rows) {
                throw new AssertionError("Queue of Stack no está lleno");
            }
            // Se actualiza rows (deben ser iguales en todas las pilas)
            rows = rows2;
            StaticStack s = UtilStack.copyStack(qos.getFirst());
            aux.add(s);
            qos.remove();
            columns++;
        }
        // Bucle externo se ejecuta n veces (n = número de pilas), cada iteración O(m) → O(n*m)

        // Restaurar la estructura original.
        while (!aux.isQueueEmpty()){
            qos.add(aux.getFirst());
            aux.remove();
        }
        // Se recorre aux (n elementos) → O(n)

        return columns;
    }

    /**
     * Crea una copia de la QueueOfStack sin modificar la original.
     */
    public static StaticQueueOfStack copy(StaticQueueOfStack qos) {
        int n = size(qos); // O(n*m)
        StaticQueueOfStack copy = new StaticQueueOfStack(n); // O(1)
        StaticQueueOfStack temp = new StaticQueueOfStack(n); // O(1)
        while (!qos.isQueueEmpty()) { // Se ejecuta n veces, cada iteración O(m) → O(n*m)
            StaticStack s = UtilStack.copyStack(qos.getFirst());
            temp.add(s);
            copy.add(s);
            qos.remove();
        }
        while (!temp.isQueueEmpty()) { // Se ejecuta n veces → O(n*m)
            StaticStack s = UtilStack.copyStack(temp.getFirst());
            qos.add(s);
            temp.remove();
        }
        return copy;
    }
    /**
     * Retorna el elemento del stack sin destruirlo.
     */
    public static int getElementAt(Stack s, int pos) {
        StaticStack copy = UtilStack.copyStack(s);
        int element = -1;
        for (int i = 0; i <= pos; i++) {
            element = copy.getTop();
            copy.remove();
        }
        return element;
    }

    /**
     * Calcula la traza (diagonal) de la matriz representada por la QueueOfStack.
     * Complejidad: O (n^2)
     */
    public static int traza(StaticQueueOfStack qos) {
        int rows = size(qos); // O(n*m)
        int trace = 0; // O(1)
        StaticQueueOfStack copy = copy(qos); // O(n*m)
        for (int i = 0; i < rows; i++) { // n iteraciones → O(n)
            Stack rowStack = copy.getFirst();
            int diagElement = getElementAt(rowStack, i); // O(i) cada iteración, total O(n^2) en el peor caso
            trace += diagElement; // O(1)
            copy.remove(); // O(1)
        }
        return trace; // O(1)
    }

    /**
     * Calcula la traspuesta de la matriz representada por la QueueOfStack.
     * Complejidad:  O(n^3).
     */
    public static StaticQueueOfStack traspuesta(StaticQueueOfStack qos) {
        int rows = size(qos); // O(n*m)
        StaticQueueOfStack qosTransp = new StaticQueueOfStack(rows);
        for (int col = 0; col < rows; col++) { // n iteraciones → O(n)
            StaticStack stackTransp = new StaticStack(); // O(1)
            StaticQueueOfStack copy = copy(qos); // O(n*m)
            while (!copy.isQueueEmpty()) { // n iteraciones → O(n) en el peor caso
                Stack aux = copy.getFirst();
                for (int i = 0; i < col; i++) { // Hasta col iteraciones → O(n) en promedio
                    if (!aux.isEmpty()) {
                        aux.remove(); // O(1)
                    }
                }
                int val = aux.isEmpty() ? 0 : aux.getTop(); // O(1)
                stackTransp.add(val); // O(1)
                copy.remove(); // O(1)
            }
            qosTransp.add(stackTransp); // O(1)
        }
        return qosTransp; // O(1)
    }

    /**
     * Imprime el contenido de la QueueOfStack sin destruir la estructura original.
     */
    public static void print(StaticQueueOfStack qos) {
        StaticQueueOfStack temp = copy(qos); // O(n*m)
        System.out.println("Contenido de la QueueOfStack:");
        while (!temp.isQueueEmpty()) { // n iteraciones → O(n)
            System.out.println("\t");
            UtilStack.print(temp.getFirst()); // Se asume que UtilStack.print es O(m)
            temp.remove(); // O(1)
        }
        System.out.println("\t"); // O(1)
    }
}
