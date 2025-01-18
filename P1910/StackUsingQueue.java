package P1910;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q = new LinkedList<>();

    void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }
    }

    int pop() {
        return q.remove();
    }

    int top() {
        if (q.peek()!=null)
            return q.peek();
        return -1;
    }

    int size() {
        return q.size();
    }
}
