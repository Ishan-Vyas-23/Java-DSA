package leetcode;

import java.util.Arrays;

public class removeElement27 {
    public static void main(String[] args) {
        int [] arr = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(arr,2));
        System.out.println(Arrays.toString(arr));
    }
    public static int removeElement(int[] arr, int val) {
        Arrays.sort(arr);
        int k = 0 ;
        for(int i = 0 ; i < arr.length  ; i++){
            if(arr[i] == val){
                int index = i + 1;
                while(arr[index] == val){
                    index++;
                }
                    int temp = arr[i];
                    arr[i] = arr[index];
                    arr[index] = temp;
            }else{
                k++;
            }
        }
        return k;
    }
}
