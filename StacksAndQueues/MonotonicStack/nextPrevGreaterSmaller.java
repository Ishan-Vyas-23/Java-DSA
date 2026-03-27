package StacksAndQueues.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class nextPrevGreaterSmaller {

    public static void main(String[] args) {
        int [] arr = {2,1,3,2,4,3};
        System.out.println("Array : "+ Arrays.toString(arr));
        System.out.println("Next Greater Array : "+Arrays.toString(nextGreater(arr)));
        System.out.println("Prev Greater Array : "+Arrays.toString(prevGreater(arr)));
        System.out.println("Prev Smaller Array : "+Arrays.toString(prevSmaller(arr)));
        System.out.println("Next Smaller Array : "+Arrays.toString(nextSmaller(arr)));
    }
    public static int[] nextGreater(int [] arr){
        int n = arr.length;
        int [] res = new int[n];
        int j = n-1 ;
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[j--] = -1;
            }else{
                res[j--] = arr[stack.peek()];
            }
            stack.push(i);
        }
        return res;
    }

    public static int[] prevGreater(int [] arr){
        int n = arr.length;
        int [] res = new int[n];
        int j = 0 ;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[j++] = -1;
            }else{
                res[j++] = arr[stack.peek()];
            }
            stack.push(i);
        }
        return res;
    }

    public static int[] prevSmaller(int [] arr){
        int n = arr.length;
        int [] res =  new int[n];
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < n ;i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[j++] = -1;
            }else{
                res[j++] = arr[stack.peek()];
            }
            stack.push(i);
        }
        return res;
    }
    public static int[] nextSmaller(int [] arr){
        int n = arr.length;
        int [] res = new int[n];
        int j = n -1 ;
        Stack<Integer> stack = new Stack<>();

        for(int i = n -1 ; i >= 0 ; i--){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[j--] = -1;
            }else{
                res[j--] = arr[stack.peek()];
            }
            stack.push(i);
        }

        return res;
    }
}
