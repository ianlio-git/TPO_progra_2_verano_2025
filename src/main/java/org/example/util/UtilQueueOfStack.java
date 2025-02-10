package org.example.util;

import org.example.model.QueueOfStack;
import org.example.model.StaticQueueOfStack;

import java.util.ArrayList;
import java.util.List;

public class UtilQueueOfStack {

    // Método para obtener el tamaño de la pila actual sin alterar su orden
    private static int getStackSize(QueueOfStack qos) {
        int count = 0;
        List<Integer> tempList = new ArrayList<>(); // Lista para preservar el orden



        // Restaurar la pila original en el mismo orden
        for (int i = tempList.size() - 1; i >= 0; i--) {
            qos.add(tempList.get(i));
        }

        return count;
    }

    // Método para copiar toda la cola de pilas, asegurando que el orden se mantenga
    public static QueueOfStack copyQueueOfStack(QueueOfStack qos) {
        int size = qos.getSize();
        QueueOfStack copy = new StaticQueueOfStack(size);
        QueueOfStack temp = new StaticQueueOfStack(size);

        while (!qos.queueIsEmpty()) {
            temp.add(qos.getTop());
            qos.removeTop();
        }

        // Restaurar la pila original y copiar en el nuevo objeto
        while(!temp.queueIsEmpty()){
            copy.add(temp.getTop());
            qos.add(temp.getTop());
            temp.removeTop();
        }

        return copy;
    }

    // Método para imprimir toda la cola de pilas sin modificar la estructura original
    public static void printQueueOfStack(QueueOfStack qos) {
        QueueOfStack copy = copyQueueOfStack(qos);

        System.out.println("Contenido de la cola de pilas:");
        while (!copy.queueIsEmpty()) {
            if(copy.stackIsFull()){
                System.out.println(" ");
            }
            System.out.print(copy.getTop()+" ");
            copy.removeTop();
        }
    }
}
