package Dynamic_Programming.Questions;

public class costToClimb {
    public static void main(String[] args) {
        costToClimb obj = new costToClimb();
        int [] arr = {5,15,20};
        System.out.println(obj.minCostClimbingStairsDP(arr));
    }

    //brute-force  
    int cost = Integer.MAX_VALUE ;
    public int minCostClimbingStairs(int[] arr) {
        helper(arr, 0 ,0);
        helper(arr, 1 ,0);
        return cost;
    }
    public void helper(int [] arr , int index , int sum){

        if(index >= arr.length ){
            cost = Math.min(cost, sum);
            return;
        }
        helper(arr,index+1 ,sum + arr[index]);
        helper(arr,index+2, sum + arr[index]);
    }

    // DP
    public int minCostClimbingStairsDP(int[] arr) {
        int n = arr.length ;
        int a = arr[n -1 ];
        int b  = arr[n -2];
        for(int i = n-3 ; i >= 0 ; i--){
            int temp = b ;
            b = arr[i] + Math.min(b,a);
            a= temp;
        }

        //this is the choice between starting from stair 0 or stair 1
        return Math.min(a,b);
    }


}
