package P010125;

import java.util.HashMap;

public class SlidingWindowAndTwoPointer2 {
    
    static int fruitsIntoBasket(int[] arr, int k) {
        int maxLen = 0, left = 0, right = 0;
        HashMap<Integer, Integer> fruitCount = new HashMap<>();
        
        while (right < arr.length) {
            fruitCount.put(arr[right], fruitCount.getOrDefault(arr[right], 0) + 1);
            if (fruitCount.size() > k) {
                while (fruitCount.size() > k) {
                    fruitCount.put(arr[left], fruitCount.getOrDefault(arr[left], 0) - 1);
                    if (fruitCount.get(arr[left]) == 0) {
                        fruitCount.remove(arr[left]);
                    }
                    left++;
                }
            }
            if (fruitCount.size() <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        
        return maxLen;
    }
    
    public static void main(String[] args) {
        int[] fruits = {1, 2, 1, 2, 3};
        System.out.println("Maximum fruits in baskets: " + fruitsIntoBasket(fruits, 2));
    }
}
