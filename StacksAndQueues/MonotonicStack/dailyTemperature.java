package StacksAndQueues.MonotonicStack;

public class dailyTemperature {

//https://leetcode.com/problems/daily-temperatures/
    public int[] dailyTemperatures(int[] arr) {
        int len =  arr.length;
        int[] stack = new int[len];
        int top = -1;
        int[] res = new int[len];
        int j = len-1 ;
        for(int i = len-1 ; i>=0 ; i--){
            while(top != -1 && arr[stack[top]] <= arr[i]){
                top--;
            }
            if(top == -1){
                res[j--] = 0;
            }else{
                res[j--] = stack[top]-i;
            }
            stack[++top] = i;
        }
        return res;
    }
}
