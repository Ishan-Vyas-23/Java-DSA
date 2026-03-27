package leetcode;

import java.util.Arrays;

public class BoatSavePeople {
    public static void main(String[] args) {
        int [] arr = {3,2,2,1};
        System.out.println(numRescueBoats(arr,3));
    }
    public static int numRescueBoats(int[] arr, int limit) {
        Arrays.sort(arr);
        int count = 0 ;
        int people = 0 ;
        int sum  = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(sum + arr[i] < limit && people < 2){
                if(people == 0){
                    count++;
                }
                sum = sum + arr[i];
                people++;
            }else{
                sum = 0 ;
                people = 0;
            }
        }
        return count;
    }
}
