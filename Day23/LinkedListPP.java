package Day23;

import Day7.Node;

public class LinkedListPP {
    
    public static void printSingleLL(Node head) {
        Node travNode = head;
        while (travNode != null) {
            System.out.print(travNode.data + "  ->  ");
            travNode = travNode.next;
        }
        System.out.print("NULL\n");
    }
    
    public static Node insertNodeInSingleLL(Node head, int value, int index) {
        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            return newNode;
        }
        
        Node curr = head;
        int count = 0;
        while (curr != null && count < index - 1) {
            count++;
            curr = curr.next;
        }
        
        if (curr == null) return head; //if index not present
        
        newNode.next = curr.next;
        curr.next = newNode;
        
        return head;
    }
    
    public static Node deleteNodeInSingleLL(Node head, int index) {
        if (head == null) return null;      // Handle empty list
        if (index < 0) return head;         // Handle invalid index (assuming 0-based indexing)
        if (index == 0) return head.next;   // Handle deletion of first node (index 0)
        
        Node curr = head;
        int count = 0;
        
        while (count < index - 1 && curr != null) {
            curr = curr.next;
            count++;
        }
        
        if (curr == null || curr.next == null) {    // Check if index is out of bounds
            return head;
        }
        
        curr.next = curr.next.next;
        return head;
    }
    
    public static int findLengthOfSingleLL(Node head) {
        Node curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
    
    public static int searchElementInSingleLL(Node head, int key) {
        if (head == null) return -1;
        Node curr = head;
        int index = 0;          //0-based indexing
        while (curr != null) {
            if (curr.data == key) {
                return index;
            } else {
                curr = curr.next;
                index++;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Node head = null;
        head = insertNodeInSingleLL(head, 1, 0);
        head = insertNodeInSingleLL(head, 2, 1);
        head = insertNodeInSingleLL(head, 3, 2);
        head = insertNodeInSingleLL(head, 4, 3);
        head = deleteNodeInSingleLL(head, 5);
        
        printSingleLL(head);
        System.out.println("Length of Single LL: " + findLengthOfSingleLL(head));
        System.out.println("Key Found at index: " + searchElementInSingleLL(head, 5));
    }
    
}
