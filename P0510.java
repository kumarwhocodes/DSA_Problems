public class P0510 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int N = 3;
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        head.next.next.next = new Node(arr[3]);
        head.next.next.next.next = new Node(arr[4]);
        head.next.next.next.next.next = new Node(arr[5]);
        P2608.printLL(head);
        head = removeLastNthNode(head,3);
        P2608.printLL(head);
    }

    //Sort 0s, 1s and 2s - Optimal
    static int[] sort012(int[] arr, int n) {
        int low = 0;
        int mid = 0;
        int high = n - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                P2706.swapInArray(arr, mid, low);
                mid++;
                low++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                P2706.swapInArray(arr, mid, high);
                high--;
            }
        }
        return arr;
    }

    //Remove N-th last node from the LL - Optimal
    static Node removeLastNthNode(Node head, int n) {
        Node slow = head;
        Node fast = head;
        int index = 1;
        while (index <= n) {
            fast = fast.next;
            index++;
        }//abb dono saath m aage jayenge
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }//abb slow ush delete hone wale node se ek node pehle p phoch gya hai
        slow.next = slow.next.next;
        return head;
    }

    //Delete middle node of LL
    static Node removeMiddleNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        fast = fast.next.next;//skip 1 step of slow and same
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
