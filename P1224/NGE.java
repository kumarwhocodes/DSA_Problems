package P1224;

import java.util.Stack;

public class NGE {
    
    static int[] nextGreaterElement(int[] arr) {
        int[] nge = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = stack.peek();
            }
            
            stack.push(arr[i]);
        }
        return nge;
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 2, 6, 0};
        int[] nge = nextGreaterElement(arr);
        for (int j : nge) {
            System.out.print(j + " ");
        }
    }
}
