package P1024;

import java.util.Stack;

public class P1910 {

    //Balanced Parentheses
    static boolean checkForBalancedParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for (char i : s.toCharArray()) {
            if (i == '(' || i == '[' || i == '{') {
                st.push(i);
            } else {
                if (st.empty()) return false;       //No matching opening bracket
                char ch = st.pop();
                if ((ch == '(' && i == ')') || (ch == '[' && i == ']') || (ch == '{' && i == '}')) continue;
                else return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
//        P1910.StackUsingQueue s = new P1910.StackUsingQueue();
//        s.push(3);
//        s.push(2);
//        s.push(4);
//        s.push(1);
//        System.out.println("Top of the stack: " + s.top());
//        System.out.println("Size of the stack before removing element: " + s.size());
//        System.out.println("The deleted element is: " + s.pop());
//        System.out.println("Top of the stack after removing element: " + s.top());
//        System.out.println("Size of the stack after removing element: " + s.size());

//        QueueUsingStack q = new QueueUsingStack();
//        q.push(3);
//        q.push(4);
//        System.out.println("The element popped is " + q.pop());
//        q.push(5);
//        System.out.println("The top element is " + q.peek());
//        System.out.println("The size of the queue is " + q.size());
//
//        String s = "()[{}()]";
//        System.out.println(checkForBalancedParentheses(s));

        MinStack s = new MinStack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("Top of the stack: " + s.top());
        System.out.println("Min element: " + s.getMin());
        s.pop();
        System.out.println("Top of the stack after removing element: " + s.top());
        System.out.println("Min element: " + s.getMin());

    }
}
