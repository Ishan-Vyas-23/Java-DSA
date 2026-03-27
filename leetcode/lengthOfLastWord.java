package leetcode;

public class lengthOfLastWord {
    public static void main(String[] args) {
        String line = " a";
        System.out.println(lengthOfLastWord(line));
    }
    static int lengthOfLastWord(String s){
        int count = 0 ;
        for (int i = s.length() -1; i >=0 ; i--) {
            if(i == 0 && s.charAt(i) != ' '){
                return count + 1;
            }
            if(s.charAt(i) == ' ' && count!=0){
                return count;
            }
            if(s.charAt(i) != ' '){
                count++;
            };
        }
        return -1;
    }
}
