package P1224;

public class SlidingWindowAndTwoPointer1 {
    
    //max consecutive ones after flipping k-0s
    static int maxConsecutiveOnes(int[] arr, int k) {
        int maxLen = 0, left = 0, right = 0, zeros = 0;
        
        while (right < arr.length) {
            if (arr[right] == 0) zeros++;
            while (zeros > k) {
                if (arr[left] == 0) {
                    zeros--;
                }
                left++;
            }
            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);
            right++;
        }
        return maxLen;
    }
    
    
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int ans = maxConsecutiveOnes(a, 2);
        System.out.println(ans);
    }
    
}
