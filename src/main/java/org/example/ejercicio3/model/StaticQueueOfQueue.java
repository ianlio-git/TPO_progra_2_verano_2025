package org.example.ejercicio3.model;

import java.util.Arrays;

/**
 * Implementacion de QueueOfQueue usando un array de Queue.
 */
public class StaticQueueOfQueue implements QueueOfQueue {

    private static final int MAX = 10000;
    private final Queue[] array;
    private int count;

    /**
     * Constructor.
     * Pre: -
     * Post: Se crea una QueueOfQueue vacia con capacidad MAX.
     */
    public StaticQueueOfQueue() {
        this.array = new Queue[MAX];
        this.count = 0;
    }

    /**
     * Retorna la primera Queue sin eliminarla.
     * Pre: La QueueOfQueue no debe estar vacia.
     * Post: Retorna la primera Queue.
     */
    @Override
    public Queue getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primer elemento de una QueueOfQueue vacia");
        }
        return this.array[0];
    }

    /**
     * Indica si la QueueOfQueue esta vacia.
     * Pre: -
     * Post: Retorna true si vacia, false de lo contrario.
     */
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Agrega una Queue al final de la QueueOfQueue.
     * Pre: -
     * Post: Se agrega la Queue q al final.
     * @param q la Queue a agregar.
     */
    @Override
    public void add(Queue q) {
        if (this.count >= MAX) {
            throw new RuntimeException("QueueOfQueue is full");
        }
        this.array[count] = q;
        count++;
    }

    /**
     * Remueve la primera Queue de la QueueOfQueue.
     * Pre: La QueueOfQueue no debe estar vacia.
     * Post: Se elimina la primera Queue.
     */
    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede remover de una QueueOfQueue vacia");
        }
        for (int i = 0; i < count - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        count--;
    }

    /**
     * Concatenate: Recibe n instancias de QueueOfQueue y retorna una nueva QueueOfQueue con todos los elementos,
     * manteniendo el orden en que se leyeron.
     * Pre: Se reciben instancias de QueueOfQueue.
     * Post: Retorna una nueva instancia que contiene todos los elementos de las instancias dadas.
     * @param queues instancias de QueueOfQueue a concatenar.
     * @return una nueva QueueOfQueue con todos los elementos.
     */
    @Override
    public QueueOfQueue concatenate(QueueOfQueue... queues) {
        StaticQueueOfQueue result = new StaticQueueOfQueue();
        // Iterar sobre cada QueueOfQueue recibido.
        for (QueueOfQueue qoq : queues) {
            while (!qoq.isEmpty()) {      // Para cada instancia, recorre todas sus colas
                result.add(qoq.getFirst());
                qoq.remove();
            }
        }
        return result;
    }

    /**
     * Flat: Crea una nueva Queue a partir de la QueueOfQueue con los mismos elementos.
     * Pre: -
     * Post: Retorna una nueva instancia de Queue que contiene todos los elementos de cada Queue interna,
     * manteniendo el orden.
     * @return una Queue con todos los elementos.
     */
    @Override
    public Queue flat() {
        // Usamos la implementacion StaticQueue (de ints) ya existente.
        StaticQueue flatQueue = new StaticQueue();
        // Mientras existan colas en la QueueOfQueue
        while (!this.isEmpty()) {
            Queue current = this.getFirst();
            // Mientras la cola interna no este vacia, transferir sus elementos a flatQueue.
            while (!current.isEmpty()) {
                flatQueue.add(current.getFirst());
                current.remove();
            }
            this.remove();
        }
        return flatQueue; // O(c)
    }

    /**
     * reverseWithDepth: Invierte la QueueOfQueue y tambien invierte cada Queue interna.
     * Pre: -
     * Post: Retorna una nueva QueueOfQueue en la que el orden de las colas se invierte, y cada Queue interna tambien.
     * @return una nueva QueueOfQueue invertida.
     */
    @Override
    public QueueOfQueue reverseWithDepth() {
        int n = count;
        // Copiar las colas actuales en un array auxiliar
        Queue[] aux = new Queue[n];
        for (int i = 0; i < n; i++) {
            aux[i] = this.array[i];
        }
        // Invertir el array auxiliar
        for (int i = 0; i < n / 2; i++) {
            Queue temp = aux[i];
            aux[i] = aux[n - 1 - i];
            aux[n - 1 - i] = temp;
        }
        // Para cada cola en aux, invertirla (usando el metodo reverseQueue implementado abajo)
        for (int i = 0; i < n; i++) {
            aux[i] = reverseQueue(aux[i]);
        }
        // Crear una nueva instancia de StaticQueueOfQueue y agregar las colas invertidas
        StaticQueueOfQueue result = new StaticQueueOfQueue();
        for (int i = 0; i < n; i++) {
            result.add(aux[i]);
        }
        return result;
    }

    /**
     * Metodo privado auxiliar para invertir una Queue.
     * Utiliza un StaticStack para invertir el orden de los elementos.
     * Pre: La Queue no debe estar vacia.
     * Post: Retorna una nueva Queue con el mismo contenido en orden invertido.
     * @param q la Queue a invertir.
     * @return una Queue invertida.
     */
    private Queue reverseQueue(Queue q) {
        StaticStack stack = new StaticStack();
        while (!q.isEmpty()) {
            stack.add(q.getFirst());
            q.remove();
        }
        StaticQueue reversed = new StaticQueue();
        while (!stack.isEmpty()) {
            reversed.add(stack.getTop());
            stack.remove();
        }
        return reversed;
    }
}
