package P0924;

import P0824.P2808;
import P1024.Node;

public class P3009 {
    
    //Finding middle of linked list [Tortoise & Hare Method]
    static Integer findMiddleElementLL(Node head) {
        if (head == null || head.next == null) {
            return head.data;
        }
        
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
    
    public static void main(String[] args) {
        Node head = null;
        
        head = P2808.insertAnywhere(head, 0, 1);
        head = P2808.insertAnywhere(head, 1, 2);
        head = P2808.insertAnywhere(head, 2, 3);
        head = P2808.insertAnywhere(head, 3, 4);
        
        P2808.printLL(head);
        System.out.println(findMiddleElementLL(head));
        
    }
}
