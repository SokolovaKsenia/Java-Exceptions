package com.epam.rd.qa.basicio;

import java.util.Arrays;

/**
 * Encapsulates two-dimensional array-matrix block of real ({@code double}) type.
 * {@code Matrix} is the cover for two-dimensional array of real values, storing matrix
 * values with operations of matrix addition, deduction, and multiplication.
 */
public class Matrix {

    private final double[][] values;
    private final int rows;
    private final int cols;

    /**
     * Creates an empty matrix with predetermined number
     * of rows and columns (all values in matrix equal to 0)
     *
     * @param rows number of rows
     * @param cols number of columns
     * @throws MatrixException if {@code rows} or {@code cols} less than 1
     */
    public Matrix(int rows, int cols) throws MatrixException {
        checkSize(rows, cols);
        this.rows = rows;
        this.cols = cols;
        values = new double[rows][cols];
    }

    /**
     * Creates a matrix based on existing two-dimensional array
     * @param values
     * @throws MatrixException if {@code rows} or {@code cols} less than 1
     */
    public Matrix(double[][] values) throws MatrixException {
        try {
            rows = values.length;
            cols = values[0].length;
            checkSize(rows, cols);
            this.values = values;
        } catch (RuntimeException e) {
            throw new MatrixException(e);
        }
    }

    private void checkSize(int rows, int cols) throws MatrixException {
        if (rows < 1 || cols < 1) {
            throw new MatrixException("Count of rows and columns must be greater or equal to 1, actual: " +
                    "rows=" + rows + ", columns=" + cols);
        }
    }

    /**
     * Returns count of matrix rows.
     * @return
     */
    public int getRows() {
        return rows;
    }

    /**
     * Returns count of matrix columns
     * @return
     */
    public int getColumns() {
        return cols;
    }

    /**
     * Returns an element via predetermined correct indexes.
     * @param row row index
     * @param col column index
     * @return the element via indexes
     * @throws MatrixException if index out of bounds
     */
    public double get(int row, int col) throws MatrixException {
        checkIndexes(row, col);
        return values[row][col];
    }

    /**
     * Sets new value via predetermined correct indexes.
     * @param row row index
     * @param col column index
     * @param value value to set
     * @throws MatrixException if index out of bounds
     */
    public void set(int row, int col, double value) throws MatrixException {
        checkIndexes(row, col);
        values[row][col] = value;
    }

    /**
     * Returns standard two-dimensional array out of matrix.
     * Any changes in the returned array will be reflected to internal array.
     * @return matrix values
     */
    public double[][] toArray() {
        return values;
    }

    private void checkIndexes(int row, int col) throws MatrixException {
        if (row >= rows || col >= cols) {
            throw new MatrixException("row=" + row + ", column=" + col);
        }
    }

    /**
     * Adds all elements of {@code other} matrix to corresponding elements
     * of this matrix and creates new {@code Matrix} with resulting two-dimensional array
     * @param other another {@code Matrix} object
     * @return new matrix
     * @throws MatrixException if matrices have different size
     */
    public Matrix add(Matrix other) throws MatrixException {
        checkSizeEquality(other);
        Matrix res = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.values[i][j] = values[i][j] + other.values[i][j];
            }
        }
        return res;
    }

    /**
     * Subtract all elements of {@code other} matrix from corresponding elements
     * of this matrix and creates new {@code Matrix} with resulting two-dimensional array
     * @param other another {@code Matrix} object
     * @return new matrix
     * @throws MatrixException if matrices have different size
     */
    public Matrix subtract(Matrix other) throws MatrixException {
        checkSizeEquality(other);
        Matrix res = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.values[i][j] = values[i][j] - other.values[i][j];
            }
        }
        return res;
    }

    /**
     * Multiply this matrix to {@code other} matrix.<br/>
     * See
     * <a href="https://en.wikipedia.org/wiki/Matrix_multiplication">Matrix multiplication</a>
     * <a href="https://en.wikipedia.org/wiki/Matrix_multiplication_algorithm">Matrix multiplication algorithm</a>
     * @param other another matrix
     * @return new matrix
     * @throws MatrixException if matrices have non-compliant sizes
     */
    public Matrix multiply(Matrix other) throws MatrixException {
        if (rows != other.cols || cols != other.rows) {
            throw new MatrixException("'rows' must be equals to 'other.cols' and vise versa "
                    + "'cols' must be equals to 'other.rows'. Actual: "
                    + rows + ':' + other.cols + ", " + cols + ':' + other.rows);
        }
        Matrix res = new Matrix(new double[rows][other.cols]);
        for (int i = 0; i < res.rows; i++) {
            for (int j = 0; j < res.cols; j++) {
                for (int n = 0; n < other.rows; n++) {
                    res.values[i][j] += values[i][n] * other.values[n][j];
                }
            }
        }
        return res;
    }

    private void checkSizeEquality(Matrix other) throws MatrixException {
        if (rows != other.rows || cols != other.cols) {
            throw new MatrixException("Sizes of matrices must be equal, "
                    + rows + ':' + other.rows + ", " + cols + ':' + other.cols);
        }
    }

    @Override
    public String toString() {
        return "Matrix{" + Arrays.deepToString(values) + '}';
    }
}
