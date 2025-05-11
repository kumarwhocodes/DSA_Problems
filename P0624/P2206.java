package P0624;

import java.util.Arrays;
import java.util.Collections;

public class P2206 {
    public static void main(String[] args) {
        print();
        System.out.println("-------------------");
        printName(1, 5);
        System.out.println("-------------------");
        printN(1, 10);
        System.out.println();
        System.out.println("-------------------");
        printReverseN(1, 10);
        System.out.println();
        System.out.println("-------------------");
        findSum(10, 0);
        System.out.println(findSumOpt(10));
        System.out.println("-------------------");
        factorial(5, 1);
        System.out.println("-------------------");
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        reverseArray(arr1);
        reverseArraySpaceOpt(arr1, 6);
        reverseArrayRecursive(arr1, 0, 5);
        printArray(arr1, 6);
        System.out.println();
        Integer[] arr2 = {6, 7, 8, 9, 10};
        reverseArrayInBuilt(arr2);
        System.out.println("-------------------");


    }

    //Understanding recursion
    static int count = 0;

    static void print() {
        if (count == 3) return;
        System.out.println(count);
        count++;
        print();
    }

    //printing name through recursion
    static void printName(int i, int n) {
        if (i > n) return;
        System.out.println("Printing name...");

        printName(i + 1, n);

    }

    //printing number from 1 to n
    static void printN(int i, int n) {
        if (i > n) return;
        else {
            System.out.print(i);
            printN(i + 1, n);
        }
    }

    //Printing N to 1
    static void printReverseN(int i, int n) {
        if (i > n) return;
        else {
            System.out.print(n);
            printReverseN(i, n - 1);
        }
    }

    //Finding sum - Brute Recursion
    static void findSum(int n, int sum) {
        if (n < 1) {
            System.out.println(sum);
            return;
        } else findSum(n - 1, sum + n);
    }

    //Finding sum - optimal
    static int findSumOpt(int n) {
        int sum = (n * (n + 1)) / 2;
        return sum;
    }

    //Factorial
    static void factorial(int n, int fact) {
        if (n < 1) {
            System.out.println(fact);
            return;
        } else {
            factorial(n - 1, fact * n);
        }
    }

    //Array Reverse-Brute
    static void reverseArray(int[] arr) {
        int[] reversedArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversedArray[i] = arr[arr.length - 1 - i];
        }
        System.out.println(Arrays.toString(reversedArray));
    }

    //Array Reverse-Space optimized
    //Function to print array
    static void printArray(int arr[], int n) {
        System.out.print("Reversed array is:- \n");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //Function to reverseStackUsingRecursion array
    static void reverseArraySpaceOpt(int arr[], int n) {
        int p1 = 0, p2 = n - 1;
        while (p1 < p2) {
            int tmp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = tmp;
            p1++;
            p2--;
        }
        printArray(arr, n);
    }

    //Function to reverseStackUsingRecursion array using recursion
    static void reverseArrayRecursive(int arr[], int start, int end) {
        if (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            reverseArrayRecursive(arr, start + 1, end - 1);
        }
    }

    //Inbuilt function to reverseStackUsingRecursion array
    static void reverseArrayInBuilt(Integer[] arr) {
        Collections.reverse(Arrays.asList(arr));
        System.out.println(Arrays.toString(arr));
    }

    

}
