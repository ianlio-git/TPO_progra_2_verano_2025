package org.example.ejercicio1.model;

public class StaticSnailMatrix implements SnailMatrix {
    private int[][] matrix;
    private int n;

    public StaticSnailMatrix(int n) {
        this.n = n;
        matrix = new int[n][n];
        fillMatrix();
    }

    private void fillMatrix() {
        int num = 1;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {
            num = fillTopRow(num, top, left, right);
            top++;

            num = fillRightColumn(num, right, top, bottom);
            right--;

            if (top <= bottom) {
                num = fillBottomRow(num, bottom, left, right);
                bottom--;
            }

            if (left <= right) {
                num = fillLeftColumn(num, left, top, bottom);
                left++;
            }
        }
    }

    private int fillTopRow(int num, int row, int left, int right) {
        for (int j = left; j <= right; j++) {
            matrix[row][j] = num++;
        }
        return num;
    }

    private int fillRightColumn(int num, int col, int top, int bottom) {
        for (int i = top; i <= bottom; i++) {
            matrix[i][col] = num++;
        }
        return num;
    }

    private int fillBottomRow(int num, int row, int left, int right) {
        for (int j = right; j >= left; j--) {
            matrix[row][j] = num++;
        }
        return num;
    }

    private int fillLeftColumn(int num, int col, int top, int bottom) {
        for (int i = bottom; i >= top; i--) {
            matrix[i][col] = num++;
        }
        return num;
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
