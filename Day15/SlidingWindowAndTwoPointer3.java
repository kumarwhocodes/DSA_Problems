package Day15;

public class SlidingWindowAndTwoPointer3 {
    
    static int binarySubArraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    
    static int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;
        int left = 0, sum = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            count = count + (right - left + 1);
        }
        return count;
    }
    
    
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        System.out.println(binarySubArraysWithSum(nums, 2));
    }
    
}
