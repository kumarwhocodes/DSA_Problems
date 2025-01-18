import java.util.HashMap;

public class P0410 {

    //Length of loop in LL - Brute - TC = O(N) - SC = O(N)
    static Integer findLengthOfLoopBrute(Node head) {
        HashMap<Node, Integer> mpp = new HashMap<>();
        Node temp = head;
        int timer = 0;
        while (temp != null) {
            if (mpp.containsKey(temp)) {
                int startingIndex = mpp.get(temp);
                return (timer - startingIndex);
            }
            mpp.put(temp, timer);
            temp = temp.next;
            timer++;
        }
        return 0;
    }

    //Length of Loop in LL - Optimal - Tortoise & Hare - TC = O(N) - SC = O(1)
    static Integer findLengthOfLoopOpt(Node head) {
        Node slow = head;
        Node fast = head;
        int count = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                do {
                    count++;
                    fast = fast.next;
                } while (fast != slow);
                return count;
            }
        }
        return 0;
    }

    //Detect a Palindrome in LL - Brute -- O(N^2)
    static boolean checkPalindromeLLBrute(Node head) {
        if (head == null) {
            return true;
        }
        Node start = head;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node end = temp;
        while (start.prev != end && start != end) {
            if (start.data != end.data) {
                return false;
            } else {
                start = start.next;
                end = end.prev;
            }
        }
        return true;
    }

    //Detect a Palindrome in LL - Optimal -- O(N)
    static boolean checkPalindromeLLOpt(Node head) {
        if (head == null || head.next == null) return true;
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node newHead = P0210.reverseIterativeLL(slow.next);
        Node first = head;
        Node second = newHead;
        while (second != null) {
            if (first.data != second.data) {
                P0210.reverseIterativeLL(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        P0210.reverseIterativeLL(newHead);
        return true;
    }

    

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);

        if (checkPalindromeLLOpt(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }

//        Node head = new Node(1);
//        Node second = new Node(2);
//        Node third = new Node(3);
//        Node fourth = new Node(4);
//        Node fifth = new Node(5);
//
//        head.next = second;
//        second.next = third;
//        third.next = fourth;
//        fourth.next = fifth;
//
//        fifth.next = second;
//
//        int loopLength = findLengthOfLoopOpt(head);
//
//        if (loopLength > 0) {
//            System.out.println("Length of the loop: " + loopLength);
//        } else {
//            System.out.println("No loop found in the linked list.");
//        }
    }

}
