package matrix;

/**
 * Created by umesh on 8/11/15.
 */
public class MatrixUtil {
    public static Integer produce(int i, int k, Matrix<Integer> first, Matrix<Integer> second) {
        int result = 0;
        for(int j=0;j<first.getColCount();j++) {
            result += (first.data[i][j] * second.data[j][k]);
        }
        return result;
    }
}
