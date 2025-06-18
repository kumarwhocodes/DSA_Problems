package Day23;

import Day7.Node;

import static Day23.LinkedListPP.printSingleLL;
import static Day23.MediumLLPP.reverseSingleLL;
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
    public static Node addTwoLLInReverse(Node head1, Node head2) {
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
    
    public static Node sort012InLL(Node head) {
        if (head == null || head.next == null) return head;
        
        Node zeroDummy = new Node(-1);
        Node oneDummy = new Node(-1);
        Node twoDummy = new Node(-1);
        
        Node zero = zeroDummy, one = oneDummy, two = twoDummy;
        Node temp = head;
        
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        
        zero.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        one.next = twoDummy.next;
        two.next = null;
        
        return zeroDummy.next;
    }
    
    public static Node findIntersectionNodeOfTwoLL(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;
        Node t1 = head1;
        Node t2 = head2;
        
        while (t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;
            
            if (t1 == t2) return t1;
            
            if (t1 == null) t1 = head2;
            if (t2 == null) t2 = head1;
        }
        return t1;
    }
    
    public static Node addOneToLLBrute(Node head) {
        if (head == null) return new Node(1);
        
        Node reversedHead = reverseSingleLL(head);
        Node temp = reversedHead;
        int carry = 1;
        
        Node prev = null;
        while (temp != null) {
            int sum = temp.data + carry;
            temp.data = sum % 10;
            carry = sum / 10;
            
            prev = temp;
            temp = temp.next;
        }
        if (carry == 1) {
            assert prev != null;
            prev.next = new Node(1);
        }
        return reverseSingleLL(reversedHead);
    }
    
    public static Node addTwoLL(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        
        Node h1 = reverseSingleLL(head1);
        Node h2 = reverseSingleLL(head2);
        int carry = 0;
        
        Node dummy = new Node(-1);
        Node temp = dummy;
        
        while (h1 != null || h2 != null || carry != 0) {
            int sum = carry;
            if (h1 != null) {
                sum += h1.data;
                h1 = h1.next;
            }
            if (h2 != null) {
                sum += h2.data;
                h2 = h2.next;
            }
            
            temp.next = new Node(sum % 10);
            carry = sum / 10;
            temp = temp.next;
        }
        
        return reverseSingleLL(dummy.next);
    }
    
    
    public static void main(String[] args) {
//        int[] arr = {5, 4, 3, 2, 1};
//        Node head = createLinkedList(arr);
//        head = sortLL(head);
//        printSingleLL(head);

//        int[] arr = {1, 0, 5};
//        int[] arr2 = {1, 0, 5};
//        Node head = createLinkedList(arr);
//        Node head2 = createLinkedList(arr2);
//        Node sum = addTwoLL(head, head2);
//        printSingleLL(sum);

//        int[] arr = {2, 1, 2, 1, 0, 1, 2};
//        Node head = createLinkedList(arr);
//        head = sort012InLL(head);
//        printSingleLL(head);

//        Node common = createLinkedList(new int[]{8, 9, 10});
//        Node head1 = createLinkedList(new int[]{1, 2, 3});       // First list: 1 -> 2 -> 3 -> 8 -> 9 -> 10
//        Node temp = head1;
//        while (temp.next != null) temp = temp.next;
//        temp.next = common;
//        Node head2 = createLinkedList(new int[]{6, 7});         // Second list: 6 -> 7 -> 8 -> 9 -> 10 (same common)
//        temp = head2;
//        while (temp.next != null) temp = temp.next;
//        temp.next = common;
//        Node intersection = findIntersectionNodeOfTwoLL(head1, head2);
//        System.out.println("Intersection Node: " + (intersection != null ? intersection.data : "null"));

//        int[] arr = {9, 9};
//        Node head = createLinkedList(arr);
//        head = addOneToLLBrute(head);
//        printSingleLL(head);
        
        int[] arr = {1, 0, 6};
        int[] arr2 = {1, 0, 8};
        Node head = createLinkedList(arr);
        Node head2 = createLinkedList(arr2);
        Node sum = addTwoLL(head, head2);
        printSingleLL(sum);
    }
    
}
