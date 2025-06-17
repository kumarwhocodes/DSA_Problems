package Day23;

import Day7.Node;

import static Day23.DLLPP.insertNodeInDLL;
import static Day23.DLLPP.printDLL;

public class MediumLLPP {
    
    public static Node middleOfLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
    
    public static Node reverseSingleLL(Node head) {
        Node temp = head;
        Node prev = null;
        
        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    
    public static boolean isLinkedListAPalindrome(Node head) {
        Node first = head;
        Node middle = middleOfLinkedList(head);
        Node second = reverseSingleLL(middle);
        while (second != null) {
            if (first.data != second.data) {
                reverseSingleLL(second);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseSingleLL(head);
        return true;
    }
    
    public static void main(String[] args) {
        Node head = null;
        head = insertNodeInDLL(head, 1, 0);
        head = insertNodeInDLL(head, 2, 1);
        head = insertNodeInDLL(head, 3, 2);
        head = insertNodeInDLL(head, 3, 3);
        head = insertNodeInDLL(head, 2, 4);
        head = insertNodeInDLL(head, 1, 5);
        
        System.out.println("Original Linked List:");
        printDLL(head);
        
        System.out.println("Middle element: " + middleOfLinkedList(head).data);
        System.out.println("Loop detected: " + detectLoopInLL(head));
        System.out.println("Is Palindrome: " + isLinkedListAPalindrome(head));
        
        
        //Detect loop driver code
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
//        // Create a loop
//        fifth.next = third;
//
//        if (detectLoopInLL(head)) {
//            System.out.println("Loop detected in the linked list.");
//            System.out.println("Loop started at: " + findStartingElementOfTheLoopInLL(head));
//            System.out.println("Length of loop: " + findLengthOfLoopInLL(head));
//        } else {
//            System.out.println("No loop detected in the linked list.");
//        }
        
        
    }
}
