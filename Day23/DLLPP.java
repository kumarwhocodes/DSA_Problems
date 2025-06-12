package Day23;

import Day7.Node;

public class DLLPP {
    
    public static void printDLL(Node head) {
        Node travNode = head;
        while (travNode != null) {
            System.out.print(travNode.data + " <-> ");
            travNode = travNode.next;
        }
        System.out.print("NULL\n");
    }
    
    public static Node insertNodeInDLL(Node head, int value, int index) {
        Node newNode = new Node(value);
        
        if (head == null) return newNode;   //Empty list case
        
        if (index == 0) {                   //Inserting at first case
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }
        
        Node curr = head;
        int count = 0;
        while (count < index - 1 && curr != null) {
            count++;
            curr = curr.next;
        }
        
        if (curr == null) return head;      //Index not present
        
        newNode.next = curr.next;
        if (curr.next != null) {            // If not inserting at the end
            curr.next.prev = newNode;
        }
        curr.next = newNode;
        newNode.prev = curr;
        return head;
    }
    
    public static Node deleteNodeInDLL(Node head, int index) {
        if (head == null) return null;      //empty list
        
        if (index == 0) {                   //deleting first node case
            return (head.next != null) ? head.next : null;
        }
        
        int count = 0;
        Node curr = head;
        while (curr != null && count < index - 1) {
            count++;
            curr = curr.next;
        }
        
        if (curr == null || curr.next == null) return head;      //Index not present
        
        Node nodeToDelete = curr.next;
        curr.next = nodeToDelete.next;
        if (nodeToDelete.next != null) {
            nodeToDelete.next.prev = curr;
        }
        return head;
    }
    
    public static Node reverseDLL(Node head) {
        if (head == null || head.next == null) return head;
        Node last = null;
        Node curr = head;
        while (curr != null) {
            last = curr.prev;
            curr.prev = curr.next;
            curr.next = last;
            
            curr = curr.prev;
        }
        return last.prev;
    }
    
    public static void main(String[] args) {
        Node head = null;
        head = insertNodeInDLL(head, 1, 0);
        head = insertNodeInDLL(head, 2, 1);
        head = insertNodeInDLL(head, 3, 2);
        head = insertNodeInDLL(head, 4, 3);
//        head = deleteNodeInDLL(head, 0);
        
        printDLL(head);
        head = reverseDLL(head);
        printDLL(head);
    }
    
}
