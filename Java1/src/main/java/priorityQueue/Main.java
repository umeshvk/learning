package priorityQueue;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by umesh on 8/25/15.
 */
public class Main {
     Random randomLength = new Random(System.currentTimeMillis());
     Random randomCharacter = new Random(System.currentTimeMillis());

     IntStream charStream = randomCharacter.ints(0,26);

    private static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() == o2.length())
                return 0;
            if(o1.length() < o2.length())
                return 1;
            if(o1.length() > o2.length())
                return -1;
            return 0;
        }
    }

    public static void main(String[] args) {
        new Main().test();
    }

    public void test() {
        PriorityQueue<String> pq = new PriorityQueue<String>(3, new MyComparator());

        pq.add("qe");
        pq.add("rwerwrrw");
        pq.add("aqeqq");
        pq.add("aqqrwerwrwrq");
        pq.add("aqwrewrwrqq");
        pq.add("aqrwerrrwrerwrerwerrwqq");
        pq.add("eee");
        pq.add("ee");


        pq = clean(pq, 2);
        String s1 = pq.poll();
        String s2 = pq.poll();
        System.out.println(s1);
        System.out.println(s2);


        IntStream countStream = randomLength.ints(5, 1, 4);
        //countStream.forEach(System.out::println);
        OptionalDouble avg = countStream.average();
        System.out.println(avg.isPresent() ? avg.getAsDouble(): "-1");
        /*
        while(true) {
            String srand = createRandomString(20);
            System.out.println(srand);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        */
    }


    private  PriorityQueue clean(PriorityQueue<String> pq, int limit) {
        PriorityQueue pq2 = new PriorityQueue<String>(3,  new MyComparator());
        if(pq.size() > limit) {
            for (int i = 0; i < limit; i++) {
                pq2.add(pq.poll());
            }
        }
        return pq2;
    }



    private  String createRandomString(int maxLength) {

        int charCount = randomLength.nextInt(maxLength) +1;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < charCount; i++) {
            sb.append((char)('a' + randomCharacter.nextInt(26)));
        }
        return sb.toString();
    }
}
