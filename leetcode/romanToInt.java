package leetcode;

public class romanToInt {
    public static void main(String[] args) {
        String roman = "MMMMMCXLII";
        System.out.println(romanToIntConverter(roman));
    }
    static int romanToIntConverter(String roman){
        int num = 0 ;
        for (int i = roman.length() - 1; i >= 0; i--) {

            if(i == 0){
                num = num + valueOf(roman.charAt(i));
                return num ;
            }
            if(valueOf(roman.charAt(i)) <= valueOf(roman.charAt(i-1)) ){
                num = num + valueOf(roman.charAt(i));
            }else{
                num = num + valueOf(roman.charAt(i)) - valueOf(roman.charAt(i-1));
                i--;
            }
        }
        return num;
    }
    static int valueOf(Character a){
        if(a == 'I'){
            return 1;
        }
        else if(a == 'V'){
            return 5;
        }
        else if (a == 'X'){
            return 10;
        }
        else if (a == 'L') {
            return 50;
        }
        else if(a == 'C'){
            return 100;
        }
        else if(a == 'D'){
            return 500;
        }
        else if(a == 'M'){
            return 1000;
        }
        return 0;
    }
}
