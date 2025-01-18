import java.util.Arrays;

public class P2707 {
    public static void main(String[] args) {
        int[] arr = { 55, 66, 33, 11, 77 };
        rotateRight(arr, 3);
        System.out.println(Arrays.toString(arr));
        findSecondLargest(arr, 5);
        findSecondLargest(arr, 5);
    }

    // find largest element in array
    static int findLargestInArray(int[] arr) {
        if (arr.length > 0) {
            int largest = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > largest) {
                    largest = arr[i];
                }
            }
            return largest;
        } else
            return -1;
    }

    // second largest element without sorting -- optimal
    @SuppressWarnings("unused")
    static private int findSecondSmallest(int[] arr, int n) {
        if (n < 2) {
            return -1;
        }
        int small = Integer.MAX_VALUE;
        int second_small = Integer.MAX_VALUE;
        int i;
        for (i = 0; i < n; i++) {
            if (arr[i] < small) {
                second_small = small;
                small = arr[i];
            } else if (arr[i] < second_small && arr[i] != small) {
                second_small = arr[i];
            }
        }
        return second_small;
    }

    static private int findSecondLargest(int[] arr, int n) {
        if (n < 2)
            return -1;
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;
        int i;
        for (i = 0; i < n; i++) {
            if (arr[i] > large) {
                second_large = large;
                large = arr[i];
            }

            else if (arr[i] > second_large && arr[i] != large) {
                second_large = arr[i];
            }
        }
        return second_large;
    }

    // check if the array is sorted
    static boolean checkArraySort(int[] arr) {
        boolean isArraySorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isArraySorted = false;
            }
        }
        return isArraySorted;
    }

    // rotate array to left by one
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void rotateLeftOne(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            swap(arr, i, i - 1);
        }
    }

    // rotate right by n elements - PATTA???
    static void rotateRight(int[] arr, int n) {
        for (int i = arr.length ; i > n  ; i--) {
            swap(arr, i, i - 1);
        }
    }

}