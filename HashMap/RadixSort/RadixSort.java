package HashMap.RadixSort;

import java.util.Arrays;
import java.util.Collections;

public class RadixSort {
    public static void main(String[] args) {
        int [] arr = { 4,3,5,2,3,10,2,2,4};
        System.out.println(Arrays.toString(arr));
        radixSorter(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSorter(int [] arr){
        int max = Arrays.stream(arr).max().getAsInt();
        int dig = (int)(Math.log10(max)) + 1 ;
        int n = 1 ;
        for (int i = 0; i < dig; i++) {
            int [] freq = new int [10];
            for (int j = 0; j < arr.length; j++) {
                int elem = (arr[j]/n)%10;
                freq[elem]++;
            }

            int [] output = new int[10];
            n = n*10;
        }
    }

}
