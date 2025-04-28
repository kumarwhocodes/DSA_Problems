package P1024;

import java.util.ArrayList;

public class P1210 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.prev = head;
        head.next.next = new Node(arr[2]);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(arr[3]);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(arr[4]);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new Node(arr[5]);
        head.next.next.next.next.next.prev = head.next.next.next.next;
//
//        int[] arr1 = {6, 5, 4, 3, 2, 1};
//        P1910.Node head_ = new P1910.Node(arr1[0]);
//        head_.next = new P1910.Node(arr1[1]);
//        head_.next.next = new P1910.Node(arr1[2]);
//        head_.next.next.next = new P1910.Node(arr1[3]);
//        head_.next.next.next.next = new P1910.Node(arr1[4]);
//        head_.next.next.next.next.next = new P1910.Node(arr1[5]);

//        P1910.Node node = deleteAllOccurencesInDLL(head,4);
//
//        P0824.P2608.printLL(node);

        double ans = pow(3, -3);
        System.out.println(ans);
    }

    // Add Two Reversed LL
    static Node addTwoReverseLL(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node temp = dummy;
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
            Node newNode = new Node(sum % 10);
            temp.next = newNode;
            temp = temp.next;
        }
        return dummy.next;
    }

    //delete all occurences of a key in DLL
    static Node deleteAllOccurencesInDLL(Node head, int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                if (temp == head) {
                    head = temp.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    // If the node to be deleted is in the middle or end
                    temp.prev.next = temp.next;
                    if (temp.next != null) {
                        temp.next.prev = temp.prev;
                    }
                }
                // Move to the next node before deletion
            }
            temp = temp.next;
        }
        return head;
    }

    //find power - Binary Exponentiation - O(log N)
    static double pow(double x, int n) {
        double ans = 1.0;
        long nn = n;

        if (nn == 0) return 1.0;    //Best case
        if (nn < 0) nn = -1 * nn;         //Converting negative power to positive power

        while (nn > 0) {
            if (nn % 2 == 1) {    //if nn is odd
                ans = ans * x;
                nn--;
            } else {           //if nn is even
                x = x * x;
                nn = nn / 2;
            }
        }

        if (n < 0) ans = (double) 1.0 / (double) ans;
        return ans;
    }

    //find power - using recursion - O(n)
    static double findPowerUsingRecursion(double x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * findPowerUsingRecursion(x, n - 1);
    }

    //find pairs with given sum in sorted DLL - 0(N)
    static Node findTail(Node head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    static ArrayList<NodePair> findPairsWithGivenSum(Node head, int sum) {
        Node left = head;
        Node right = findTail(head);
        ArrayList<NodePair> list = new ArrayList<>();
        while (left != null && right != null && left != right && left.data < right.data) {
            int currentSum = left.data + right.data;
            if (currentSum == sum) {
                list.add(new NodePair(left, right));
                left = left.next;
                right = right.prev;
            } else if (currentSum < sum) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }
        return list;
    }

    // Sort LL
    Node mergeTwoSortedLinkedLists(Node list1, Node list2) {
        // Create a dummy node to serve as the head of the merged list
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        // Traverse both lists simultaneously
        while (list1 != null && list2 != null) {
            // Compare elements of both lists and link the smaller node to the merged list
            if (list1.data <= list2.data) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        // If any list still has remaining elements, append them to the merged list
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        // Return the merged list starting from the next of the dummy node
        return dummyNode.next;
    }

    Node findMiddle(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    Node sortLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = findMiddle(head);
        // Divide the list into two halves
        Node right = middle.next;
        middle.next = null;
        Node left = head;

        // Recursively sort the left and right halves
        left = sortLL(left);
        right = sortLL(right);

        // Merge the sorted halves using the mergeTwoSortedLinkedLists function
        return mergeTwoSortedLinkedLists(left, right);
    }

}
