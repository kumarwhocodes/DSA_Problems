package Day24;

import kotlin.Pair;

import java.util.*;

import static Day24.BitManipulatePP.countSetBitsOpt;

public class BitManipulatePP2 {
    
    public static int minimumBitFlips(int a, int b) {
        return countSetBitsOpt(a ^ b);
    }
    
    //Single Number - I
    //Every element is occuring 2 times, only 1 element is occuring 1 times
    public static int findNumberOccuringOddTimes(int[] arr) {
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }
        return xor == 0 ? -1 : xor;
    }
    
    //Single Number - II
    //Every element is occuring 3 times, only 1 element is occuring 1 times
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
    
    public static int singleNumberIIPattaSolution(int[] arr) {
        int totalSum = 0;
        int sum = 0;
        HashSet<Integer> map = new HashSet<>();
        for (int num : arr) {
            totalSum += num;
            boolean isUnique = map.add(num);
            if (isUnique) sum += num;
        }
        sum = sum * 3;  //assuming each number in the set is exactly 3 times, but one number is only 1 times
        int left = sum - totalSum;      //now that single number is left (but its thrice is left because we multiplied 3 earlier, not the number)
        return left / 2;        //finally single number taken out by dividing by 2, so the number is left only
    }
    
    //print all subsets - O(N * 2^N) - both tc and sc
    public static List<List<Integer>> powerSet(int[] arr) {
        List<List<Integer>> answer = new ArrayList<>();

//        int subsets = (int) Math.pow(2, arr.length);
        int subsets = 1 << arr.length;
        
        for (int i = 0; i < subsets; i++) {
            List<Integer> tempList = new ArrayList<>();
            
            for (int j = 0; j < arr.length; j++) {
                if ((i & (1 << j)) != 0) {         //check in loop if the j'th bit in i is set or not
                    tempList.add(arr[j]);
                }
            }
            
            answer.add(tempList);
        }
        return answer;
    }
    
    /*
     * XOR sum of 1 to n can be found in O(1) using n % 4:
     * rem = n % 4:
     *   0 -> n
     *   1 -> 1
     *   2 -> n + 1
     *   3 -> 0
     * Pattern: XOR of numbers up to multiple of 4 is that multiple (e.g., 1^2^3^4 = 4).
     */
    public static int xor1toN(int n) {
        return switch (n % 4) {
            case 0 -> n;
            case 1 -> 1;
            case 2 -> n + 1;
            default -> 0;
        };
    }
    
    //Single Number - III
    //Every element occuring 3 times, only 1 number occuring 2 times
    public static int singleNumberIIIBrute(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                return entry.getKey();
            }
        }
        
        return 0;
    }
    
    
    public static void main(String[] args) {
//        System.out.println(minimumBitFlips(10, 7));

//        System.out.println(findNumberOccuringOddTimes(new int[]{1, 0, 1, 0}));

//        System.out.println(singleNumberIIPattaSolution(new int[]{5, 5, 5, 3}));

//        System.out.println(powerSet(new int[]{1, 2, 3}));
        
        System.out.println(xor1toN(5));
    }
    
}
