package Day5;

public class P0308 {
    
    // Search element in a rotated sorted array
    public static int searchInRotatedSortedArray(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            // if mid-points to the target
            if (arr[mid] == num)
                return mid;
            
            // if left part is sorted
            if (arr[start] <= arr[mid]) {
                if (arr[start] <= num && num <= arr[mid]) {
                    // element exists
                    end = mid - 1;
                } else {
                    // element does not exist
                    start = mid + 1;
                }
            } else { // if right part is sorted
                if (arr[mid] <= num && num <= arr[end]) {
                    // element exists
                    start = mid + 1;
                } else {
                    // element does not exist
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
    
    // search element in rotated sorted array with edge case arr[mid] = arr[low] =
    // arr[high]
    public static boolean searchInRotatedSortedArrayEdged(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (arr[mid] == num)
                return true;
            
            if (arr[mid] == arr[start] && arr[start] == arr[end]) {
                start++;
                end--;
                continue;
            }
            
            if (arr[start] <= arr[mid]) { // left part is sorted
                if (arr[start] <= num && num <= arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { // right part is sorted
                if (arr[mid] <= num && num <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
    
    // find minimum -- PATTA???
    public static int findMin(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (arr[low] <= arr[high]) {
                ans = Math.min(ans, arr[low]);
                break;
            }
            
            if (arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
    
    
    //how many number of times the array has been rotated
    
    /**
     * agr smallest element nikaal lenge toh pta chl jaega ki kitna aage bdha h wo
     */
    public static int findKRotation(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                break;
            }
            
            if (arr[low] <= arr[mid]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                low = mid + 1;
            } else {
                if (arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                }
                high = mid - 1;
            }
        }
        return index;
    }
    
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 0, 1, 2, 3, 4};
        System.out.println(findKRotation(arr));
    }
}
