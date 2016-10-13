import java.util.Arrays;

/**
 * Created by Алексей on 08.10.2016.
 */
public class Matrix {

    private int dimension;
    private Integer[][] matrix;
    public Matrix(int dimension, int value) {
        this.dimension = dimension;
        matrix = new Integer[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = (j+value) *(i+value);
            }
        }
    }
    public Matrix(int dimension) {
        this.dimension = dimension;
        matrix = new Integer[dimension][dimension];
    }

    public int getDimension() {
        return dimension;
    }
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public void setNumber (int i, int j, int result)
    {
        matrix[i][j] = result;
            }

    public Integer[][] getMatrix() {
        return matrix;
    }
    public void setMatrix(Integer[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < getDimension(); i++){
            for( int j = 0; j < getDimension(); j++){
                s.append( this.matrix[i][j]+ " ");}
            s.append( "\n");}
        return s.toString();
    }
}

