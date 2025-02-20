package org.example.ejercicio2.model;

import java.util.Objects;
import java.util.Random;

/**
 * Implementacion generica de la interfaz SetT.
 */
public class GenericSet<T> implements SetT<T> {

    private static final int MAX = 10000;
    private final Object[] array;
    private int count;
    private final Random random;


    public GenericSet() {
        this.array = new Object[MAX];
        this.count = 0;
        this.random = new Random();
    }


    @Override
    public void add(T a) {
        // Verificar si el elemento ya existe (usando equals)
        for (int i = 0; i < count; i++) {
            if (Objects.equals(a, (T) array[i])) {
                return; // Elemento ya presente, no se agrega.
            }
        }
        // Agregar el elemento al final.
        if (count >= MAX) {
            throw new RuntimeException("No se tiene capacidad para almacenar un nuevo elemento");
        }
        array[count] = a;
        count++;
    }


    @Override
    public void remove(T a) {
        for (int i = 0; i < count; i++) {
            if (Objects.equals(a, (T) array[i])) {
                // Se reemplaza el elemento removido por el ultimo.
                array[i] = array[count - 1];
                count--;
                return;
            }
        }
    }


    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }


    @Override
    public T choose() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacio");
        }
        if (this.count == 1) {
            return (T) this.array[0];
        }
        int randomIndex = random.nextInt(count);
        return (T) this.array[randomIndex];
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GenericSet<?> other = (GenericSet<?>) o;
        if (this.count != other.count) {
            return false;
        }
        // Verificar que cada elemento de this se encuentre en other
        for (int i = 0; i < this.count; i++) {
            boolean found = false;
            for (int j = 0; j < other.count; j++) {
                if (Objects.equals((T) this.array[i], (T) other.array[j])) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        for (int i = 0; i < count; i++) {
            hash = 31 * hash + Objects.hashCode(array[i]);
        }
        return hash;
    }
}
