package BinarySearch;

public class binarySearcher {

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,8,9,21,23,45,67,89,455};

        System.out.println(chunkBinarySearch(arr,9));
    }

    public static int binarySearch(int [] arr , int target){
        int s = 0 ;
        int e = arr.length - 1 ;
        while(s <= e){
            int mid = s + (e-s)/2 ;
            if(arr[mid] == target){
                return mid ;
            }else if(arr[mid] < target){
                s = mid +1;
            }else{
                e = mid -1 ;
            }
        }
        return -1;
    }

    public static int binarySearch(int [] arr , int target , int start , int end){
        int s = start ;
        int e = end ;
        while(s <= e){
            int mid = s + (e-s)/2 ;
            if(arr[mid] == target){
                return mid ;
            }else if(arr[mid] < target){
                s = mid +1;
            }else{
                e = mid -1 ;
            }
        }
        return -1;
    }

    public static int chunkBinarySearch(int [] arr, int target){
        int s= 0 ;
        int e = 1 ;

        while(target > arr[e]){
            int newStart = e +1 ;
            int newEnd = e + (e-s)*2 ;
            s = newStart ;
            e = newEnd ;
        }
        return binarySearch(arr,target,s,e);

    }
}
