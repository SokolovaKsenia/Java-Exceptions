package com.epam.rd.qa.basicio;


public class Matrix {
    private final double[][] internalArray;
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
        if (rows < 1 || cols < 1) {
            throw new MatrixException();
        }
        this.rows = rows;
        this.cols = cols;
        internalArray = new double[rows][cols];
    }

    /**
     * Creates a matrix based on existing two-dimensional array
     *
     * @param values two-dimensional array
     * @throws MatrixException if {@code rows} or {@code cols} less than 1
     */
    public Matrix(double[][] values) throws MatrixException {
        if (values.length == 0 || values[0].length == 0) {
            throw new MatrixException();
        }

        rows = values.length;
        cols = values[0].length;
        for (int i = 0; i < rows; i += 1) {
            if (values[i].length != cols) {
                throw new MatrixException();
            }
        }
        internalArray = values;
    }

    /**
     * Returns count of matrix rows.
     *
     * @return count of rows in the matrix
     */
    public int getRows() {
        return rows;
    }

    /**
     * Returns count of matrix columns
     *
     * @return count of columns in the matrix
     */
    public int getColumns() {
        return cols;
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
        if (row < 0 || col < 0 || row >= rows || col >= cols) {
            throw new MatrixException();
        }
        return internalArray[row][col];
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
        if (row < 0 || col < 0 || row >= rows || col >= cols) {
            throw new MatrixException();
        }
        internalArray[row][col] = value;
    }

    /**
     * Returns standard two-dimensional array out of matrix.
     * Any changes in the returned array will be reflected to internal array.
     *
     * @return matrix values
     */
    public double[][] toArray() {
        return internalArray;
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
        if (other == null || other.getRows() != rows || other.getColumns() != cols) {
            throw new MatrixException();
        }

        Matrix resultMatrix = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix.set(i, j, internalArray[i][j] + other.get(i, j));
            }
        }
        return resultMatrix;
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
        if (other == null || other.getRows() != rows || other.getColumns() != cols) {
            throw new MatrixException();
        }
        Matrix resultMatrix = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix.set(i, j, internalArray[i][j] - other.get(i, j));
            }
        }
        return resultMatrix;
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
        if (other == null || cols != other.getRows()) {
            throw new MatrixException();
        }
        Matrix resultMatrix = new Matrix(rows, other.getColumns());

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.getColumns(); j++) {
                resultMatrix.set(i, j, sumMultiplyRowColumn(i, j, other));
            }
        }
        return resultMatrix;
    }

    private double sumMultiplyRowColumn(int rowIndex, int columnIndex, Matrix other) {
        double result = 0;
        for (int i = 0; i < cols; i++) {
            result += internalArray[rowIndex][i] + other.get(i, columnIndex);
        }
        return result;
    }
}