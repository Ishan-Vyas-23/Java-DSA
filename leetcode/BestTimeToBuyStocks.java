package leetcode;

import java.util.ArrayList;

public class BestTimeToBuyStocks {
    public static void main(String[] args) {
        int [] prices = {7,6,4,3,1};
        System.out.println(maxProfitHard(prices));
    }
    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;

        for (int i = 0 ; i < prices.length ; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                if(prices[i] - min > max){
                    max = prices[i] - min;
                }
            }
        }

        return max;
    }

    public static int maxProfitHard(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++){
            list.add(arr[i]);
        }
        int min = list.get(0);
        int max = 0;
        int res = 0;
        for (int i = 0 ; i < list.size() - 1 ; i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            } else {
                if(list.get(i) - min > max){
                    max = list.get(i) - min;
                }
            }
        }
        res = res + max;
        list.remove(min);
        list.remove(Math.abs(max-min));
        min = list.get(0);
        max = 0 ;
        for (int i = 0 ; i < list.size() - 1 ; i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            } else {
                if(list.get(i) - min > max){
                    max = list.get(i) - min;
                }
            }
        }
        res = res + max ;

        return res;
    }
}
