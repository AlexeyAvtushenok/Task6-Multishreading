/**
 * Created by Алексей on 08.10.2016.
 */
public class MatrixMultiplication {

//обычное перемножение матриц

    public static  Matrix composition(Matrix A, Matrix B)
    {
        if (A.getDimension() != B.getDimension()) {
            System.out.print("matrices are not the same!");
            return null;}
        int dimension = A.getDimension();

        Matrix matrixx = new Matrix(dimension);
        Integer[][] matrix = new Integer[dimension][dimension];

        for (int i = 0; i<dimension; i ++)
            for (int j = 0; j<dimension; j ++)
                matrix[i][j] = rowColDimension(A, i, B, j);
         matrixx.setMatrix(matrix);

        return matrixx;
    }
    private static int rowColDimension(Matrix A, int row, Matrix B, int col)
    {
        Integer matrixA [][] =  A.getMatrix();
        Integer matrixB [][] = B.getMatrix();
        Integer matrixARow [] = new Integer[A.getDimension()];
        Integer matrixBCol [] = new Integer[B.getDimension()];
        for (int i = 0; i < A.getDimension(); i++)
            matrixARow[i] = matrixA[row][i];
        for (int i = 0; i < B.getDimension(); i++)
            matrixBCol[i] = matrixB[i][col];
        int value = 0;
        for (int i = 0; i < matrixARow.length; i++)
        {
            value += matrixARow[i]*matrixBCol[i];

        }
        return value;
    }
}
