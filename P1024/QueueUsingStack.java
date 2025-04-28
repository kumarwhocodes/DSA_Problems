package P1024;

import java.util.Stack;

//Approach - 1 (for lesser push operations)

//public class P1910.QueueUsingStack {
//    Stack<Integer> s1 = new Stack<>();
//    Stack<Integer> s2 = new Stack<>();
//
//    public void push(int x) {
//        //s1->s2
//        while (!s1.empty()) {
//            s2.add(s1.peek());
//            s1.pop();
//        }
//        //x->s1
//        s1.add(x);
//        //s2->s1
//        while (!s2.empty()) {
//            s1.add(s2.peek());
//            s2.pop();
//        }
//        System.out.println(x + " pushed!");
//    }
//
//    public int pop() {
//        if (s1.empty()) {
//            System.out.println("Queue already empty!");
//            return -1;
//        }
//        int toBePopped = s1.peek();
//        s1.pop();
//        return toBePopped;
//    }
//
//    public int peek() {
//        if (s1.empty()) {
//            System.out.println("Queue already empty!");
//            return -1;
//        }
//        return s1.peek();
//    }
//
//    public int size() {
//        return s1.size();
//    }
//}

//Approach - 2 (for lesser pop and top operations)
public class QueueUsingStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int x) {
        s1.add(x);
        System.out.println(x + " pushed.");
    }

    public int pop() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.add(s1.peek());
                s1.pop();
            }
        }
        int toBePopped = s2.peek();
        s2.pop();
        return toBePopped;
    }

    public int peek() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.add(s1.peek());
                s1.pop();
            }
        }
        return s2.peek();
    }

    public int size() {
        return (s1.size() + s2.size());
    }
}
