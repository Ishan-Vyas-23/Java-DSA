package leetcode;

public class palindrome {
    public static void main(String[] args) {
        int num = -121;
        System.out.println(num);
        System.out.println(isPalindrome(num));
    }
    static boolean isPalindrome(int num){
        String number = "" + num ;
        for (int i = 0; i < number.length(); i++) {
            if( number.charAt(i) != number.charAt(number.length() - i -1)){
                return false ;
            }
        }
        return true;
    }
}
