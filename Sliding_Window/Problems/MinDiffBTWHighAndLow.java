package Sliding_Window.Problems;

import java.util.Arrays;

public class MinDiffBTWHighAndLow {

    public static void main(String[] args) {
        MinDiffBTWHighAndLow obj =new MinDiffBTWHighAndLow();
        int [] arr = { 9,4,1,7};
        System.out.println(obj.minimumDifference(arr,2));
    }
    public int minimumDifference(int[] arr, int k) {
        Arrays.sort(arr);
        int res = 0;
        int sum = 0;
        for (int i = arr.length-1; i >= arr.length - k ; i--) {
            sum += arr[i];
        }
        res = sum ;
        for (int i = arr.length - k -1; i >=0; i--) {
            sum = sum + arr[i] - arr[i+k];
            res = Math.min(res,sum);
        }
        res = Math.min(res,sum);
        return res;
    }
}
