package Day8;

import java.util.Arrays;
import java.util.Stack;

public class NumberOfNgeToTheRight {
    
    static int[] numberOfNgeToTheRight(int[] arr) {
        int[] ngeToRight = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            ngeToRight[i] = stack.size();
            stack.push(arr[i]);
        }
        return ngeToRight;
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 4, 3};
        int[] result = numberOfNgeToTheRight(arr);
        
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Next Greater Elements Count: " + Arrays.toString(result));
    }
    
}
