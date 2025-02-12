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
        }
        while (!temp.isQueueEmpty()) {
            int a = temp.pop();
            qos.add(a);
            copy.add(a);
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
        StaticQueueOfStack copy = copy(qos);
        int traza = 0;
        int currentRow = 0;
        while (!copy.isQueueEmpty()) {
            int lastPopped = 0;
            for (int i = 0; i <= currentRow; i++) {
                    lastPopped = copy.pop();
            }
            traza += lastPopped;
            if (!copy.isQueueEmpty()) {
                copy.remove();
                currentRow++;
            }
        }
        return traza;
    }


    // Método para calcular la traspuesta de la matriz representada por la QueueOfStack
    public static StaticQueueOfStack traspuesta(StaticQueueOfStack qos) {
        int size = qos.getSize();
        int currentRow = 0;

        StaticQueueOfStack copy = copy(qos);
        StaticQueueOfStack transp = new StaticQueueOfStack(size);

        // Crear la traspuesta
        while (currentRow < size) {
            int lastPopped = 0;
            for (int i = 0; i <= currentRow; i++) {
                lastPopped = copy.pop();
            }

            transp.add(lastPopped);
            copy.remove();
            if (copy.isQueueEmpty()) {
                copy = copy(qos);
                currentRow++;
            }
        }

        return transp;
    }
}
