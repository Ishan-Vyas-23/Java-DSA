package StacksAndQueues.problems;

import java.util.Stack;

public class decodeString {

    public static void main(String[] args) {
        decodeString obj = new decodeString();
        StringBuilder sb = new StringBuilder();
    }

//https://leetcode.com/problems/decode-string/?envType=problem-list-v2&envId=stack
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(stack.isEmpty() || ch != ']' ){
                stack.push(ch);
            }else{
                StringBuilder temp = new StringBuilder();
                StringBuilder timesStr = new StringBuilder();
                char x = stack.pop();
                while(x != '['){
                    temp.insert(0,x);
                    x=stack.pop();
                }
                while(!stack.isEmpty() && stack.peek() - '0' <= 9){
                    timesStr.insert(0,stack.pop());
                }
                int times = Integer.parseInt(new String(timesStr));
                String str = new String(temp);
                for(int j= 0;j<times;j++){
                    for(int k = 0;k<str.length();k++){
                        stack.push(str.charAt(k));
                    }
                }
            }
        }
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        return new String(sb);
    }
}
