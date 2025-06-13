package Day23;

import Day7.Node;

public class MediumDLLPP {
    
    public static Integer middleOfLinkedList(Node head) {
        if (head == null || head.next == null) {
            return (head != null) ? head.data : null;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
    
    public static boolean detectLoopInLL(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
    
    public static Integer findStartingElementOfTheLoopInLL(Node head) {
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
                return slow.data;
            }
        }
        return null;
    }
    
    public static Integer findLengthOfLoopInLL(Node head) {
        Node slow = head;
        Node fast = head;
        int count = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                do {
                    count++;
                    slow = slow.next;
                } while (slow != fast);
                return count;
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
//        Node head = null;
//        head = insertNodeInDLL(head, 1, 0);
//        head = insertNodeInDLL(head, 2, 1);
//        head = insertNodeInDLL(head, 3, 2);
//        head = insertNodeInDLL(head, 4, 3);
//        head = insertNodeInDLL(head, 5, 4);
//
//
//        printDLL(head);
//        System.out.println("Middle element: " + middleOfLinkedList(head));
//        System.out.println("Loop detected: " + detectLoopInLL(head));
        
        //Detect loop driver code
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = third;
        
        // Check if there is a loop
        // in the linked list
        if (detectLoopInLL(head)) {
            System.out.println("Loop detected in the linked list.");
            System.out.println("Loop started at: " + findStartingElementOfTheLoopInLL(head));
            System.out.println("Length of loop: " + findLengthOfLoopInLL(head));
        } else {
            System.out.println("No loop detected in the linked list.");
        }
        
        
    }
}
