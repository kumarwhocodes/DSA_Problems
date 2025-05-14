package Day7;

import java.util.HashMap;
import java.util.HashSet;

public class P0310 {

    //Detect a loop in LL - Brute Force - O(N * 2 * LOG N)
    static boolean detectLoopBrute(Node head) {
        HashMap<Node, Integer> mpp = new HashMap<Node, Integer>();
        Node temp = head;
        while (temp != null) {
            if (mpp.containsKey(temp)) {
                return true;
            }
            mpp.put(temp, 1);
            temp = temp.next;
        }
        return false;
    }

    //Detect a loop in LL - Optimal - Tortoise & Hare method - O(N)
    static boolean detectLoopOpt(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            if (slow == fast) return true;
            else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return false;
    }

    //Starting point of loop in LL - Brute - O(N * 2 * LOG N)
    static Node findStartOfLoopBrute(Node head) {
        HashSet<Node> visited = new HashSet<>();
        Node temp = head;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            } else {
                visited.add(temp);
                temp = temp.next;
            }
        }
        return null;
    }

    //Starting point of loop in LL - Optimal - Tortoise & Hare - O( )
    static Node findStartOfLoopOpt(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = third;

        Node loopStart = findStartOfLoopOpt(head);
        if (loopStart != null) {
            System.out.println("Loop starts at node with value: " + loopStart.data);
        } else {
            System.out.println("No loop detected");
        }

//        if (detectLoopBrute(head)) {
//            System.out.println("Loop detected in the linked list.");
//        } else {
//            System.out.println("No loop detected in the linked list.");
//        }

    }
}
