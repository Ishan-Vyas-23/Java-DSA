package StacksAndQueues.problems;

import java.util.Arrays;
import java.util.Stack;

public class stockSpan {
    public static void main(String[] args) {
        int []arr= {100, 80, 60, 70, 60, 75, 85};
        System.out.println(Arrays.toString(stockSpanFinder(arr)));
    }
    public static int[] stockSpanFinder(int [] arr){
        int[] spanArr = new int[arr.length];
        int j = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length ; i++){
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                spanArr[j++] = i+1;
            }else{
                spanArr[j++] = i - stack.peek();
            }
            stack.push(i);
        }
        return spanArr;
    }
}
