package matrix;

/**
 * Created by umesh on 8/10/15.
 */
public class Matrix<T extends Number> {

    T[][] data;

    public Matrix(T[][] data) {
        this.data = data;
    }

    public int getRowCount() {
        return data.length;
    }

    public int getColCount() {
        return data[0].length;
    }

    public T getValue(int i, int j) {
        return data[i][j];
    }


}
