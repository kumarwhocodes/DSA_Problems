package Day5;

import Day7.Node;

public class P3008 {

    //Delete last node of doubly linked list
    static Node deleteLastInDoublyLL(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    //Delete any node of Doubly Linked List (1-indexed)
    static Node deleteAnyNodeInDLL(Node head, int index) {
        if (head == null || index <= 0) {
            return head; // Invalid index or empty list
        }

        // If the node to be deleted is the head node
        if (index == 1) {
            if (head.next != null) {
                head = head.next;
                head.prev = null;
            } else {
                head = null; // This was the only node
            }
            return head;
        }

        int count = 1;
        Node curr = head;
        while (count < index - 1 && curr != null) {
            count++;
            curr = curr.next;
        }
        if (curr == null) { // If the node to be deleted is beyond the length of the list
            return head;
        }
        if(curr.next.next == null){
            curr.next = null;
        }
        else {
            curr.next.next.prev = curr;
            curr.next = curr.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = null;

        head = P2808.insertAnywhere(head, 0, 1);
        head = P2808.insertAnywhere(head, 1, 2);
        head = P2808.insertAnywhere(head, 2, 3);
        head = P2808.insertAnywhere(head, 3, 4);

        P2808.printLL(head);

        head = deleteAnyNodeInDLL(head, 4);
        P2808.printLL(head);


    }
}
