package org.example.model;

public class StaticSnailMatrix implements SnailMatrix {
    private int[][] matrix; // Matriz caracol
    private int size; // Tamaño de la matriz (n x n)
    private int currentValue; // Valor actual a agregar
    private int currentRow, currentCol; // Posición actual en la matriz
    private int direction; // Dirección actual (0: derecha, 1: abajo, 2: izquierda, 3: arriba)
    private int[] rowDirections = {0, 1, 0, -1}; // Movimiento en filas
    private int[] colDirections = {1, 0, -1, 0}; // Movimiento en columnas

    public StaticSnailMatrix(int n) {
        this.size = n;
        this.matrix = new int[n][n];
        this.currentValue = 1;
        this.currentRow = 0;
        this.currentCol = 0;
        this.direction = 0;
    }

    @Override
    public void add(int value) {
        if (currentValue > size * size) { //O(c)
            throw new IllegalStateException("La matriz caracol está llena");
        }
        matrix[currentRow][currentCol] = value;//O(c)
        currentValue++;//O(c)
        moveToNextPosition();//O(c)
    } //total: //O(c)

    @Override
    public void print() {
        System.out.println("Snail Matrix: ");
        for (int i = 0; i < size; i++) { //O(n)
            for (int j = 0; j < size; j++) { //O(n)
                System.out.print(matrix[i][j] + " "); //O(c)
            }
            System.out.println(); //O(c)
        }
    } // Complejidad total: O(n^2)

    private void moveToNextPosition() {
        int nextRow = currentRow + rowDirections[direction]; //O(c)
        int nextCol = currentCol + colDirections[direction];//O(c)

        if (nextRow >= 0 && nextRow < size && nextCol >= 0 && nextCol < size && matrix[nextRow][nextCol] == 0) { //O(c)
            currentRow = nextRow; //O(c)
            currentCol = nextCol; //O(c)
            return; //O(c)
        }
        direction = (direction + 1) % 4; //O(c)
        currentRow += rowDirections[direction]; //O(c)
        currentCol += colDirections[direction]; //O(c)
    } // Complejidad total: O(c)
}