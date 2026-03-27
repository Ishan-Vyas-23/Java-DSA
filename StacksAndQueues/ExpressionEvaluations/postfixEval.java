package StacksAndQueues.ExpressionEvaluations;

import java.util.Stack;

public class postfixEval {
    public int evaluatePostfix(String[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            String elem = arr[i];
            if(elem.isEmpty()) continue;
            if(elem.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(elem.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }else if(elem.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(elem.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(Math.floorDiv(b, a));
            }else if(elem.equals("^")){
                int a = stack.pop();
                int b = stack.pop();
                int num = 1;
                while(a > 0){
                    num *= b;
                    a--;
                }
                stack.push(num);
            }else{
                stack.push(Integer.parseInt(elem));
            }
        }
        return stack.peek();
    }
}
