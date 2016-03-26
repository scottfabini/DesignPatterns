package com.company.Adapter;

/**
 * A basic matrix class with constructor, plus and minus operations, and
 * a getNumRows and getNumColumns methods.
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/15/16
 */
public class Matrix {
    private int numRows;  // Number of rows in the matrix
    private int numColumns; // Number of columns in the matrix
    private static double [] [] array2D; // internal representation of the matrix is as a 2D array

    /**
     * Initializing constructor for Matrix.
     * @param entry A 2D array used to initialize the matrix
     */
    public Matrix (double [] [] entry) {
        numRows = entry.length;
        // assuming non-jagged array
        numColumns = entry[0].length;
        array2D = new double [numRows][numColumns];
        // deep copy
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numColumns; ++j) {
                array2D[i][j] = entry[i][j];
            }
        }
    }
    private int getNumRows() {
        return this.numRows;
    }
    private int getNumColumns() {
        return this.numColumns;
    }

    /**
     * Matrix addition
     * @param l the left operand Matrix
     * @param r the right operand Matrix
     * @return the new Matrix
     */
    public static Matrix plus (Matrix l, Matrix r) {
        int numRows = l.getNumRows();
        int rNumRows = r.getNumRows();
        int numColumns = l.getNumColumns();
        int rNumColumns = r.getNumColumns();
        if (numRows != rNumRows) {
            throw new RuntimeException();
        }
        if (numColumns != rNumColumns) {
            throw new RuntimeException();
        }

        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numColumns; ++j) {
                array2D[i][j] = l.array2D[i][j] + r.array2D[i][j];
            }
        }
        return new Matrix(array2D);
    }

    /**
     * Matrix subtraction
     * @param l the left operand matrix
     * @param r the right operand matrix
     * @return the new matrix
     */
    public static Matrix minus (Matrix l, Matrix r) {
        int numRows = l.getNumRows();
        int rNumRows = r.getNumRows();
        int numColumns = l.getNumColumns();
        int rNumColumns = r.getNumColumns();
        if (numRows != rNumRows) {
            throw new RuntimeException();
        }
        if (numColumns != rNumColumns) {
            throw new RuntimeException();
        }

        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numColumns; ++j) {
                array2D[i][j] = l.array2D[i][j] - r.array2D[i][j];
            }
        }
        return new Matrix(array2D);

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numColumns; ++j) {
                sb.append(array2D[i][j]);
                sb.append(", ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
