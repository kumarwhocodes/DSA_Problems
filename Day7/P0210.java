package Day7;

import Day5.P2808;

public class P0210 {

    //Reverse a LL - Iterative
    static Node reverseIterativeLL(Node head){
        Node curr = head;
        Node back = null;
        while (curr !=null){
            Node front = curr.next;
            curr.next = back;
            back = curr;
            curr = front;
        }
        return back;
    }

    public static void main(String[] args) {
        Node head = null;

        head = P2808.insertAnywhere(head, 0, 1);
        head = P2808.insertAnywhere(head, 1, 2);
        head = P2808.insertAnywhere(head, 2, 3);
        head = P2808.insertAnywhere(head, 3, 4);

        P2808.printLL(head);
        head = reverseIterativeLL(head);
        P2808.printLL(head);
    }

}
