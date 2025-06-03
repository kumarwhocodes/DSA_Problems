package Day5;

public class P0808 {
    
    // floor of a sqrt of a number using binary search
    static int floorSqrt(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid * mid <= num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
    
    // Nth root of a number
    static int nthRoot(int num, int n) {
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (Math.pow(mid, n) <= num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
    
    public static void main(String[] args) {
        System.out.println(nthRoot(27, 3));
    }
}