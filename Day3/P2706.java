package Day3;

import java.util.Arrays;

public class P2706 {
    public static void main(String[] args) {
        //Sorting methods
        int[] arr = {10, 9, 8, 7, 6};
        insertion(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    //1. Selection Sort
    static void selection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int max = getMaxInArray(arr, 0, last);
            swapInArray(arr, last, max);
        }
    }
    
    //function to swap elements in array
    public static void swapInArray(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    
    //function to find maximum array
    static int getMaxInArray(int[] arr, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }
    
    //2. Bubble Sort
    static void bubble(int[] arr) {
        //run the steps n-1 times as at last step it will be sorted
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - 1; j++) {
                if (arr[j] < arr[j - 1]) {
                    swapInArray(arr, arr[j], arr[j - 1]);
                }
            }
        }
    }
    
    //3. Insertion Sort
    static void insertion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swapInArray(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
    
    
}
