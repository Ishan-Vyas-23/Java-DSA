package leetcode;

public class ex {
    public static void main(String[] args) {
        int a = 5 ;
        System.out.println("From Main before func : " + a);
        System.out.println(" From func : " + func(a));
        System.out.println(" From Main after func : " + a);
    }
    static int func(int a ){
        a = a + 1 ;
        return a ;
    }
}

// Q) Output ?
// a) 5 5 6
// b) 5 6 5
// c) 5 6 6
// d) don't know
