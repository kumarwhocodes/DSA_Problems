import static java.lang.Math.pow;

public class P1410 {

    //Swap two numbers without third variable
    static void swapTwoNumberWithoutThirdVariable(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(
                "After swapping: \n" + "a: " + a + "\n" + "b: " + b
        );
    }

    //Decimal to Binary
//    static List<Integer> decimalToBinary(int num) {
//        List<Integer> list = new ArrayList<>();
//
//        while (num != 0) {
//            int lsb = num & 1;
//            list.add(lsb);
//            num = num >> 1;
//        }
//        return list.reversed();
//    }

    static int decimalToBinary(int num) {
        int binary = 0;
        int place = 1;

        while (num != 0) {
            int lsb = num & 1;
            binary += lsb * place;
            place *= 10;
            num = num >> 1;
        }

        return binary;
    }

    //Binary to Decimal Conversion
    static int binaryToDecimal(int num) {
        int ans = 0;
        int i = 0;

        while (num != 0) {
            int digit = num % 10;
            if (digit == 1) {
                ans = (int) (digit * pow(2, i)) + ans;
            }
            num = num / 10;
            i++;
        }
        return ans;
    }

    //check if the i'th bit is set
    static void checkIfIthBitIsSet(int num, int i) {
        if ((num >> i & 1) == 0) {
            System.out.println("The i'th bit is not set.");
        } else {
            System.out.println("The i'th bit is set.");
        }
    }

    //set the i'th bit
    static void setTheIthBit(int num, int i) {
        num = num | (1 << i);
        System.out.println(num);
    }

    //clear the i'th biy
    static void clearTheIthBit(int num, int i) {
        num = num & (~(1 << i));
        System.out.println(num);
    }

    //toggle the i'th bit
    static int toggleTheIthBit(int num, int i) {
        num = num ^ (1 << i);
        return num;
    }

    //remove the last set bit
    static void removeTheLastSetBit(int num) {
        num = num & (num - 1);
        System.out.println(num);
    }

    //check if the number is a power of 2
    static void checkIfTheNumIsAPowerOfTwo(int num) {
        if ((num & (num - 1)) == 0) {
            System.out.println("The number is a power of 2.");
        } else {
            System.out.println("Not a power of 2.");
        }
    }

    //count the number of set bits
    static void countTheNumberOfSetBit(int num) {
        int cnt = 0;
        while (num > 1) {
            int r = num % 2;
            if (r == 1) cnt++;
            num = num / 2;
        }
        if (num == 1) cnt++;
        System.out.println(cnt);
    }

    //count the number of set bits - preferred
    static int countTheNumberOfSetBitPreferred(int num) {
        int cnt = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                cnt++;
            }
            num = num >> 1;
        }
        return cnt;
    }

    //check if the number is odd or even
    static void checkOddOrEven(int num) {
        if ((num & 1) == 1) System.out.println("ODD");
        else System.out.println("EVEN");
    }

    //Divide two integers without using multiplication, division and mod operator
    static int divideWithoutMDM(int dividend, int divisor) {
        if (dividend == divisor) return 1;

        boolean sign = true;
        if (dividend < 0 && divisor > 0) sign = false;
        if (dividend >= 0 && divisor < 0) sign = false;

        long num = Math.abs(dividend);
        long denom = Math.abs(divisor);
        int ans = 0;

        while (num >= denom) {
            int count = 0;
            while (num >= (denom * pow(2, count + 1))) {
                count++;
            }
            ans = (int) (ans + (pow(2, count)));
            num = (int) (num - (denom * (pow(2, count))));
        }

        if (ans >= Math.pow(2, 31))
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        return sign ? ans : (-ans);
    }

    //Minimum Bit Flips to Convert Number
    static int minimumBitFlips(int start, int goal){
        int ans = start^goal;
        return countTheNumberOfSetBitPreferred(ans);
    }

    public static void main(String[] args) {
        int ans = minimumBitFlips(10, 7);
        System.out.println(ans);
    }
    

}
