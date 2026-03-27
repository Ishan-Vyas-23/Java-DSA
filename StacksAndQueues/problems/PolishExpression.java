package StacksAndQueues.problems;

import java.util.Stack;

public class PolishExpression {

    public static void main(String[] args) {
        PolishExpression obj = new PolishExpression();
        String [] arr = {"4","13","5","/","+"};
        System.out.println(obj.evalRPN(arr));
    }

//https://leetcode.com/problems/evaluate-reverse-polish-notation/description/?envType=problem-list-v2&envId=stack
    public int evalRPN(String[] arr) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i< arr.length ;i++){
            if(arr[i].equals("+")){
                int b =stack.pop();
                int a = stack.pop();
                stack.push(a+b);
            }else if(arr[i].equals("-")){
                int b =stack.pop();
                int a = stack.pop();
                stack.push(a-b);
            }else if(arr[i].equals("*")){
                int b =stack.pop();
                int a = stack.pop();
                stack.push(a*b);
            }else if(arr[i].equals("/")){
                int b =stack.pop();
                int a = stack.pop();
                stack.push(a/b);
            }else{
                int x = Integer.parseInt(arr[i]);
                stack.push(x);
            }
        }
        return stack.pop();
    }
}
