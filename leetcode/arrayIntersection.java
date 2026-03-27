package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class arrayIntersection {
    public static void main(String[] args) {
        int [] a = {1,1,1,1,1,1,2,2};
        int [] b ={1,1,1,2,3,4,4,5};
        System.out.println(Arrays.toString(intersection(a,b)));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0 , j = 0 ;
        ArrayList<Integer> list = new ArrayList<>();
        while(i < nums1.length && j < nums2.length){
            if (nums1[i] == nums2[j]) {
                if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
                    list.add(nums1[i]);
                }
                i++;
                j++;
            }
            else if (nums1[i]<nums2[j]) {
                i++;
            }else{
                j++;
            }
        }
        int [] arr = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            arr[k] = list.get(k);
        }
        return arr;
    }
}
