package Day5;

public class P1108 {

    //KOKO eating Bananas
    static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j >= max) {
                max = j;
            }
        }
        return max;
    }

    static int calculateHours(int[] arr, int h){
        int hours=0;
        for(int i: arr){
            int curr = Math.ceilDiv(i,h);
            hours+=curr;
        }
        return hours;
    }

    static int kokoEatingBananas(int[] arr, int h){
        int low = 0;
        int high = findMax(arr);
        int ans = 0;
        while (low<high){
            int mid = (low+high)/2;
            int calculatedHours = calculateHours(arr,mid);
            System.out.println("CALCULATED: " + calculatedHours);
            if(calculatedHours<=h){
                ans = calculatedHours;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr={7,15,16,3};
        System.out.println(kokoEatingBananas(arr, 8));
    }
}
