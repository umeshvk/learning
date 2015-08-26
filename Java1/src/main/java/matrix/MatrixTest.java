package matrix;

/**
 * Created by umesh on 8/11/15.
 */
public class MatrixTest {
    public static boolean test1()
    {
        Integer[][] data1 = {{1,2, 3}, {10,2,3}};
        Integer[][] data2 = {{1,1}, {1,1}, {1,1}};
        Integer[][] data3 = new Integer[2][3];

        Matrix<Integer> matrix1 = new Matrix<Integer>(data1);
        Matrix<Integer> matrix2 = new Matrix<Integer>(data2);

        System.out.println(matrix1.getColCount());
        System.out.println(matrix1.getRowCount());
        System.out.println(matrix1.getValue(0,0));

        for(int i=0;i<matrix1.getRowCount();i++) {
            for(int k=0;k<matrix2.getColCount();k++) {
                data3[i][k] = MatrixUtil.produce(i, k, matrix1, matrix2);
            }
        }

        Matrix<Integer> result = new Matrix<Integer>(data3);

        System.out.println(result);

        return (result.getValue(1,0) == 15);
    }
}
