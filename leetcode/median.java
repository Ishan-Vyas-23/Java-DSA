package leetcode;

public class median {
    public static void main(String[] args) {
        int [] arr1 = {1,2,3,4,5};
        int [] arr2 = {6,7,8,9,10,11,12,13,14,15,16,17};
        System.out.println(findMedianSortedArrays(arr1,arr2));
    }
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] newArr = merger(nums1 , nums2);

        int mid = newArr.length / 2 ;
        if(newArr.length%2 == 0 ){
            double num = (double)(newArr[mid - 1] + newArr[mid ]) / 2 ;
            return num ;
        }else{
            double num = newArr[mid] ;
            return (double) num ;
        }
    }
    static int[] merger(int [] arr1 , int [] arr2){
        int f = 0;
        int s = 0;
        int p = 0 ;
        int[] arr = new int[arr1.length + arr2.length ];
        while(arr1.length > f && arr2.length > s){
            if(arr1[f] >= arr2[s]){
                arr[p] = arr2[s];
                s++;
            }else{
                arr[p] = arr1[f];
                f++;
            }
            p++;
        }
        while(f < arr1.length){
            arr[p] = arr1[f];
            f++;
            p++;
        }
        while(s < arr2.length){
            arr[p] = arr2[s];
            s++;
            p++;
        }
        return arr;
    }
}



