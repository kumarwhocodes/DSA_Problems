package P0824;

public class P0708 {

    // search single element in a sorted array
    static int searchSingleElementInSortedArray(int[] arr) {
        if (arr.length == 1)
            return arr[0];
        if (arr[0] != arr[1])
            return arr[0];
        if (arr[arr.length - 1] != arr[arr.length - 2])
            return arr[arr.length - 1];

        int low = 1, high = arr.length - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }

            if (((mid % 2 == 1) && (arr[mid] == arr[mid - 1])) || ((mid % 2 == 0) && (arr[mid] == arr[mid + 1]))) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Peak element of an array
    static int findPeakElement(int[] arr) {
        int n=arr.length;

        // Edge cases:
        if (n == 1) return arr[0];
        if (arr[0] > arr[1]) return arr[0];
        if (arr[n-1] > arr[n-2]) return arr[n - 1];

        int low = 1;
        int high = n-2;
        while (low<=high) {
            int mid = (low+high)/2;
            //mid
            if ((arr[mid]>arr[mid-1]) && (arr[mid]>arr[mid+1]))
                return arr[mid];
            //for left
            if (arr[mid] > arr[mid-1]) low = mid + 1;
            //for right
            else high = mid-1;
            
        }
        return -1;

    }

    

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(findPeakElement(arr));
    }
}
