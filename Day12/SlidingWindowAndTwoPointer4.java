package Day12;

public class SlidingWindowAndTwoPointer4 {
    
    static int maxPointsObtainedFromCards(int[] arr, int k) {
        if (k == 0) return 0;
        
        int n = arr.length;
        int lSum = 0;  // Sum of left `k` elements
        int rSum = 0;  // Sum of right elements as we slide
        int maxSum = 0;
        
        // Step 1: Compute initial sum from first `k` elements
        for (int i = 0; i < k; i++) {
            lSum += arr[i];
        }
        
        maxSum = lSum;
        
        // Step 2: Slide window from the end
        int rIndex = n - 1;
        for (int i = k - 1; i >= 0; i--) {
            lSum -= arr[i];  // Remove one element from left
            rSum += arr[rIndex];  // Add one element from right
            rIndex--;
            
            maxSum = Math.max(maxSum, lSum + rSum);
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 1}; // Example input
        int k = 3;
        System.out.println("Maximum points obtained: " + maxPointsObtainedFromCards(arr, k));
    }
}
