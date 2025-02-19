package org.example.ejercicio2.model;

@SuppressWarnings("unchecked")
public class GenericStack<T> implements StackT<T> {

    private static final int DEFAULT_MAX = 10000;
    private Object[] array;
    private int count;

    /**
     * Constructor que inicializa el stack generico.
     * Pre: -
     * Post: Se crea un stack con capacidad DEFAULT_MAX.
     */
    public GenericStack() {
        this.array = new Object[DEFAULT_MAX];
        this.count = 0;
    }

    /**
     * Retorna el elemento en la parte superior del stack.
     * Pre: El stack no debe estar vacio.
     * Post: Retorna el elemento superior sin eliminarlo.
     * @return el elemento superior.
     */
    @Override
    public T getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("getTop() called on empty stack");
        }
        return (T) this.array[count - 1];
    }

    /**
     * Indica si el stack esta vacio.
     * Pre: No hay precondiciones.
     * Post: Retorna true si el stack esta vacio, false de lo contrario.
     * @return true si vacio, false si no.
     */
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Agrega un elemento al stack.
     * Pre: El stack debe tener capacidad.
     * Post: Se agrega el elemento a la parte superior del stack.
     * @param a el elemento a agregar.
     */
    @Override
    public void add(T a) {
        if (count >= DEFAULT_MAX) {
            throw new RuntimeException("Stack overflow");
        }
        this.array[count++] = a;
    }

    /**
     * Remueve el elemento en la parte superior del stack.
     * Pre: El stack no debe estar vacio.
     * Post: Se elimina el elemento superior.
     */
    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("remove() called on empty stack");
        }
        count--;
    }
}
