package P1712;

import java.util.Stack;

public class NGE2 {
    
    private static int[] nge2(int[] nge) {
        int[] nge2 = new int[nge.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 2 * nge.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nge[i % nge.length]) {
                stack.pop();
            }
            if (i < nge.length) {
                nge2[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nge[i % nge.length]);
        }
        return nge2;
    }
    
}
