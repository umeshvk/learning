package tetris2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by umesh on 8/25/15.
 */
public class Main {
    public static void main(String[] args) {
        //new StreamTest().test();
        List<Range> rl = new ArrayList<Range>();
        Range r = null;

        r = new Range();
        r.x = 3;
        r.size = 3;
        r.height = 3;

        rl.add(r);

        r = new Range();
        r.x = 8;
        r.size = 1;
        r.height = 1;

        rl.add(r);


        Range r2 = new Range();
        r2.x = 4;
        r2.size = 3;
        r2.height = 0;

        List result = rl.stream()
                .flatMap(rx ->
                {
                    return rx.intersect(r2).stream();
                }).collect(Collectors.toList());

        r2.height = r2.height + r2.size;

        result.add(r2);
        result.stream().forEach(System.out::println);
    }
}
