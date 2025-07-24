package Day24;

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
    
    public static void main(String[] args) {
//        System.out.println(minimumBitFlips(10, 7));
        
        System.out.println(findNumberOccuringOddTimes(new int[]{1,0,1,0}));
    }
    
}
