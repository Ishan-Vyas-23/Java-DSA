package leetcode;

public class binaryCount {
    public static void main(String[] args) {
        int [] arr = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
    public static int findMaxConsecutiveOnes(int[] arr) {
        int a = 0;
        int p = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 0  ){
                if(p>a){
                    a = p ;
                }
                p=0;
            }else{
                p++;
            }
        }
        if(p>a){
            a = p;
        }
        return a;
    }
}
