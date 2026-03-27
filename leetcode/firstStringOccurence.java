package leetcode;

public class firstStringOccurence {
    public static void main(String[] args) {
        String haystack = "shaadimaisad" ;
        String needle = "sad" ;
        System.out.println(strToStr(haystack,needle));
    }
    static int strToStr(String haystack , String needle){
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if(haystack.substring(i,i + needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
