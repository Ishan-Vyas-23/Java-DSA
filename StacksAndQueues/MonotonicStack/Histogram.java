package StacksAndQueues.MonotonicStack;

public class Histogram {

//https://leetcode.com/problems/largest-rectangle-in-histogram/

    // brute force but still o(4n) time
    public int largestRectangleArea(int[] arr) {
        int len = arr.length;
        int[] prevSmall = prevSmallElement(arr,len);
        int[] nextSmall = nextSmallElement(arr,len);
        int max = 0;
        for(int i = 0 ; i < len ; i++){
            int area = arr[i]*(nextSmall[i]-prevSmall[i]-1);
            if(area > max){
                max = area;
            }
        }
        return max;
    }
    public int[] prevSmallElement(int [] arr , int len){
        int res[] = new int[len];
        int stack[] = new int[len];
        int top = -1;
        int j = 0 ;
        for(int i = 0 ; i < len ; i++){
            while(top != -1 && arr[stack[top]] >= arr[i]){
                top--;
            }
            if(top == -1){
                res[j++] = -1;
            }else{
                res[j++] = stack[top];
            }
            stack[++top] = i ;
        }
        return res;
    }
    public int[] nextSmallElement(int [] arr , int len){
        int res[] = new int[len];
        int stack[] = new int[len];
        int top = -1;
        int j = len-1 ;
        for(int i = len-1 ; i >= 0 ; i--){
            while(top != -1 && arr[stack[top]] >= arr[i]){
                top--;
            }
            if(top == -1){
                res[j--] = len;
            }else{
                res[j--] = stack[top];
            }
            stack[++top] = i ;
        }
        return res;
    }
}
