import java.util.ArrayList;

/**
 * Created by Алексей on 09.10.2016.
 */
public class MultiMatrixMultiplication extends Thread{//многопоточное перемножение матриц
    private static Matrix  result;
    private Matrix A;
    private Matrix B;

    private static Matrix compositionMeth(Matrix A, Matrix B, int threadCount) throws InterruptedException {
        result = new Matrix(A.getDimension());
        MultiMatrixMultiplication[] thread = new MultiMatrixMultiplication[threadCount];
        for (int i = 0; i < thread.length; i++) {
            thread[i] = new MultiMatrixMultiplication(A, B, result);
            thread[i].start();
        }
        for (int i = 0; i < thread.length; i++) {
            thread[i].join();
        }
        return result;
    }

    private static int rowColDimension(Matrix A, int row, Matrix B, int col, Integer matrix) {
        synchronized (matrix) {
            Integer matrixA[][] = A.getMatrix();
            Integer matrixB[][] = B.getMatrix();
            Integer matrixARow[] = new Integer[A.getDimension()];
            Integer matrixBCol[] = new Integer[B.getDimension()];
            for (int i = 0; i < A.getDimension(); i++)
                matrixARow[i] = matrixA[row][i];
            for (int i = 0; i < B.getDimension(); i++)
                matrixBCol[i] = matrixB[i][col];
            int value = 0;
            for (int i = 0; i < matrixARow.length; i++) {
                value += matrixARow[i] * matrixBCol[i];
            }

            return value;
        }
    }

    public MultiMatrixMultiplication(Matrix a, Matrix b, Matrix result) {
       this.result = result;
        A = a;
        B = b;
    }

    public void run() {
        Integer[][] matrix = result.getMatrix();
        int demension = A.getDimension();

        int value;

        for (int i = 0; i < demension; i++) {
            for (int j = 0; j < demension; j++) {
                if (matrix[i][j] == null) {
                    matrix[i][j] = 0;
                    value = rowColDimension(A, i, B, j, matrix[i][j]);
                    result.setNumber(i,j,value);
                    System.out.println(getName() + " ["+ i + "," + j +"]");
                }
            }

        }

    }

    public static  Matrix composition(Matrix A, Matrix B, int ThreadCount) throws InterruptedException {
        return compositionMeth(A, B,ThreadCount);
    }
    public static  Matrix composition(Matrix A, Matrix B) throws InterruptedException {

      int threadCount = A.getDimension()/2;

        return compositionMeth(A, B,threadCount);
    }


}
