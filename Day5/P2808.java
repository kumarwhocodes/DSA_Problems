package Day5;/*


class P1910.Node {
    int data;
    P1910.Node next;

    P1910.Node(int data) {
        this.data = data;
        this.next = null;
    }

    P1910.Node(int data, P1910.Node next) {
        this.data = data;
        this.next = next;
    }
}

public class P0824.P2808 {

    static void printLL(P1910.Node head) {
        P1910.Node traverseNode = head;
        while (traverseNode != null) {
            System.out.print(traverseNode.data + " -> ");
            traverseNode = traverseNode.next;
        }
        System.out.println("NULL");
    }

    static P1910.Node insertAnywhere(P1910.Node head, int index, int value) {
        if (index == 0) {
            P1910.Node newNode = new P1910.Node(value);
            newNode.next = head;
            return newNode;
        }

        int count = 0;
        P1910.Node travNode = head;
        while (count < index - 1 && travNode != null) {
            count++;
            travNode = travNode.next;
        }

        if (travNode == null) { // if the index is not present in LL
            return head;
        }

        P1910.Node newNode = new P1910.Node(value);
        newNode.next = travNode.next;
        travNode.next = newNode;

        return head;
    }

    static P1910.Node deleteLastNode(P1910.Node head) {
        if (head == null) {
            return null; // Empty list, nothing to delete
        }
        if (head.next == null) {
            return null; // Only one node in the list, deleting it
        }

        P1910.Node travNode = head;
        while (travNode.next.next != null) {
            travNode = travNode.next;
        }
        travNode.next = null;
        return head;
    }

    static P1910.Node deleteFirstNode(P1910.Node head) {
        if (head == null) {
            return null; // Empty list, nothing to delete
        }
        return head.next;
    }

    static P1910.Node deleteAnyNode(P1910.Node head, int index) {
        if (index == 0) {
            return deleteFirstNode(head);
        }

        int count = 0;
        P1910.Node travNode = head;
        while (count < index - 1 && travNode != null) {
            travNode = travNode.next;
            count++;
        }

        if (travNode == null || travNode.next == null) { // Index out of bounds
            return head;
        }
        travNode.next = travNode.next.next;
        return head;
    }

    static int findLengthOfLL(P1910.Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    static boolean searchInLL(P1910.Node head, int key) {
        while (head != null) {
            if (head.data == key) {
                return true;
            }
            head = head.next;
        }
        return false;
    }


    public static void main(String[] args) {
        P1910.Node head = null;
        head = insertAnywhere(head, 0, 10);
        head = insertAnywhere(head, 1, 20);
        head = insertAnywhere(head, 2, 30);
        System.out.println(searchInLL(head, 30)); 
    }
}
*/

import Day7.Node;

public class P2808 {

    public static void printLL(Node head) {
        Node traverseNode = head;
        while (traverseNode != null) {
            System.out.print(traverseNode.data + " <-> ");
            traverseNode = traverseNode.next;
        }
        System.out.println("NULL");
    }

    static Node insertAtFirst(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) {
            return newNode;
        }
        newNode.next = head;
        head.prev = newNode;
        return newNode;
    }

    static Node insertAtEnd(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return head;
        }
        while (head.next != null) {
            head = head.next;
        }
        head.next = newNode;
        newNode.prev = head;
        return head;
    }

    public static Node insertAnywhere(Node head, int index, int value) {
        Node newNode = new Node(value);

        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            return newNode;
        }

        int count = 0;
        Node curr = head;

        while (count < index - 1 && curr != null) {
            count++;
            curr = curr.next;
        }
        if (curr == null) {
            return head;
        }

        newNode.next = curr.next;
        if (curr.next != null) {
            curr.next.prev = newNode;
        }
        curr.next = newNode;
        newNode.prev = curr;

        return head;
    }

    public static void main(String[] args) {
        Node head = null;

        head = insertAnywhere(head, 0, 1);
        head = insertAnywhere(head, 1, 2);
        head = insertAnywhere(head, 2, 3);
        head = insertAnywhere(head, 1, 4);

        printLL(head);
    }
}
