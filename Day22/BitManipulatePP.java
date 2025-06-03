package Day22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BitManipulatePP {
    
    public static int singleNumber(int[] arr) {
        int xor = 0;
        for (int num : arr) {
            xor = xor ^ num;
        }
        return xor;
    }
    
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (int num : nums) {
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                List<Integer> subset = new ArrayList<>(subsets.get(i));
                subset.add(num);
                subsets.add(subset);
            }
        }
        return subsets;
    }
    
    public static int findRangeXORBrute(int l, int r) {
        int xor = 0;
        if (l > r) return xor;
        for (int i = l; i <= r; i++) {
            xor ^= i;
        }
        return xor;
    }
    
    public static int findRangeXOROpt(int l, int r) {
        return xorUpto(r) ^ xorUpto(l - 1);
    }
    
    private static int xorUpto(int num) {
        if (num < 0) return 0;
        int mod = num % 4;
        if (mod == 0) return num;
        if (mod == 1) return 1;
        if (mod == 2) return num + 1;
        return 0;
    }
    
    public static List<Integer> findNumAppearingOddTimes(int[] nums) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        System.out.println(singleNumber(nums));

//        System.out.println(subsets(nums));

//        System.out.println("XOR using brute force method: " + findRangeXORBrute(3, 5));
//        System.out.println("XOR using optimal method: " + findRangeXOROpt(3, 5));
        
        System.out.println(findNumAppearingOddTimes(new int[]{ 3, 4, 3, 2, 4, 4}));
    }
    
}
