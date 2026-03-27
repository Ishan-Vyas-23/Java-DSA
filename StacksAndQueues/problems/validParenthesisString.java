package StacksAndQueues.problems;

import java.util.Stack;

public class validParenthesisString {
    public static void main(String[] args) {
        validParenthesisString obj = new validParenthesisString();
        System.out.println(obj.checkValidString("(*))"));
    }
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for(int i = 0 ; i < s.length() ;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open.push(i);
            }else if(ch == '*'){
                star.push(i);
            }else{
                if(!open.isEmpty()){
                    open.pop();
                }else if(!star.isEmpty()){
                    star.pop();
                }else{
                    return false;
                }
            }
        }
        while(!open.isEmpty() && !star.isEmpty()){
            if(star.peek() > open.peek()){
                star.pop();
                open.pop();
            }else{
                break;
            }

        }
        return open.isEmpty();
    }
}
