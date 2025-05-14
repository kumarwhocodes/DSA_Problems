package Day3;

import java.util.ArrayList;
import java.util.List;

public class P2106 {
    public static void main(String[] args) {

        System.out.println(countDigitsOpt(367));

        System.out.println("-------------------------");

        System.out.println(reverse(6973873));

        System.out.println("-------------------------");

        System.out.println(isPalindrome(101));

        System.out.println("-------------------------");

        System.out.println(gcdBrute(15, 30));
        System.out.println(gcdAnother(15, 30));
        System.out.println(gcdOpt(15, 30));

        System.out.println("-------------------------");

        System.out.println(isArmstrong(153));

        System.out.println("-------------------------");

        System.out.println(printAllDivisors(6));

        System.out.println("--------------------------");

        System.out.println(isPrime(5));

        System.out.println("--------------------------");
    }

    // count digits brute force
    static int countDigits(int num) {
        int count = 0;
        while (num != 0) {
            num = num / 10;
            count++;
        }
        return count;
    }

    // count digits optimal approach
    //drawback - returns garbage value in case of zero
    static int countDigitsOpt(int num) {
        int count = (int) (Math.log10(num) + 1);
        return count;
    }

    //reverseStackUsingRecursion digits - the optimal way
    static int reverse(int num) {
        int reversedNum = 0;
        while (num != 0) {
            int lsb = num % 10;
            reversedNum = reversedNum * 10 + lsb;
            num = num / 10;
        }
        return reversedNum;
    }

    //check for palindrome
    static boolean isPalindrome(int num) {
        if (reverse(num) == num) {
            return true;
        }
        return false;
    }

    //GCD brute force
    static int gcdBrute(int num1, int num2) {
        int gcd = 1;
        for (int i = 1; i <= Math.min(num1, num2); i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    //GCD another approach
    static int gcdAnother(int num1, int num2) {
        int gcd = 1;
        for (int i = Math.min(num1, num2); i > 0; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }

    //GCD Optimal Approach
    static int gcdOpt(int num1, int num2) {
        while (num1 > 0 && num2 > 0) {
            if (num1 > num2) {
                num1 = num1 % num2;
            } else {
                num2 = num2 % num1;
            }
        }

        if (num1 == 0) {
            return num2;
        }
        return num1;
    }

    //Armstrong - the optimal approach
    static boolean isArmstrong(int num) {
        int originalNum = num;
        int sum = 0;
        while (num != 0) {
            int lsb = num % 10;
            sum += (int) Math.pow(lsb, 3);
            num = num / 10;
        }
        if (sum == originalNum) {
            return true;
        }
        return false;
    }

    //Print all divisors
    static List<Integer> printAllDivisors(int n) {
        List <Integer> divisors = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(n%i==0){
                divisors.add(i);
            }
        }
        return divisors;
    }

    //check for prime
    static boolean isPrime(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                count++;
            }
        }
        if (count==2){
            return true;
        }
        return false;
    }
}
