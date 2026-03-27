package leetcode;

import java.util.Arrays;

public class plusOneArrayInt {
    public static void main(String[] args) {
        int [] arr = {9,8,7,6,5,4,3,2,1,0};
        System.out.println(arrayToNum(arr));
        System.out.println(Arrays.toString(plusOne(arr)));
    }
    static long[] plusOne(int [] digits){
        return numToArray(arrayToNum(digits)+1);
    }
    static long arrayToNum(int [] arr){
        long sum = 0 ;
        long mult = 1 ;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum = sum + (arr[i]*mult) ;
            mult=mult*10;
        }
        return sum;
    }
    static long[] numToArray(long num){
        int digits =  (int) Math.floor(Math.log10(Math.abs(num))) + 1;
        long [] array = new long[digits];
        for (int i = digits - 1 ; i >= 0; i--) {
            array[i] = num%10;
            num = num/10;
        }
        return array;
    }
}
