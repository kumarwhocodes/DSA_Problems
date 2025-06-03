package Day22;

import Day3.P2706;

import java.util.HashMap;
import java.util.List;

public class ArrayPractice {
    
    public static int longestSubarrayWithGivenSumBrute(int[] arr, int sum) {
        int maxL = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int s = 0;
                for (int k = i; k <= j; k++) {
                    s += arr[k];
                }
                
                if (s == sum)
                    maxL = Math.max(maxL, j - i + 1);
            }
        }
        return maxL;
    }
    
    public static int longestSubarrayWithGivenSumOpt(int[] arr, int sum) {
        int maxL = 0, currSum = 0;
        int i = 0, j = 0;
        while (j < arr.length) {
            currSum += arr[j];
            
            while (currSum > sum && i <= j) {
                currSum -= arr[i];
                i++;
            }
            
            if (currSum == sum) {
                maxL = Math.max(maxL, j - i + 1);
            }
            j++;
        }
        return maxL;
    }
    
    public static int[] sort012(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        
        while (mid <= high) {
            if (arr[mid] == 0) {
                P2706.swapInArray(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                P2706.swapInArray(arr, mid, high);
                high--;
            }
        }
        return arr;
    }
    
    public static int findMajorityElement(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int count = freq.getOrDefault(arr[i], 0) + 1;
            freq.put(arr[i], count);
            if (count > arr.length / 2) {
                return arr[i];
            }
        }
        return -1;
    }
    
    public static int maxSubarraySum(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            
            sum += arr[i];
            
            if (sum > max) {
                max = sum;
            }
            
            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }
        
        if (max < 0) max = 0;
        
        return max;
    }
    
    public static int stockBuyAndSellBrute(int[] stocks) {
        int maxProfit = 0;
        for (int i = 0; i < stocks.length; i++) {
            for (int j = i; j < stocks.length; j++) {
                if (stocks[j] > stocks[i]) {
                    int profit = stocks[j] - stocks[i];
                    if (profit > maxProfit) maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
    
    public static int stockBuyAndSellOpt(int[] stocks) {
        if (stocks == null || stocks.length == 0) return 0;
        
        int maxProfit = 0;
        int minPriceSoFar = Integer.MAX_VALUE;
        
        for (int price : stocks) {
            if (price < minPriceSoFar) minPriceSoFar = price;
            
            int currProfit = price - minPriceSoFar;
            maxProfit = Math.max(currProfit, maxProfit);
        }
        return maxProfit;
    }
    
    
    
    public static void main(String[] args) {
//        int[] a = {2, 3, 5, 1, 9};
//        int k = 10;
//        int len = longestSubarrayWithGivenSumOpt(a, k);
//        System.out.println("The length of the longest subarray is: " + len);

//        int[] a = {-1, 1, 1};
//        int k = 1;
//        int len = longestSubarrayWithGivenSumOpt(a, k);
//        System.out.println("The length of the longest subarray is: " + len);

//        int[] a = {2, 2, 1, 1, -2, 3, 2};
//        System.out.println(maxSubarraySum(a));
        
        int[] arr = {7, 1, 5, 3, 6, 4};
        int maxPro = stockBuyAndSellOpt(arr);
        System.out.println("Max profit is: " + maxPro);
    }
    
}
