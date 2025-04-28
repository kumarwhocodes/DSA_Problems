package P0824;

public class P0208 {

    // Search Insert Position
    public static int searchInsert(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;
        int ans = arr.length;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    // ceil of array
    public static int findCeil(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;
        int ceil = num;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= num) {
                ceil = arr[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ceil;
    }

    // floor of array
    public static int findFloor(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;
        int floor = num;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= num) {
                floor = arr[mid];
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return floor;
    }

    public static int solve(int n, int key, int[] v) {
        int start = 0;
        int end = n - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (v[mid] == key) {
                res = mid;
                start = mid + 1;

            } else if (key < v[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    //count occurence in sorted array - hashing
    public static int countOccurenceBrute(int[] arr, int num){
        int[] hash = new int[arr.length+1];
        for(int i=0;i<arr.length;i++){
            hash[arr[i]]++;
        }
        try {
            int ans = hash[num];
            return ans;
        } catch (Exception e) {
            return 0;
        }
       
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 4, 4, 4, 5, 6 };
        System.out.println(countOccurenceBrute(arr, 7));

    }
}
