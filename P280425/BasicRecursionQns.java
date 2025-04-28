package P280425;

import P0624.P2706;

import java.util.Arrays;

public class BasicRecursionQns {
    
    private static void printName(String name, int times) {
        if (times <= 0) {
            return;
        }
        System.out.println(name);
        printName(name, times - 1);
    }
    
    private static void print1toN(int n, int start) {
        if (start > n) {
            return;
        }
        System.out.println(start);
        print1toN(n, start + 1);
    }
    
    private static void printNto1(int n) {
        if (n > 0) {
            System.out.println(n);
            printNto1(n - 1);
        }
    }
    
    private static int sum(int n) {
        if (n == 0) return 0;
        return n + sum(n - 1);
    }
    
    public static int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }
    
    public static void reverseArrayUsingRecursion(int[] arr) {
        System.out.println("Original Array: " + Arrays.toString(arr));
        reverseArrayHelper(arr, 0, arr.length - 1);
        System.out.println("Reversed Array: " + Arrays.toString(arr));
    }
    
    public static void reverseArrayHelper(int[] arr, int l, int r) {
        if (l >= r) return;
        P2706.swapInArray(arr, l, r);
        reverseArrayHelper(arr, l + 1, r - 1);
    }
    
    public static void main(String[] args) {
        printName("Sambhav", 5);
        print1toN(5, 1);
        printNto1(10);
        System.out.println(sum(5));
        System.out.println(factorial(8));
        int[] arr = {1, 2, 3, 4, 5, 6};
        reverseArrayUsingRecursion(arr);
    }
}
