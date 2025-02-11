package org.example.util;

import org.example.model.QueueOfStack;
import org.example.model.StaticQueueOfStack;


public class UtilQueueOfStack {

    public static QueueOfStack copy(QueueOfStack qos) {
        int size = qos.getSize(); //O(c)
        QueueOfStack copy = new StaticQueueOfStack(size);
        QueueOfStack temp = new StaticQueueOfStack(size);

        while (!qos.queueIsEmpty()) { //O(n)
            temp.add(qos.getTop()); //O(c)
            qos.removeTop();//O(n)
        }

        // Restaurar la pila original y copiar en el nuevo objeto
        while(!temp.queueIsEmpty()){ //O(n)
            copy.add(temp.getTop());//O(c)
            qos.add(temp.getTop());//O(c)
            temp.removeTop();//O(n)
        }

        return copy; //O(c)
    }  // Complejidad: O(n^2) debido a los dos ciclos anidados O(n) y las operaciones dentro de estos que son constantes.

    public static void print(QueueOfStack qos) {
        QueueOfStack copy = copy(qos);
        System.out.println("Contenido de la QueueOfStack:");
        while (!copy.queueIsEmpty()) { //O(n)
            for (int i = 0; i < qos.getSize(); i++) { //O(c)
                System.out.print(copy.getTop() + " ");
                copy.removeTop();
            }
            System.out.println();
        }

    } // Complejidad: O(n^2)
    public static int traza(QueueOfStack qos) {
        int traza = 0; // O(c)
        int currentRow = 0; // O(c)
        int size = qos.getSize(); // O(c)
        QueueOfStack copy = copy(qos); // O(n^2)

        while (!copy.queueIsEmpty()) { // O(n)
            for (int i = 0; i < currentRow; i++) { // O(n)
                copy.removeTop(); // O(n)
            }
            traza += copy.getTop(); // O(c)
            copy.removeTop(); // O(n)
            if (currentRow < size - 1) { // O(c)
                copy.removeQueue(); // O(n)
            }
            currentRow++; // O(c)
        }

        return traza; // O(c)
    } // Complejidad: O(n^2)  debido a los dos ciclos anidados, uno de los cuales recorre hasta n elementos y el otro ejecuta operaciones como removeQueue()
    public static QueueOfStack traspuesta(QueueOfStack qos) {
        int size = qos.getSize();// O(c)
        int currentRow = 0; // O(c)

        QueueOfStack traspuesta = new StaticQueueOfStack(size);
        QueueOfStack copy = copy(qos); //O(n^2)

        while (currentRow < size) { // O(n)
            for (int i = 0; i < currentRow; i++) { // O(n)
                copy.removeTop(); // O(n)
            }
            traspuesta.add(copy.getTop()); // O(c)
            copy.removeQueue(); // O(n)
            if (copy.queueIsEmpty()){ // O(c)
                copy = copy(qos);// O(n^2)
                currentRow++; // O(c)
            }

        }
        return traspuesta; // O(c)
    } // Complejidad total O(n^2)
}
