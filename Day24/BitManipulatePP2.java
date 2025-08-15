package Day24;

import java.util.Arrays;

import static Day24.BitManipulatePP.countSetBitsOpt;

public class BitManipulatePP2 {
    
    public static int minimumBitFlips(int a, int b) {
        return countSetBitsOpt(a ^ b);
    }
    
    public static int findNumberOccuringOddTimes(int[] arr) {
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }
        return xor == 0 ? -1 : xor;
    }
    
    public static int singleNumberIIBrute(int[] arr) {
        //1. Using Hashmap
        //2. Using count variable and counting 32 bits if not divisible by 3
        //3. Sort and then find (current)
        Arrays.sort(arr);
        if (arr.length == 1) return arr[0];
        for (int i = 1; i < arr.length; i = i + 3) {
            if (arr[i] != arr[i - 1]) return arr[i - 1];
        }
        return arr[arr.length - 1];         //return last element at last because if the last is single, the loop won't check it
    }
    
    public static int singleNumberIIBAAP(int[] arr) {
        int ones = 0;
        int twos = 0;
        for (int i = 0; i < arr.length; i++) {
            ones = (ones ^ arr[i]) & ~twos;
            twos = (twos ^ arr[i]) & ~ones;
        }
        return ones;
    }
    
    public static void main(String[] args) {
//        System.out.println(minimumBitFlips(10, 7));

//        System.out.println(findNumberOccuringOddTimes(new int[]{1, 0, 1, 0}));
        
        System.out.println(singleNumberIIBAAP(new int[]{5, 5, 5, 3}));
    }
    
}
