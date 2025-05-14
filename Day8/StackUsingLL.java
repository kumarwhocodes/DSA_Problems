package Day8;

//Implement Stack using LL
public class StackUsingLL {
    StackNode top;          // Instance variable
    int size;               // Instance variable
    StackUsingLL() {
        this.top = null;
        this.size = 0;
    }

    //Stack push using LL
    public void stackPush(int x) {
        StackNode newNode = new StackUsingLL.StackNode(x);
        newNode.next = top;
        top = newNode;
        System.out.println("Element pushed.");
        size++;
    }

    //Stack pop using LL
    public int stackPop() {
        if (top == null) return -1;     //Underflow condition
        int topData = top.data;
        StackNode toBeDeleted = top;
        top = top.next;
        size--;
        return topData;
    }

    //Stack size
    public int stackSize() {
        return size;
    }

    //Check if stack is empty
    public boolean checkEmpty() {
        return top == null;
    }

    //Print stack
    public void printStack(){
        StackNode curr = top;
        while (curr!=null){
            System.out.println(curr.data+ " ");
            curr = curr.next;
        }
        System.out.println();
    }


    static class StackNode {
        int data;
        StackNode next;

        StackNode(int d) {
            data = d;
            next = null;
        }
    }
}
