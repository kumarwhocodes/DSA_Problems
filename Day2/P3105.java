package Day2;

public class P3105 {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
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

    //Binary to Decimal Conversion
//    static int binaryToDecimal(int num) {
//        int ans = 0;
//        int i = 0;
//
//        while (num != 0) {
//            int digit = num % 10;
//            if (digit == 1) {
//                ans = (int) (digit * Math.pow(2, i)) + ans;
//            }
//            num = num / 10;
//            i++;
//        }
//        return ans;
//    }

    //Reversing the integer
    static int reverse(int x) {
        int ans = 0;

        while (x != 0) {
            int digit = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            ans = (ans * 10) + digit;
            x = x / 10;

        }
        return ans;


    }

}
