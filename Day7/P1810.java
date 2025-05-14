package Day7;

public class P1810 {
    public static void main(String[] args) {
//        P1224.StackUsingLL s = new P1224.StackUsingLL();
//        s.stackPush(10);
//        s.stackPush(20);
//        s.printStack();
//        System.out.println("Stack size: " + s.stackSize());
//        System.out.println("Element popped " + s.stackPop());
//        System.out.println("Stack size: " + s.stackSize());
//        System.out.println("Stack is empty or not: " + s.checkEmpty());

//        P1024.QueueUsingArray q = new P1024.QueueUsingArray(6);
//        q.enqueue(4);
//        q.enqueue(14);
//        q.enqueue(24);
//        q.enqueue(34);
//        System.out.println("The peek of the queue before deleting any element " + q.topOfQueue());
//        System.out.println("The size of the queue before deletion " + q.size());
//        System.out.println("The first element to be deleted " + q.dequeue());
//        System.out.println("The peek of the queue after deleting an element " + q.topOfQueue());
//        System.out.println("The size of the queue after deleting an element " + q.size());

        
        QueueUsingLL Q=new QueueUsingLL();
        Q.enqueue(10);
        Q.enqueue(20);
        Q.enqueue(30);
        Q.enqueue(40);
        Q.enqueue(50);
        Q.dequeue();
        System.out.println("The size of the Queue is "+Q.size);
        System.out.println("The Peek element of the Queue is "+Q.peek());
    }
}
