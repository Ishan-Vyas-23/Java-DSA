package StacksAndQueues.problems;

public class minInsertions {

//https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/description/?envType=problem-list-v2&envId=stack
    public int minInsertions(String s) {
        int open = 0 ;
        int close = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                open++;
            }else{
                if(i+1 < s.length() && s.charAt(i+1) == ')' ){
                    i++;
                }else{
                    close++;
                }
                if(open > 0 ){
                    open--;
                }else{
                    close++;
                }
            }
        }
        if(open > 0 ){
            close = close + (open*2);
        }
        return close;
    }
}
