package leetcode;

import java.util.*;

public class generateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(n,n,"",list);
        return list;
    }
    public void helper(int o , int c ,String res , List<String> list){
        if(c == 0){
            list.add(new String(res));
            return;
        }
        if(o > 0)helper(o-1,c,res + '(' ,list);
        if(o < c)helper(o,c-1,res + ')' ,list);
    }
}
