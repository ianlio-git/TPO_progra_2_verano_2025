package org.example.ejercicio1.util;

import org.example.ejercicio1.model.Stack;
import org.example.ejercicio1.model.StaticStack;

public class UtilStack {

    // Crea una copia del stack sin modificar el original.
    public static StaticStack copyStack(Stack stack) {
        StaticStack aux = new StaticStack();
        StaticStack copy = new StaticStack();
        // Vaciar el stack original en aux
        while (!stack.isEmpty()) {
            int elem = stack.getTop();
            aux.add(elem);
            stack.remove();
        }
        // Restaurar el original y llenar la copia
        while (!aux.isEmpty()) {
            int elem = aux.getTop();
            aux.remove();
            stack.add(elem);
            copy.add(elem);
        }
        return copy;
    }

    // Imprime el stack sin modificarlo.
    public static void print(Stack stack) {
        StaticStack copy = copyStack(stack);
        while (!copy.isEmpty()) {
            System.out.print(copy.getTop() + " ");
            copy.remove();
        }
        System.out.println();
    }

    // Retorna el elemento en la posicion pos (0-indexado) sin destruir el stack.
    public static int getElementAt(Stack stack, int pos) {
        StaticStack copy = copyStack(stack);
        int element = -1;
        for (int i = 0; i <= pos && !copy.isEmpty(); i++) {
            element = copy.getTop();
            copy.remove();
        }
        return element;
    }
}
