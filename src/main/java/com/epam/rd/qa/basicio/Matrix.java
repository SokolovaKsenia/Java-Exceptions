package com.epam.rd.qa.basicio;

/**
 * Encapsulates two-dimensional array-matrix block of real ({@code double}) type.
 * {@code Matrix} is the cover for two-dimensional array of real values, storing matrix
 * values with operations of matrix addition, deduction, and multiplication.
 */
public class Matrix {

    /**
     * Creates an empty matrix with predetermined number
     * of rows and columns (all values in matrix equal to 0)
     *
     * @param rows number of rows
     * @param cols number of columns
     * @throws MatrixException if {@code rows} or {@code cols} less than 1
     */
    public Matrix(int rows, int cols) throws MatrixException {
        throw new UnsupportedOperationException();
    }

    /**
     * Creates a matrix based on existing two-dimensional array
     *
     * @param values two-dimensional array
     * @throws MatrixException if {@code rows} or {@code cols} less than 1
     */
    public Matrix(double[][] values) throws MatrixException {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns count of matrix rows.
     *
     * @return count of rows in the matrix
     */
    public int getRows() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns count of matrix columns
     *
     * @return count of columns in the matrix
     */
    public int getColumns() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns an element via predetermined correct indexes.
     *
     * @param row row index
     * @param col column index
     * @return the element via indexes
     * @throws MatrixException if index out of bounds
     */
    public double get(int row, int col) throws MatrixException {
        throw new UnsupportedOperationException();
    }

    /**
     * Sets new value via predetermined correct indexes.
     *
     * @param row   row index
     * @param col   column index
     * @param value value to set
     * @throws MatrixException if index out of bounds
     */
    public void set(int row, int col, double value) throws MatrixException {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns standard two-dimensional array out of matrix.
     * Any changes in the returned array will be reflected to internal array.
     *
     * @return matrix values
     */
    public double[][] toArray() {
        throw new UnsupportedOperationException();
    }

    /**
     * Adds all elements of {@code other} matrix to corresponding elements
     * of this matrix and creates new {@code Matrix} with resulting two-dimensional array
     *
     * @param other another {@code Matrix} object
     * @return new matrix
     * @throws MatrixException if matrices have different size
     */
    public Matrix add(Matrix other) throws MatrixException {
        throw new UnsupportedOperationException();
    }

    /**
     * Subtract all elements of {@code other} matrix from corresponding elements
     * of this matrix and creates new {@code Matrix} with resulting two-dimensional array
     *
     * @param other another {@code Matrix} object
     * @return new matrix
     * @throws MatrixException if matrices have different size
     */
    public Matrix subtract(Matrix other) throws MatrixException {
        throw new UnsupportedOperationException();
    }

    /**
     * Multiply this matrix to {@code other} matrix.<br/>
     * See
     * <a href="https://en.wikipedia.org/wiki/Matrix_multiplication">Matrix multiplication</a>
     * <a href="https://en.wikipedia.org/wiki/Matrix_multiplication_algorithm">Matrix multiplication algorithm</a>
     *
     * @param other another matrix
     * @return new matrix
     * @throws MatrixException if matrices have non-compliant sizes
     */
    public Matrix multiply(Matrix other) throws MatrixException {
        throw new UnsupportedOperationException();
    }
}
