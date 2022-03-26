# Exceptions
[Matrix](src/main/java/com/epam/rd/qa/basicio/Matrix.java)

Expected time - 40 minutes

## Description

To create type `Matrix`, which encapsulates two-dimensional array-matrix 
block of real (`double`) type. 
`Matrix` is the cover for two-dimensional array of real values, storing matrix 
values with operations of matrix addition, deduction and multiplication. 
 
Real type values (`double`) can be in matrix, specifying during creation, the 
number of array rows and columns, which will store these values. After 
creation, the number of rows and columns are not changed. Values to matrix 
elements can be set while creating matrix, and later with the help of indexer. 
`Matrix` can provide information regarding the number of array rows and 
columns, receive array elements in form of two-dimensional standard array, 
add, deduct and multiply matrices compatible by size. If a user is trying to 
perform operations with matrix of incompatible sizes – user type exceptions 
`MatrixException` are thrown from operations. Other matrix methods also 
throw exceptions, if a user applies them incorrectly (conveys incorrect 
parameters into constructor, in indexer – non-existing index and so on). 
 
Implementation of the following functionality is required in Matrix class: 
- Creating of empty matrix with predetermined number of rows and columns 
(all values in matrix equal to 0). 
- Creating of matrix based on existing two-dimensional array. 
- `getRows()` - receiving of number of matrix rows and columns. 
- `getColumns()` - receiving of number of matrix columns. 
- `toArray` - receiving of standard two-dimensional array out of matrix. 
- `get()` - access to recording and reading of elements via predetermined correct index (indexer). 
- `add(Matrix)` - Method of matrices addition. Should return new `Matrix` object.
- `subtract(Matrix)` - Method of matrices deduction. Should return new `Matrix` object.
- `multily(Matrix)` - Method of matrices multiplication. Should return new `Matrix` object.
- Raise exceptions specified in Javadoc-comments to class methods.

