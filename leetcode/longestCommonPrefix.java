package leetcode;

public class longestCommonPrefix {
    public static void main(String[] args) {
        String [] arr = {"ab","a"};

        System.out.println(longestCommonPrefix(arr));
    }
    static String longestCommonPrefix(String[] arr) {
        int minLen = arr[0].length();
        for (String s : arr) {
            if (s.length() < minLen) {
                minLen = s.length();
            }
        }
        String str = "";
        int counter = 1;
        if(arr.length == 1 ){
            return arr[0];
        }
        for (int j = 0; j < minLen; j++) {
            for (int i = 0; i < arr.length - 1 ; i++) {
                if(! arr[i].substring(0,counter).equals( arr[i+1].substring(0,counter) ) ){
                    return str ;
                }
            }
            str = arr[0].substring(0,counter);
            counter++;
        }
        return str;
    }
}
