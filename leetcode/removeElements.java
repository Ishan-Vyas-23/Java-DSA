package leetcode;

import java.util.Arrays;

public class removeElements {
    public static void main(String[] args) {
        int[] arr={0,1,2,2,3,0,4,2};
        System.out.println(removeElement(arr,2));
    }
    public static int removeElement(int[] arr, int val) {
        int k = 0;
        for(int i = 0 ; i< arr.length ;i++)
            if(arr[i] != val)
                arr[k++] = arr[i];
        return k;
    }
}
