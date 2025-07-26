package Day24;

public class DP1 {
    
    //Memoization
    static int fiboM(int n, int[] arr) {
        if (n <= 1) return n;
        if (arr[n] != -1) return arr[n];
        return arr[n] = fiboM(n - 1, arr) + fiboM(n - 2, arr);
    }
    
    //Tabulation
    static int fiboT(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    
    //Space Optimization
    static int fiboS(int n) {
        int prev1 = 1;
        int prev2 = 0;
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    
    public static void main(String[] args) {
        int n = 5;
//        int[] arr = new int[n + 1];
//        Arrays.fill(arr, -1);
//        System.out.println(fiboM(n, arr));

//        System.out.println(fiboT(n));
        
        System.out.println(fiboS(n));
    }
    
}
