package tetris;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by umesh on 8/25/15.
 */
public class StreamTest {
    public void test() {
        ArrayList<Object> list = new ArrayList();
        list.add(1);
        list.add(200);
        List inner = new ArrayList<Integer>();
        inner.add(22);
        inner.add(2222);
        inner.add(222222);
        list.add(inner);

        list.stream()
                .flatMap(x ->
                {
                    if (x instanceof Collection) {
                        return ((Collection) x).stream();
                    } else {
                        ArrayList al = new ArrayList();
                        al.add(x);
                        return al.stream();
                    }
                })
                .forEach(x -> System.out.println(x));
    }
}
