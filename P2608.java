//Single LINKED LIST commented class code to avoid build issues
//class Node{
//    int data;
//    Node next;
//
//    Node(int data,Node next){
//        this.data = data;
//        this.next = next;
//    }
//
//    Node(int data){
//        this.data = data;
//        this.next = null;
//    }
//}

public class P2608 {

    static void printLL(Node head){
        Node traverseNode = head;
        while (traverseNode!=null) {
            System.out.print(traverseNode.data + " -> ");
            traverseNode = traverseNode.next;
        }
        System.out.println("NULL");
    }

    static Node insertAtStart(Node head, int value){
        Node newNode = new Node(value);
        newNode.next = head;
        return newNode;
    }

    static Node insertAtEnd(Node head, int value){
        Node travNode = head;
        Node newNode = new Node(value);
        while (travNode.next!=null) {
            travNode=travNode.next;
        }
        travNode.next = newNode;
        return newNode;
    }

    

    public static void main(String[] args) {
        Node head = null;
        head = insertAtStart(head, 5);
        head = insertAtStart(head, 4);
        insertAtEnd(head, 100);
    
    }
}
