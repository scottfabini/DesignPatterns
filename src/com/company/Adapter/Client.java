package com.company.Adapter;

/**
 * Test client for adapter pattern.  Creates a 2D array that is used to
 * generate a Matrix object.  Then we use the Adapter methods on that matrix.
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/15/16
 */
public class Client {
    private static final int rowCount = 4;
    private static final int columnCount = 5;
    private static double [] [] array2D;

    public static void main(String[] args) {
        array2D = new double [rowCount] [columnCount];
        for (int i = 0; i < rowCount; ++i) {
            for (int j = 0; j < columnCount; ++j) {
                array2D[i][j] = i + j;
            }
        }

        System.out.println("Base matrix: ");
        Matrix matrix = new Matrix(array2D);
        System.out.println(matrix);
        Matrix newMatrix = Adapter.add(matrix, matrix);
        System.out.println("Add of identical matrices:");
        System.out.println(newMatrix);
        newMatrix = Adapter.sub(matrix, matrix);
        System.out.println("Sub of identical matrices:");
        System.out.println(newMatrix);
    }
}
