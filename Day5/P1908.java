package Day5;

import java.util.Arrays;
import java.util.HashMap;

public class P1908 {

    // 2Sum Problem -- BRUTE
    static boolean checkTwoSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // 2Sum Problem -- OPTIMAL
    static String checkTwoSumOpt(int[] arr, int target) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int moreNeeded = target - num;
            if (mpp.containsKey(moreNeeded)) {
                return "true";
            }
            mpp.put(arr[i], i);
        }
        return "false";
    }

    // minimum days to make 'm' bouquets with 'k' adjacent bloomed flowers
    // function to find if it is possible to make bouquet with that day
    static boolean possible(int[] arr, int day, int m, int k) {
        int count = 0;
        int numOfBouq = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) {
                count++;
            } else {
                numOfBouq += (count / k);
                count = 0;
            }
        }
        numOfBouq += (count / k);
        if (numOfBouq >= m) {
            return true;
        } else {
            return false;
        }
    }

    static int findMinimumDays(int[] arr, int m, int k) {
        long val = (long) m * k;
        if (val > arr.length) return -1; // Impossible case.
        
        int high = Arrays.stream(arr).max().getAsInt();
        int low = Arrays.stream(arr).min().getAsInt();
        int ans = 0;
        while (low < high) {
            int mid = (low + high) / 2;
            if (possible(arr, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 3, 10, 2 };
        System.out.println(findMinimumDays(arr, 3, 2));

    }
}
