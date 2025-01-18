package P1910;

import java.util.Stack;

//Min Stack
//Formula for push: 2 * (value) - minimum
public class MinStack {
    Stack<Integer> st;
    int min;

    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (st.isEmpty()) {
            st.push(x);
            min = x;
            System.out.println(x + " pushed into Min Stack.");
            return;
        } else {
            if (x < min) {
                st.push((2 * x) - min);
                min = x;
            } else {
                st.push(x);
            }
        }
        System.out.println(x + " pushed into Min Stack.");
    }

    public void pop() {
        if (st.isEmpty()) {
            System.out.println("Stack already empty!");
            return;
        }
        int popped = st.pop();
        if (popped < min) min = ((2 * min) - popped);
        System.out.println(popped + " popped.");
    }

    public int top() {
        if (st.isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        int top = st.peek();
        return Math.max(top, min);
    }

    public int getMin() {
        if (st.isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return min;
    }
}
