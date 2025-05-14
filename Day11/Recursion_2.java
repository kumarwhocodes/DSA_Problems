package Day11;

import java.util.Stack;

public class Recursion_2 {
    
    private static final int MOD = 1_000_000_007;
    
    /**
     * Count Good Number using Binary Exponentiation
     * | T = O(log N)
     */
    public static int countGoodNumbers(long n) {
        long evenPositions = n / 2;
        long oddPositions = n - evenPositions;
        
        long pow4 = binaryExponentiation(4, evenPositions);
        long pow5 = binaryExponentiation(5, oddPositions);
        
        return (int) ((pow4 * pow5) % MOD);
    }
    
    private static long binaryExponentiation(long a, long b) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {                 // if b is odd
                result = (result * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return result;
    }
    
    public static void reverseStackUsingRecursion(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        
        int top = stack.pop();
        reverseStackUsingRecursion(stack);
        insertAtBottom(stack, top);
    }
    
    private static void insertAtBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }
        
        int top = stack.pop();
        insertAtBottom(stack, value);
        stack.push(top);
    }
    
    public static boolean checkPalindromeStringUsingRecursion(String str) {
        str = str.trim();
        return palindromeStringCheckHelper(str, 0, str.length() - 1);
    }
    
    private static boolean palindromeStringCheckHelper(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return palindromeStringCheckHelper(str, start + 1, end - 1);
    }
    
    
    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);

//        System.out.println(countGoodNumbers(5));
//
//        System.out.println("Original Stack: " + stack);
//        reverseStackUsingRecursion(stack);
//        System.out.println("Reversed Stack: " + stack);
        
        System.out.println(checkPalindromeStringUsingRecursion("MADAM"));
    }
    
}
