package org.example.ejercicio2.model;

@SuppressWarnings("unchecked")
public class GenericPriorityQueue<T> implements PriorityQueueT<T> {

    private static final int MAX = 10000;
    private final Object[] values;
    private final int[] priorities;
    private int count;

    /**
     * Constructor.
     * Pre: -
     * Post: Se crea una cola con prioridad generica vacia con capacidad MAX.
     */
    public GenericPriorityQueue() {
        this.values = new Object[MAX];
        this.priorities = new int[MAX];
        this.count = 0;
    }

    /**
     * Retorna el primer elemento de la cola con prioridad sin eliminarlo.
     * Pre: La cola no debe estar vacia.
     * Post: Retorna el primer elemento, segun la politica de prioridad.
     *
     * @return el primer elemento.
     */
    @Override
    public T getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el valor de una cola vacia");
        }
        return (T) this.values[0];
    }

    /**
     * Retorna la prioridad asociada al primer elemento de la cola.
     * Pre: La cola no debe estar vacia.
     * Post: Retorna la prioridad del primer elemento.
     *
     * @return la prioridad del primer elemento.
     */
    @Override
    public int getPriority() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener la prioridad de una cola vacia");
        }
        return this.priorities[0];
    }

    /**
     * Indica si la cola con prioridad esta vacia.
     * Pre: No hay precondiciones.
     * Post: Retorna true si la cola esta vacia, false en caso contrario.
     *
     * @return true si la cola esta vacia, false de lo contrario.
     */
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Agrega un elemento junto con su prioridad a la cola.
     *
     * Pre: La cola no debe estar llena.
     * Post: Se agrega el elemento en la posicion correspondiente segun su prioridad.
     *
     * @param a el elemento a agregar.
     * @param priority la prioridad asociada al elemento.
     */
    @Override
    public void add(T a, int priority) {
        if (this.count == MAX) {
            throw new RuntimeException("No se tiene capacidad para almacenar un nuevo elemento");
        }
        if (this.isEmpty()) {
            this.values[0] = a;
            this.priorities[0] = priority;
            this.count = 1;
            return;
        }

        // Si la prioridad del ultimo elemento es menor o igual que la dada, se agrega al final.
        if (this.priorities[this.count - 1] <= priority) {
            this.values[count] = a;
            this.priorities[count] = priority;
            this.count++;
            return;
        }

        // Si la prioridad del primer elemento es mayor que la dada, se inserta al inicio.
        if (this.priorities[0] > priority) {
            for (int i = this.count - 1; i >= 0; i--) {
                this.values[i + 1] = this.values[i];
                this.priorities[i + 1] = this.priorities[i];
            }
            this.values[0] = a;
            this.priorities[0] = priority;
            this.count++;
            return;
        }

        // Buscar el indice del primer elemento con la misma prioridad.
        int index = findIndex(priority);
        if (index != -1) {
            int candidate = index;
            while (candidate < this.count && this.priorities[candidate] == priority) {
                candidate++;
            }
            for (int i = this.count - 1; i >= candidate; i--) {
                this.values[i + 1] = this.values[i];
                this.priorities[i + 1] = this.priorities[i];
            }
            this.values[candidate] = a;
            this.priorities[candidate] = priority;
            this.count++;
            return;
        }

        // Si no se encontro un elemento con la misma prioridad, buscar el lugar donde insertar.
        int candidate = 0;
        while (candidate < this.count && this.priorities[candidate] <= priority) {
            candidate++;
        }
        for (int i = this.count - 1; i >= candidate; i--) {
            this.values[i + 1] = this.values[i];
            this.priorities[i + 1] = this.priorities[i];
        }
        this.values[candidate] = a;
        this.priorities[candidate] = priority;
        this.count++;
    }

    /**
     * Metodo privado auxiliar que busca el indice del primer elemento con la prioridad dada.
     * Pre: -
     * Post: Retorna el indice del primer elemento con la prioridad especificada, o -1 si no se encuentra.
     *
     * @param priority la prioridad a buscar.
     * @return el indice del primer elemento con esa prioridad, o -1 si no existe.
     */
    private int findIndex(int priority) {
        for (int i = 0; i < this.count; i++) {
            if (this.priorities[i] == priority) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Remueve el primer elemento de la cola con prioridad.
     * Pre: La cola no debe estar vacia.
     * Post: Se elimina el primer elemento de la cola.
     */
    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacia");
        }
        for (int i = 0; i < this.count - 1; i++) {
            this.values[i] = this.values[i + 1];
            this.priorities[i] = this.priorities[i + 1];
        }
        this.count--;
    }
}
