class QueueNode {
    int data;
    QueueNode next;

    QueueNode(int val) {
        data = val;
        next = null;
    }
}

class QueueUsingLL {
    QueueNode front = null;
    QueueNode rear = null;
    int size = 0;

    public boolean isQueueEmpty() {
        return front == null;
    }

    public int peek() {
        if (isQueueEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        } else {
            return front.data;
        }
    }

    public void enqueue(int newNum) {
        QueueNode newNode = new QueueNode(newNum);
        if (front == null) {
            front = rear = newNode;
        } else{
            rear.next = newNode;
            rear = newNode;
            }
        size++;
        System.out.println(newNum + " enqueued.");
    }

    public void dequeue() {
        if (front == null) {
            System.out.println("Queue is already empty.");
        }
        QueueNode toBeDeleted = front;
        if (front == rear) {
            front = rear = null;
        } else
            front = front.next;
        size--;
        System.out.println(toBeDeleted.data + " dequeued!");
    }

}
