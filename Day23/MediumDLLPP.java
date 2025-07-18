package Day23;

import Day7.Node;
import Day7.NodePair;

import java.util.HashMap;

import static Day23.DLLPP.printDLL;

public class MediumDLLPP {
    
    public static Node createDoublyLinkedList(int[] arr) {
        Node head = null, tail = null;
        for (int num : arr) {
            Node newNode = new Node(num);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }
        return head;
    }
    
    public static Node deleteKeyOccurrencesInDLL(Node head, int key) {
        Node temp = head;
        
        while (temp != null) {
            
            if (temp.data == key) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else {
                    if (temp.prev != null) temp.prev.next = temp.next;
                    if (temp.next != null) temp.next.prev = temp.prev;
                }
            }
            
            temp = temp.next;
        }
        return head;
    }
    
    public static NodePair findPairsWithGivenSumInDLL(Node head, int sum) {
        Node temp = head;
        HashMap<Integer, Node> moreNeeded = new HashMap<>();
        while (temp != null) {
            int req = sum - temp.data;
            if (moreNeeded.containsKey(req)) {
                Node first = moreNeeded.get(req);
                return new NodePair(first, temp);
            } else {
                moreNeeded.put(temp.data, temp);
            }
            temp = temp.next;
        }
        return null;
    }
    
    public static Node removeDuplicatesFromSortedDLL(Node head) {
        Node temp = head;
        while (temp != null) {
            if (temp != head) {
                if (temp.prev.data == temp.data) {
                    temp.next.prev = temp.prev; 
                    temp.prev.next = temp.next;
                }
            }
            temp = temp.next;
        }
        return head;
    }
    
    //2 while loop
    
    public static void main(String[] args) {
//        int[] arr = {5, 4, 4, 1, 1, 2};
//        Node head = createDoublyLinkedList(arr);
//        head = deleteKeyOccurrencesInDLL(head, 2);
//        printDLL(head);

//        int[] arr = {5, 4, 4, 1, 1, 2};
//        Node head = createDoublyLinkedList(arr);
//        NodePair pair = findPairsWithGivenSumInDLL(head, 2);
//        if (pair != null) {
//            System.out.println("First: " + pair.first.data + "\nSecond: " + pair.second.data);
//        }
        
        Node head = createDoublyLinkedList(new int[]{1, 2, 2, 3, 4, 4, 5});
        head = removeDuplicatesFromSortedDLL(head);
        printDLL(head);
        
    }
    
}
