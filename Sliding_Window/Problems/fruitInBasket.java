package Sliding_Window.Problems;

public class fruitInBasket {

//https://leetcode.com/problems/fruit-into-baskets/
    public int totalFruit(int[] arr) {
        int freq[] = new int[arr.length];
        int c = 0 ;
        int max = 0 ;
        int left = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            if(freq[arr[i]] == 0 ){
                c++;
            }
            freq[arr[i]]++;
            while(c > 2){
                freq[arr[left]]--;
                if(freq[arr[left]] == 0)c--;
                left++;
            }
            max = Math.max(i-left+1,max);
        }
        return max;
    }
}
