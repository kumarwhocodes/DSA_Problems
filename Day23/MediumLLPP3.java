package Day23;

import Day7.Node;

import static Day23.LinkedListPP.printSingleLL;
import static Day23.MediumLLPP2.createLinkedList;

public class MediumLLPP3 {
    
    //Finding middle node for odd elements and finding node after middle for even elements
    public static Node findNodeAfterMiddleForSort(Node head) {
        Node slow = head;
        Node fast = head.next;      //Moving fast ahead by 1 place
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    //function to merge two sorted list for sorting LL
    public static Node mergeTwoLL(Node left, Node right) {
        Node mergedList = new Node(-1);
        Node temp = mergedList;
        while (left != null && right != null) {
            if (left.data < right.data) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        if (left != null) temp.next = left;
        else temp.next = right;
        
        return mergedList.next;
    }
    
    //Sorting linked list using merge sort
    public static Node sortLL(Node head) {
        if (head == null || head.next == null) return head;         //Base case
        Node middle = findNodeAfterMiddleForSort(head);
        
        Node leftHead = head;
        Node rightHead = middle.next;
        middle.next = null;
        
        leftHead = sortLL(leftHead);
        rightHead = sortLL(rightHead);
        
        return mergeTwoLL(leftHead, rightHead);
    }
    
    //Leetcode question no.: 2
    //Add two numbers given in two linked lists and are in reverse order
    public static Node addTwoLL(Node head1, Node head2) {
        Node sumLL = new Node(-1);
        Node temp = sumLL;
        int carry = 0;
        while (head1 != null || head2 != null || carry == 1) {
            int sum = 0;
            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }
            sum += carry;
            carry = sum / 10;
            
            temp.next = new Node(sum % 10);
            temp = temp.next;
        }
        return sumLL.next;
    }
    
    public static void main(String[] args) {
//        int[] arr = {5, 4, 3, 2, 1};
//        Node head = createLinkedList(arr);
//        head = sortLL(head);
//        printSingleLL(head);
        
        int[] arr = {1, 0, 5};
        int[] arr2 = {1, 0, 5};
        Node head = createLinkedList(arr);
        Node head2 = createLinkedList(arr2);
        Node sum = addTwoLL(head, head2);
        printSingleLL(sum);
    }
    
}
