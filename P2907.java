import java.util.ArrayList;
import java.util.Arrays;

public class P2907 {

    // remove duplicates from sorted array
    static ArrayList<Integer> removeDuplicatesFromSortedArray(int[] arr) {
        ArrayList<Integer> fresh = new ArrayList<>();
        if (arr.length == 0)
            return fresh;

        fresh.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                fresh.add(arr[i]);
            }
        }
        return fresh;
    }

    // move all zero to end -- BRUTE
    static int[] moveZeroToEndBrute(int[] arr) {
        int count = 0;
        int j = 0;
        int ans[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count=count+1;
            } else {
                ans[j] = arr[i];
                j++;
            }
        }

        while (j < arr.length) {
            arr[j] = 0;
            j++;
        }
        return ans;
    }

    // move zeroes to end -- Optimal
    static int[] moveZeroesToEndOpt(int[] arr) {
        int j = -1;
        // finding first zero element
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1)
            return arr;
        else {
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i] != 0) {
                    swap(arr,i,j);
                    j++;
                }
            }
            return arr;
        }

    }

    public static void swap(int[] arr, int i, int j) {
        P2707.swap(arr, i, j);
    }

    //linear search
    static int searchIndex(int[] arr, int key){
        int index = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                index = i+1;
                break;
            }
        }
        return index;
    }

    

    public static void main(String[] args) {
        int[] arr = { 1, 0, 5, 3, 6, 0, 0, 0, 9, 7, 6 };
//        int[] arr1 = moveZeroToEndBrute(arr);
        System.out.println(searchIndex(arr, 1));
    }
}
