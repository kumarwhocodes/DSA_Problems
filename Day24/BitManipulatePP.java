package Day24;

public class BitManipulatePP {
    
    public static void swapTwoNums(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("A: " + a);
        System.out.println("B: " + b);
    }
    
    public static boolean checkIthBitIsSet(int n, int i) {
        //using left shift operator
//        if ((n & (1 << i)) != 0) return true;
//        return false;
        
        //using right shift operator
        if (((n >> i) & 1) != 0) return true;
        return false;
    }
    
    public static int setIthBit(int n, int i) {
        return (n | (1 << i));
    }
    
    public static int clearIthBit(int n, int i) {
        return (n & (~(1 << i)));
    }
    
    public static int toggleIthBit(int n, int i) {
        return (n ^ (1 << i));
    }
    
    public static int clearRightMostSetBit(int n) {
        return n & n - 1;
    }
    
    public static boolean isPowerOf2(int n) {
        if ((n & (n - 1)) == 0) return true;
        return false;
    }
    
    public static int countSetBits(int n) {
        int cnt = 0;
        while (n > 1) {
            int rem = n % 2;
            n = n / 2;
            if (rem == 1) cnt++;
        }
        if (n == 1) cnt++;
        return cnt;
    }
    
    public static int countSetBitsOpt(int n) {
        int cnt = 0;
        while (n != 0) {
            n = n & n - 1;
            cnt++;
        }
        return cnt;
    }
    
    public static void isOddOrEven(int n) {
        if ((n & 1) == 1) System.out.println("Odd");
        else System.out.println("Even");
    }
    
    public static void main(String[] args) {
//        swapTwoNums(2, 3);

//        System.out.println(checkIthBitIsSet(13, 2));

//        System.out.println(setIthBit(9, 2));

//        System.out.println(clearIthBit(13, 2));

//        System.out.println(toggleIthBit(13, 1));

//        System.out.println(clearRightMostSetBit(16));

//        System.out.println(isPowerOf2(15));

//        System.out.println(countSetBits(13));

//        System.out.println(countSetBitsOpt(13));
        
        isOddOrEven(11);
    }
    
}
