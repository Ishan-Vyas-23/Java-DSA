package LinkedList.problems;

public class happyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
    static boolean isHappy(int n ){
        int slow = n ;
        int fast = n ;
        do{
            slow = sqaureOf(slow);
            fast = sqaureOf(sqaureOf(fast));
        }while (fast != slow);
        if(slow == 1 ){
            return true;
        }
        return false ;
    }
    private static int sqaureOf(int num ){
        int sum = 0 ;
        while(num != 0 ){
            sum = sum + ((num%10)*(num%10));
            num = num /10 ;
        }
        return sum ;
    }
}
