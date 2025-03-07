import java.util.Arrays;

public class BuyAndSellStock2 {
    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0) return 0;

        int[][] dp = new int[n+1][2];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        int maxProfit = 0;
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<=1; j++){
                if(j==0){
                    maxProfit = Math.max(0+dp[i+1][0], -prices[i]+dp[i+1][1]);
                }
                if(j==1){
                    maxProfit = Math.max(0+dp[i+1][1], prices[i]+dp[i+1][0]);
                }
                dp[i][j] = maxProfit;
            }
        }
        return dp[0][0];
    }
}
