/**
 * Created by Алексей on 08.10.2016.
 */
public class Runner {
    public static void main(String[] args) throws InterruptedException {

        Matrix matrixA = new Matrix(6, 1);
        Matrix matrixB = new Matrix(6, 1);
        System.out.println(matrixA);
        System.out.println(matrixB);

       Matrix C = MultiMatrixMultiplication.composition(matrixA, matrixB);//кол=во потоков = размерность матрицы/2
       //Matrix C = MultiMatrixMultiplication.composition(matrixA, matrixB, 2); //2 потока
        System.out.println(C);

        Matrix matrixaa = new Matrix(6, 2);
        Matrix matrixbb = new Matrix(6, 2);
        System.out.println(matrixaa);
        System.out.println(matrixbb);

        Matrix Cc = MultiMatrixMultiplication.composition(matrixaa, matrixbb);
        System.out.println(Cc);





    }
}
