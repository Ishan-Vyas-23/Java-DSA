package leetcode;

import java.util.Stack;

public class LongestValidParantheses {
    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(longestValidParentheses(s));
    }
    public static int longestValidParentheses(String s) {
        int count=0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else{
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                    count=count+2;
                }else{
                    stack.push(s.charAt(i));
                }
            }
        }
        return count;
    }
}
