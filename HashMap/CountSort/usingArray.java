package HashMap.CountSort;

import java.util.Arrays;

public class usingArray {
    public static void main(String[] args) {
        int [] arr = { 4,3,5,2,3,10,2,2,4};
        System.out.println(Arrays.toString(arr));
        countSorter(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void countSorter(int [] arr){
        int [] freq = new int[max(arr)+1];
        for (int i = 0; i < arr.length; i++) {
            int elem = arr[i];
            freq[elem]++;
        }
        int k = 0 ;
        for (int i = 0; i < freq.length; i++) {
            while(freq[i] > 0){
                arr[k] = i ;
                freq[i]--;
                k++;
            }
        }
    }
    private static int max(int [] arr){
        int max = arr[0] ;
        for (int i = 1; i < arr.length ;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max ;
    }

}
