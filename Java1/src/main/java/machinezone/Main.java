package machinezone;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by umesh on 8/25/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        List<Tuple<String, Integer>> list = new PrefixCount().getTopPrefixList(10, "/tmp/words");
       for(Tuple t: list) {
        System.out.println(t.toString());
       }

    }
}
