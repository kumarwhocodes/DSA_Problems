package Day22;

import Day3.P2706;

import java.util.Arrays;
import java.util.HashMap;

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
    
    //Search in 2-D Array
    public static boolean searchIn2DArray(int[][] arr, int rows, int cols, int key) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == key) return true;
            }
        }
        return false;
    }
    
    public static boolean searchInSorted2DArray(int[][] arr, int rows, int cols, int key) {
        int i = 0, j = cols - 1;                //keeping i at (0) and j at (last column)
        while (i < rows && j >= 0) {
            if (arr[i][j] == key) return true;
            else if (arr[i][j] > key) j--;     // move left
            else i++;                          // move down
        }
        return false;
    }
    
    public static int[] findPeakElementIn2DArray(int[][] arr, int m, int n) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = findRowWhichContainsMaxElement(arr, m, mid);
            int left = mid - 1 >= 0 ? arr[row][mid - 1] : -1;
            int right = mid + 1 < n ? arr[row][mid + 1] : -1;
            if (arr[row][mid] > left && arr[row][mid] > right) {
                return new int[]{row + 1, mid + 1};
            } else if (arr[row][mid] < left) high = mid - 1;
            else low = mid + 1;
        }
        return new int[]{-1, -1};
    }
    
    private static int findRowWhichContainsMaxElement(int[][] arr, int rows, int mid) {
        int max = Integer.MIN_VALUE;
        int rowIndex = -1;
        for (int i = 0; i < rows; i++) {
            if (arr[i][mid] > max) {
                max = arr[i][mid];
                rowIndex = i;
            }
        }
        return rowIndex;
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

//        int[] arr = {7, 1, 5, 3, 6, 4};
//        int maxPro = stockBuyAndSellOpt(arr);
//        System.out.println("Max profit is: " + maxPro);
        
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 11}
        };
//        System.out.println(searchInSorted2DArray(arr, 3, 3, 10));
        System.out.println("The peak element here is: " + Arrays.toString(findPeakElementIn2DArray(arr, 3, 3)));
    }
    
}
