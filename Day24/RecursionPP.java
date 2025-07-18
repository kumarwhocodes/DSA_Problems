package Day24;

import java.util.Scanner;

public class RecursionPP {
    
    public static void main(String[] args) {
//        System.out.println(fibo(4));
//        int[] arr = {1, 2, 3, 4, 5, 6};
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println(findSecondLargest(arr));
    }
    
    private static int fibo(int n) {
        if (n < 2) return n;
        
        return fibo(n - 1) + fibo(n - 2);
    }
    
    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) return -1;
        
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        
        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num < first && num > second) {
                second = num;
            }
        }
        
        if (first == second)
            return -1;
        return second;
    }
    
}
