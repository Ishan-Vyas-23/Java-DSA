package BinarySearch.Problems;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class Problems {

    public static void main(String[] args) {
        int [] arr = {7,2,5,10,8};
    }

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    public int[] searchRange(int[] arr, int target) {
    int s = 0 ;
    int e = arr.length - 1 ;
    int [] res = {-1,-1};

    // finding the start
    while(s <= e){
        int mid = s + (e-s)/2 ;
        if(arr[mid] == target){
            res[0] = mid;
            e = mid -1 ;
        }else if(arr[mid] < target){
            s = mid +1;
        }else{
            e = mid -1 ;
        }
    }

    // finding the end
    s= 0 ;
    e= arr.length-1;
    while(s <= e){
        int mid = s + (e-s)/2 ;
        if(arr[mid] == target){
            res[1] = mid;
            s = mid +1 ;
        }else if(arr[mid] < target){
            s = mid +1;
        }else{
            e = mid -1 ;
        }
    }
    return res;
}

//https://leetcode.com/problems/find-peak-element/description/
//https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
    public static int peakIndexInMountainArray(int[] arr) {
        int s = 0 ;
        int e = arr.length -1 ;
        while(e >= s){
            int mid = s  + (e-s)/2;
            if(s == e){
                return mid ;
            }
            if(arr[mid]  > arr[mid+1]){
                e = mid ;
            }else{
                s = mid +1;
            }
        }
        return -1;
    }

//https://leetcode.com/problems/find-in-mountain-array/
    public static int findInMountainArray(int target, int[] arr) {
        int peak = findPeak(arr);
        int a = binarySearchOrderWise(arr,target,0,peak);
        if(a != -1){
            return a;
        }
        return binarySearchOrderWise(arr,target,peak,arr.length-1);
    }
    public static int findPeak(int[] arr){
        int s = 0 ;
        int e =  arr.length - 1;

        while(e >= s){
            int mid = s + (e-s)/2;
            if(e == s){
                return mid ;
            }
            if(arr[mid] > arr[mid+1]){
                e = mid ;
            }else{
                s = mid+1;
            }
        }
        return -1 ;
    }
    public static int binarySearchOrderWise(int [] arr , int target , int s , int e){
        if(arr[s] < arr[e]){
            while(e >= s){
                int mid = s + (e-s)/2;
                if(target == arr[mid]){
                    return mid ;
                }
                if(arr[mid] > target){
                    e = mid-1 ;
                }else{
                    s = mid+1;
                }
            }
        }else{
            while(e >= s){
                int mid = s + (e-s)/2;
                if(target == arr[mid]){
                    return mid ;
                }
                if(arr[mid] < target){
                    e = mid-1 ;
                }else{
                    s = mid+1;
                }
            }
        }

        return -1 ;
    }

//https://leetcode.com/problems/search-in-rotated-sorted-array/description/
    public static int rotatedArraySearch(int[] arr, int target) {
        int pivot = findPivot(arr);
        if(pivot == -1){
            return binarySearch(arr,0,arr.length-1,target);
        }
        int res = binarySearch(arr,0,pivot,target);
        if(res != -1){
            return res;
        }
        return binarySearch(arr,pivot+1,arr.length-1,target);
    }
    public static int findPivot(int [] arr){
        int s = 0 ;
        int e = arr.length - 1;

        while(e >= s){
            int mid = s + (e-s)/2;
            if(mid  <e &&arr[mid] > arr[mid+1]){
                return mid ;
            }else if(mid >s && arr[mid] < arr[mid-1]){
                return mid -1;
            }else if(arr[mid] < arr[s]){
                e = mid -1 ;
            }else{
                s = mid +1;
            }
        }
        return -1;
    }
    public static int binarySearch(int [] arr , int s , int e , int target ){
        while(e>=s){
            int mid = s + (e-s)/2;
            if(target == arr[mid]){
                return mid ;
            }else if(arr[mid] >  target){
                e = mid -1;
            }else{
                s =mid +1;
            }
        }
        return -1 ;
    }

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    public int findMin(int[] arr) {
        int pivot = findPivot(arr);
        return arr[pivot+1];
    }

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
    public static int findMinII(int[] arr) {
        int pivot = findPivotII(arr);
        return arr[pivot+1];
    }
    public static int findPivotII(int [] arr){
        int s = 0 ;
        int e = arr.length - 1;

        while(e >= s){
            int mid = s + (e-s)/2;
            if(mid  <e &&arr[mid] > arr[mid+1]){
                return mid ;
            }else if(mid >s && arr[mid] < arr[mid-1]){
                return mid -1;
            }else if(arr[mid] == arr[s] && arr[mid] == arr[e]){
                e--;
            }else if(arr[mid] < arr[s]){
                e = mid -1 ;
            }else{
                s = mid +1;
            }
        }
        return -1;
    }

//https://leetcode.com/problems/koko-eating-bananas/description/
    public int minEatingSpeed(int[] arr, int h) {
        int maxK = max(arr);
        int s = 1 ;
        int e = maxK;
        while(e >= s){
            int mid = s + (e-s)/2;
            if(isValidK(arr,h,mid)){
                e = mid -1;
            }else{
                s = mid +1;
            }
        }
        return s;
    }
    public boolean isValidK(int [] arr , int h , int k){
        long count = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(count > h){
                return false;
            }
            count += (arr[i] + k - 1) / k ;
        }
        if(count <= h){
            return true ;
        }
        return false;
    }
    public int max(int [] arr ){
        int max = arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }

//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
    public static int shipWithinDays(int[] arr, int days) {
        int s = Arrays.stream(arr).max().getAsInt();
        int e = Arrays.stream(arr).sum();
        while(s < e){
            int mid = s + (e-s)/2;
            if(isValidWt(arr,days,mid)){
                e = mid;
            }else{
                s = mid+1;
            }
        }
        return s;
    }
    public static boolean isValidWt(int [] arr , int days , int k  ){
        int count = 1 ;
        int sum = 0 ;
        for(int elem : arr){
            if(sum + elem > k){
                count++;
                sum = 0;
            }
            sum+=elem;
        }
        return count  <= days;
    }

//https://leetcode.com/problems/split-array-largest-sum/
    public static int splitArray(int[] arr, int k) {
        int s = Arrays.stream(arr).max().getAsInt();
        int e = Arrays.stream(arr).sum();
        while(e > s){
            int mid = s + (e-s)/2 ;
            int count = 1 ;
            int sum = 0 ;
            for(int elem : arr){
                if(sum + elem > mid){
                    count++;
                    sum = 0;
                }
                if (count > k) break;
                sum+=elem;
            }
            if(count > k ){
                s = mid +1;
            }else{
                e = mid ;
            }
        }
        return s;
    }

//
}

