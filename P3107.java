public class P3107 {

    //Binary Search recursive approach
    static int binarySearchRecursive(int[] arr, int start, int end, int key) {
        if (start > end) return -1;

        int mid = (start + end) / 2;
        if (arr[mid] == key) return mid + 1;
        else if (key > arr[mid]) return binarySearchRecursive(arr, mid + 1, end, key);
        return binarySearchRecursive(arr, start, mid - 1, key);
    }

    /**
     * The lower bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than or equal to a given key i.e. x
     */
    static int findLowerBoundBrute(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= x) return i;
        }
        return arr.length;
    }

    static int findLowerBoundOpt(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    /**
     * The upper bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than the given key i.e. x.
     */
    static int findUpperBoundOpt(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(findUpperBoundOpt(arr, 7));
    }
}
