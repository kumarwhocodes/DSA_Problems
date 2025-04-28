package P1224;

import java.util.Arrays;
import java.util.Stack;

public class NSE {
    
    static int[] nse(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] nse = new int[arr.length];
        
        for(int i = arr.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }
            
            if (stack.isEmpty())
                nse[i] = -1;
            else
                nse[i] = stack.peek();
            
            stack.push(arr[i]);
        }
        return nse;
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};
        arr = nse(arr);
        System.out.println(Arrays.toString(arr));
    }
    
}
