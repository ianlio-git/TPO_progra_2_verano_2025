package org.example.util;

import org.example.model.QueueOfStack;
import org.example.model.Stack;
import org.example.model.StaticQueueOfStack;
import org.example.model.StaticStack;

public class UtilQueueOfStack {

    // Método para copiar una QueueOfStack
    public static StaticQueueOfStack copy(StaticQueueOfStack qos) {
        int size = qos.getSize();
        StaticQueueOfStack copy = new StaticQueueOfStack(size);
        StaticQueueOfStack temp = new StaticQueueOfStack(size);

        // Copiar cada pila de la QueueOfStack
        while (!qos.isQueueEmpty()) {
            int a = qos.pop();
            temp.add(a);
            copy.add(a);
        }
        while (!temp.isQueueEmpty()) {
            int a = temp.pop();
            qos.add(a);
        }

        return copy;
    }

    // Método para imprimir el contenido de la QueueOfStack
    public static void print(StaticQueueOfStack qos) {
        StaticQueueOfStack copy = copy(qos);
        System.out.println("Contenido de la QueueOfStack:");
        while (!copy.isQueueEmpty()) {
            System.out.println(copy.pop());
        }
    }

    // Método para calcular la traza de la matriz representada por la QueueOfStack
    public static int traza(StaticQueueOfStack qos) {
        int traza = 0;
        int currentRow = 0;
        int size = qos.getSize();
        StaticQueueOfStack copy = copy(qos);

        // Recorrer la diagonal de la matriz
        while (!copy.isQueueEmpty()) {
            // Eliminar los elementos previos de las pilas de la cola
            for (int i = 0; i < currentRow; i++) {
                copy.pop();  // Eliminar el elemento de la cola de pilas
            }

            // Sumar el elemento de la diagonal
            traza += copy.pop();

            // Eliminar la pila de la cola si está vacía
            if (copy.isStackEmpty()) {
                copy.remove();
            }

            // Avanzamos a la siguiente fila
            currentRow++;
        }

        return traza;
    }


    // Método para calcular la traspuesta de la matriz representada por la QueueOfStack
    public static StaticQueueOfStack traspuesta(StaticQueueOfStack qos) {
        int size = qos.getSize();
        int currentRow = 0;

        StaticQueueOfStack traspuesta = new StaticQueueOfStack(size);
        StaticQueueOfStack copy = copy(qos);

        // Crear la traspuesta
        while (currentRow < size) {
            for (int i = 0; i < currentRow; i++) {
                copy.getFirst().remove();
            }
            traspuesta.add(copy.getFirst().getTop());
            copy.getFirst().remove();
            copy.remove();
            if (copy.isQueueEmpty()) {
                copy = copy(qos);
                currentRow++;
            }
        }

        return traspuesta;
    }
}
