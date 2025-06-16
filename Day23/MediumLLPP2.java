package Day23;

import Day7.Node;

import static Day23.DLLPP.printDLL;

public class MediumLLPP2 {
    
    public static Node segregateOddAndEvenNodesInLL(Node head) {
        Node evenHead = null, evenTail = null;
        Node oddHead = null, oddTail = null;
        Node curr = head;
        
        while (curr != null) {
            if (curr.data % 2 == 0) {
                if (evenHead == null) {
                    evenHead = evenTail = new Node(curr.data);
                } else {
                    evenTail.next = new Node(curr.data);
                    evenTail = evenTail.next;
                }
            } else {
                if (oddHead == null) {
                    oddHead = oddTail = new Node(curr.data);
                } else {
                    oddTail.next = new Node(curr.data);
                    oddTail = oddTail.next;
                }
            }
            curr = curr.next;
        }
        
        if (evenTail != null) {
            evenTail.next = oddHead;
            return evenHead;
        }
        return oddHead;
    }
    
    public static Node removeNthNodeFromBackInLL(Node head, int posFromBack) {
        if (head == null) return null;
        Node fast = head;
        for (int i = 0; i < posFromBack; i++) {
            fast = fast.next;
        }
        Node slow = head;
        if (fast == null) return head.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    
    public static Node deleteMiddleNodeInLL(Node head) {
        if (head == null || head.next == null) return null;
        Node fast = head.next.next;         //moving fast ahead two nodes for slow to reach one node before the middle
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);
        slow.next = slow.next.next;
        return head;
    }
    
    public static Node createLinkedList(int[] arr) {
        Node head = null, tail = null;
        for (int num : arr) {
            if (head == null) {
                head = tail = new Node(num);
            } else {
                tail.next = new Node(num);
                tail = tail.next;
            }
        }
        return head;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node head = createLinkedList(arr);
        System.out.println("Original Linked List:");
        printDLL(head);

//        Node segregatedHead = segregateOddAndEvenNodesInLL(head);
//        System.out.println("Segregated Linked List (Even followed by Odd):");
//        printDLL(segregatedHead);

//        head = removeNthNodeFromBackInLL(head, 7);
//        printDLL(head);

        head = deleteMiddleNodeInLL(head);
        printDLL(head);
    
    
    }
    
}
