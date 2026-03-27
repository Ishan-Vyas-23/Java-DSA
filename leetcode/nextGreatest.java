package leetcode;

public class nextGreatest {

    public static void main(String[] args) {
        nextGreatest obj = new nextGreatest();
        char[] array = {'c','f','j'};
        char target = 'g';
        System.out.println(obj.nextGreatestLetter(array,target));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        char res = letters[0];
        int start = 0 ;
        int end = letters.length -1;
        while(end >= start){
            int mid = start + (end-start)/2;
            if(letters[mid] > target){
                res = letters[mid];
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return res;
    }
}
