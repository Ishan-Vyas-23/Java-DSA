package leetcode;

public class duplicateOfRange {
    public static void main(String[] args) {
        int [] arr = {1,3,4,2,1};
        System.out.println(findDuplicate(arr));
    }
    public static int findDuplicate(int[] nums) {
        for(int i = 0 ; i<nums.length;i++){
            if((upbinarySearch(nums,nums[i],i+1,nums.length)) != -1){
                return nums[upbinarySearch(nums,nums[i],i+1,nums.length)];
            }
        }
        return -1;
    }
    static int upbinarySearch(int[] arr, int target, int start, int end) {
        if (end >= start) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else {
                return target > arr[mid] ? upbinarySearch(arr, target, mid + 1, end) : upbinarySearch(arr, target, start, mid - 1);
            }
        } else {
            return -1;
        }
    }
}
