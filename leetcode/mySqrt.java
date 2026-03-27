package leetcode;

public class mySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
    static int mySqrt(int num){
         return (int)Math.floor(Math.sqrt(num));
    }
}
