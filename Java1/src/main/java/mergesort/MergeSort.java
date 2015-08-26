package mergesort;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by umesh on 8/23/15.
 */
public class MergeSort {
    public static void main(String[] args) {
        /**
        String fooReg = "aa(.*)bb";
        Matcher matcher = Pattern.compile(fooReg).matcher("aaxxxxadhsadbb");
        int count = matcher.groupCount();
        String group = matcher.group(0);
         **/
        String foo = "aa             bb";
        String[] result = foo.split("[ ]+");
        System.out.println(Arrays.toString(result));
        int[] testArray = new int[] {25, 1, 200, 10, -1, -3, -100, 300};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    int[] helper;
    public void mergeSort(int[] a) {
        if(a == null || a.length ==1) {
            return;
        }
        helper = new int[a.length];
        sort(a, 0, a.length-1);
    }
    public void sort(int[] a, int start, int end) {
        if(start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        sort(a, 0, mid);
        sort(a, mid+1, end);
        merge(a,0,mid,mid+1, end);
    }

    private void merge(int[]a, int start1, int end1, int start2, int end2) {
        int i = start1;
        int j = start2;
        int k = start1;
        while(k <= end2) {
            if(i > end1) {
                //copy(a, j, end2, helper, k, end2);
                System.arraycopy(a,j, helper, k, (end2-j+1));
                break;
            }
            if(j > end2) {
                //copy(a, i, end1, helper, k, end2);
                System.arraycopy(a,i, helper, k, (end1-i+1));
                break;
            }
            if (a[i] < a[j]) {
                helper[k] = a[i];
                k++;
                i++;
            } else {
                helper[k] = a[j];
                k++;
                j++;
            }
        }
        //copy(helper, start1, end2, a, start1, end2);
        System.arraycopy(helper, start1, a, start1, (end2-start1+1));

    }

    private void copy(int[] a, int s1, int e1, int[] h, int s2, int e2) {
        for(int i=s1,j=s2;i<=e1;i++, j++) {
            h[j] = a[i];
        }
    }


}
