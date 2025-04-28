package P0724;

import java.util.ArrayList;
import java.util.HashSet;

public class P3007 {
    
    // union of two arrays using hashset - O( (m+n)log(m+n) )
    static ArrayList<Integer> unionOfTwoArray(int[] arr1, int[] arr2) {
        HashSet<Integer> hash = new HashSet<>();
        ArrayList<Integer> union = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            hash.add(arr1[i]);
        }
        for (int j = 0; j < arr2.length; j++) {
            hash.add(arr2[j]);
        }
        for (int it : hash) {
            union.add(it);
        }
        return union;
    }
    
    // union of two sorted arrays - O ( m+n )
    static ArrayList<Integer> unionOfTwoArrayOpt(int[] a, int[] b) {
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                if (union.isEmpty() || union.getLast() != a[i])
                    union.add(a[i]);
                i++;
            } else {
                if (union.isEmpty() || union.getLast() != b[j])
                    union.add(b[j]);
                j++;
            }
        }
        while (i < a.length) {
            if (union.getLast() != a[i])
                union.add(a[i]);
            i++;
        }
        while (j < b.length) {
            if (union.getLast() != b[j])
                union.add(b[j]);
            j++;
        }
        return union;
        
    }
    
    // missing number in sorted array -- BRUTE
    static int findMissingNumberBrute(int[] arr) {
        int missing = -1;
        int index = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != index) {
                missing = index;
                break;
            }
            index++;
        }
        return missing;
    }
    
    // missing number in any array from 1 to N -- Optimal
    static int findMissingNumberOpt(int[] arr) {
        // sum of N natural numbers
        int N = arr.length + 1;
        int sumOfN = (N * (N + 1)) / 2;
        // sum of array
        int sumOfArray = 0;
        for (int i = 0; i < arr.length; i++) {
            sumOfArray += arr[i];
        }
        int missing = sumOfN - sumOfArray;
        return missing;
    }
    
    // count maximum number of 1's
    static int countMaximumConsecutiveOnes(int[] arr) {
        int count = 0;// changes after each iteration
        int max = 0;// to keep track of maximum
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            max = Math.max(max, count);
            i++;
        }
        return max;
    }
    
    // find the number that appears once and others numbers twice -- better -- O(n)
    // + O(n) + O(n)
    static int findUniqueNumberInArrayBetter(int[] arr) {
        // Find the maximum element:
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        // making frequency table
        int[] hash = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }
        // Find the single element and return the answer:
        for (int i = 0; i < arr.length; i++) {
            if (hash[arr[i]] == 1)
                return arr[i];
        }
        return -1;
    }
    
    // find the number that appears once and others numbers twice --Optimal -- O(N)
    
    /**
     * XOR of two same numbers is always 0 i.e. a ^ a = 0. ←Property 1.
     * XOR of a number with 0 will result in the number itself i.e. 0 ^ a = a.  ←Property 2
     */
    static int findUniqueNumberInArrayOpt(int[] arr) {
        int xor = 0;
        for (int j : arr) {
            xor ^= j;
        }
        return xor;
    }
    
    public static void main(String[] args) {
        int[] a = {1, 7, 0, 3, 1, 1, 1, 1, 0};
        int num = findUniqueNumberInArrayBetter(a);
        System.out.println(num);
    }
}
