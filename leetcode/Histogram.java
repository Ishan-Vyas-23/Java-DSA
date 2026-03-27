package leetcode;

public class Histogram {
    public static void main(String[] args) {
        int [] heights = {5,3,10,7,3,1};
        System.out.println(largestRectangleArea(heights));
    }
    public static int largestRectangleArea(int[] arr) {
        int max = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            int left = i ;
            int right = i ;
            while(left > 0 && arr[i] <= arr[left-1]){
                left--;
            }
            while(right + 1 < arr.length && arr[i] <= arr[right+1]){
                right++;
            }
            int area = arr[i] * (right - left + 1);
            max = Math.max(max,area);
        }
        return max;
    }
}
