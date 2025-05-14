package Day5;

public class P2408 {

    // Find the row with maximum number of 1's -- BRUTE
    static int findRowWithMaxOnes(int[][] arr, int n, int m) {
        int count = 0;
        int currentCount = 0;
        int rowIndex = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (arr[i][j] == 1) {
                    currentCount++;
                }
            }
            if (currentCount>count) {
                count = currentCount;
                rowIndex = i;
            }
        }
        return rowIndex;
    }

    //Find row with maximum number of 1's -- OPTIMAL
    public static int lowerBound(int[] arr, int n, int x) {
        //finding 1st occurrence of 1 in a row in this function
        int low = 0, high = n - 1;
        int ans = n;

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

    static int findRowWithMaxOnesOpt(int[][] arr,int rows,int columns){
        int count_max = 0;
        int index = -1;

        for(int i = 0;i<rows;i++){
            int ones = columns - lowerBound(arr[i], columns, 1);
            if(ones>count_max){
                count_max = ones;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 0, 0 }, { 1, 1, 1 }, { 0, 0, 0 } };
        System.out.println(findRowWithMaxOnesOpt(arr, 3, 3));
    }
}
