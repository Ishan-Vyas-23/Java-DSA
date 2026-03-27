package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Asteroid {
    public static void main(String[] args) {
        int []  nums =  {-4, 3, 2, -5} ;
        System.out.println(Arrays.toString(asteroidCollision(nums)));
    }
    public static int[] asteroidCollision(int[] arr) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i<arr.length ; i++){
            if(s.isEmpty()){
                s.push(arr[i]);
            }else if(arr[i]*s.peek() > 0){
                s.push(arr[i]);
            }else{
                if(s.peek() > 0 ) {
                    while (!s.isEmpty() && Math.abs(arr[i]) != Math.abs(s.peek()) && s.peek() > 0 && Math.abs(arr[i]) > Math.abs(s.peek())) {
                        s.pop();
                    }
                    if (s.isEmpty()) {
                        s.push(arr[i]);
                    }
                    else if (s.peek() > 0 && Math.abs(arr[i]) == Math.abs(s.peek())) {
                        s.pop();
                    }
                    else if(s.peek() < 0 ){
                        s.push(arr[i]);
                    }
                }else{
                    s.push(arr[i]);
                }
            }
        }
        int [] nums = new int[s.size()];
        for(int i = 0 ; i < nums.length ; i++){
            nums[i] = s.get(i) ;
        }
        return nums;
    }
}