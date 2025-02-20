package org.example.ejercicio2.util;

import org.example.ejercicio2.model.GenericStack;
import org.example.ejercicio2.model.GenericQueue;
import org.example.ejercicio2.model.StackT;

public class UtilStack {

    /**
     * Crea una copia del stack generico sin modificar el stack original.
     */
    public static <T> GenericStack<T> copyStack(StackT<T> stack) {
        GenericStack<T> aux = new GenericStack<>();
        GenericStack<T> copy = new GenericStack<>();

        // Vaciar el stack original en aux (esto invierte el orden).
        while (!stack.isEmpty()) {
            T elem = stack.getTop();
            aux.add(elem);
            stack.remove();
        }

        // Restaurar el stack original y llenar la copia (esto reinvierte el orden).
        while (!aux.isEmpty()) {
            T elem = aux.getTop();
            aux.remove();
            stack.add(elem);
            copy.add(elem);
        }

        return copy;
    }

    /**
     * Imprime los elementos de un stack generico sin modificar su orden.
     */
    public static <T> void print(StackT<T> stack) {
        // Crear una copia del stack sin modificar el original.
        GenericStack<T> copy = copyStack(stack);

        // Imprimir la copia (se asume que se imprime de la parte superior a la inferior).
        while (!copy.isEmpty()) {
            System.out.println(copy.getTop());
            copy.remove();
        }
    }

    /**
     * Invierte los elementos de un stack generico usando una GenericQueue.
     */
    public static <T> void invertirStackConQueue(StackT<T> stack) {
        // Crear una cola generica para almacenar temporalmente los elementos.
        GenericQueue<T> queue = new GenericQueue<>();

        // Vaciar el stack en la cola.
        while (!stack.isEmpty()) {
            T elem = stack.getTop();
            stack.remove();
            queue.add(elem);
        }

        // Transferir los elementos de la cola de vuelta al stack.
        while (!queue.isEmpty()) {
            T elem = queue.getFirst();
            queue.remove();
            stack.add(elem);
        }
    }
}
