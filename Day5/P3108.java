package Day5;

import Day7.Node;

public class P3108 {

    //Reversing a DLL - Optimal Approach
    static Node reverseDLL(Node head){
        if(head == null || head.next == null){  //Zero or One element present in LL
            return head;
        }

        Node last = null;
        Node current = head;

        while (current!=null){
            last = current.prev;
            current.prev = current.next;
            current.next = last;

            current = current.prev;
        }
        return last.prev;
    }

    public static void main(String[] args) {
        Node head = null;

        head = P2808.insertAnywhere(head, 0, 1);
        head = P2808.insertAnywhere(head, 1, 2);
        head = P2808.insertAnywhere(head, 2, 3);
        head = P2808.insertAnywhere(head, 3, 4);

        P2808.printLL(head);

        head = reverseDLL(head);
        P2808.printLL(head);

    }
}
