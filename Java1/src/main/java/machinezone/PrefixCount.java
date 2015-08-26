package machinezone;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by umesh on 8/25/15.
 */
public class PrefixCount {

    Set<String> subWordSet = new HashSet();
    List<Tuple<String, Integer>> topCount = new ArrayList();
    String minWord = null;
    int minLength = -1;

    List<Tuple<String, Integer>> getTopPrefixList(int top, String filename) throws IOException {
        List<Tuple<String, Integer>> result = new ArrayList();
        populate();
        findTopCount(top);
        return topCount;
    }

    private void findTopCount(int top) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/tmp/words"));
        String word = null;
        while ((word = br.readLine()) != null) {
            if (subWordSet.contains(word)) {
                if (topCount.size() < top) {
                    addWord(word);
                    recalculateMin(word);
                } else if (word.length() > minLength) {
                    removeWord();
                    addWord(word);
                    recalculateMin(word);
                }
            }

        }
    }

    private void addWord(String word) {

        Tuple t = new Tuple<String, Integer>();
        t.v1 = word;
        t.v2 = word.length();
        topCount.add(t);
    }

    private void recalculateMin(String word) {
        String mw = null;
        Integer ml = Integer.MAX_VALUE;
        for (Tuple<String, Integer> tuple : topCount) {
            if (tuple.v2 < ml) {
                ml = tuple.v2;
                mw = tuple.v1;
            }
        }
        minWord = mw;
        minLength = ml;
    }

    private void removeWord() {
        Tuple<String, Integer> found = null;
        for (Tuple<String, Integer> tuple : topCount) {
            if (tuple.v1.equals(minWord)) {
                found = tuple;
                break;
            }
        }
        topCount.remove(found);
    }

    private void populate() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/tmp/words"));
        String word = null;
        while ((word = br.readLine()) != null) {
            int length = word.length();
            for (int i = 1; i < length; i++) {
                subWordSet.add(word.substring(0, i));
            }
        }
    }
}
