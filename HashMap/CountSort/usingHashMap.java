package HashMap.CountSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class usingHashMap {
    public static void main(String[] args) {
        int [] arr = { -2,-2,-10,4,3,5,2,3,10,2,2,4};
        System.out.println("This is implemented via HashMap");
        System.out.println(Arrays.toString(arr));
        countSorter(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void countSorter(int [] arr){
        HashMap<Integer , Integer> freqMap = new HashMap<>();

        for(int elem : arr){
            freqMap.put(elem,freqMap.getOrDefault(elem,0)+1);
        }
        int k = 0;
        int smallest = Arrays.stream(arr).min().getAsInt();
        int greatest = Arrays.stream(arr).max().getAsInt()+1;
        for (int i = smallest; i < greatest; i++) {
            if (freqMap.containsKey(i)){
                int f = freqMap.get(i);
                while (f > 0){
                    arr[k] = i;
                    f--;
                    k++;
                }
            }
        }
    }

}
