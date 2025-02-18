package org.example.ejercicio1.util;

import org.example.ejercicio1.model.*;

public class UtilQueueOfStack {

    /**
     * Metodo para copiar una QueueOfStack.
     *
     * Complejidad Total: O(n^2), donde n^2 es el numero total de elementos.
     */
    public static StaticQueueOfStack copy(StaticQueueOfStack qos) {
        int size = qos.getSize(); // O(c)
        StaticQueueOfStack copy = new StaticQueueOfStack(size); // O(c)
        StaticQueueOfStack temp = new StaticQueueOfStack(size); // O(c)

        while (!qos.isQueueEmpty()) { // Se ejecuta hasta vaciar qos -> O(n^2)
            int a = qos.pop(); // Cada pop: O(c)
            temp.add(a);       // Cada add: O(c)
        }
        while (!temp.isQueueEmpty()) { // Se ejecuta hasta vaciar temp -> O(n^2)
            int a = temp.pop(); // O(c)
            qos.add(a);         // O(c)
            copy.add(a);        // O(c)
        }
        return copy; // O(c)
    }

    /**
     * Metodo para imprimir el contenido de la QueueOfStack.
     *
     * Complejidad Total: O(n^2), debido a la llamada a copy() O(n^2) y al recorrido para imprimir los elementos (n^2).
     */
    public static void print(StaticQueueOfStack qos) {
        StaticQueueOfStack temp = copy(qos); // copy: O(n^2)
        System.out.println("Contenido de la QueueOfStack:"); // O(c)
        while (!temp.isQueueEmpty()) { // Se recorre cada elemento -> O(n^2) en total
            if (temp.getFirst().isEmpty()) { // O(c)
                System.out.println("\t"); // O(c)
            }
            System.out.print(temp.pop() + " "); // Cada pop: O(c)
        }
        System.out.println("\t"); // O(c)
    }

    /**
     * Metodo para calcular la traza de la matriz representada por la QueueOfStack.
     *
     * Complejidad Total: O(n^2)
     */
    public static int traza(StaticQueueOfStack qos) {
        StaticQueueOfStack copy = copy(qos); // O(n^2)
        int traza = 0; // O(c)
        int currentRow = 0; // O(c)
        while (!copy.isQueueEmpty()) { // Se ejecuta para cada fila -> O(n^2)
            int lastPopped = 0; // O(c)
            for (int i = 0; i <= currentRow; i++) { // Se realizan (currentRow + 1) pops; sumatoria total = O(n^2)
                lastPopped = copy.pop(); // O(c) cada uno
            }
            traza += lastPopped; // O(c)
            if (!copy.isQueueEmpty()) { // O(c)
                copy.remove(); // O(c)
                currentRow++; // O(c)
            }
        }
        return traza; // O(c)
    }

    /**
     * Metodo para calcular la traspuesta de la matriz representada por la QueueOfStack.
     *
     * Complejidad Total: O(n^3), ya que:
     * - El bucle externo se ejecuta O(n) veces.
     * - En cada iteracion se crea una copia fresca: O(n^2).
     * - Ademas, se recorren todas las filas (hasta n iteraciones) en un bucle interno.
     */
    public static StaticQueueOfStack traspuesta(StaticQueueOfStack qos) {
        int size = qos.getSize() - 1; // O(c)
        StaticQueueOfStack transp = new StaticQueueOfStack(qos.getSize()); // O(c)

        // Bucle externo: se ejecuta aproximadamente n veces (desde size = n-1 hasta 0) -> O(n)
        while (size >= 0) {
            // Crea una copia fresca de qos en cada iteracion -> O(n^2)
            StaticQueueOfStack copy = copy(qos); // O(n^2)
            // Bucle interno: recorre cada fila en la copia (hasta n filas) -> O(n) por copia, en total O(n^2) por iteracion externa
            while (!copy.isQueueEmpty()) {
                int a = 0; // O(c)
                // Realiza (size + 1) extracciones sobre la primera fila -> O(n) en el peor caso
                for (int i = 0; i <= size; i++) {
                    a = copy.pop(); // O(c)
                }
                transp.add(a); // O(c)
                // Remueve la fila si aun no esta vacia -> O(c)
                if (!copy.isQueueEmpty()) {
                    copy.remove(); // O(c)
                }
            }
            size--; // O(c)
        }
        return transp; // O(c)
    }
}
