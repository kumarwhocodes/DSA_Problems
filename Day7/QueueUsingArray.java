package Day7;

public class QueueUsingArray {
    int[] arr;
    int start, end, currSize, maxSize;

    public QueueUsingArray() {
        arr = new int[100];
        start = -1;
        end = -1;
        currSize = 0;
    }

    public QueueUsingArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        start = -1;
        end = -1;
        currSize = 0;
    }

    public void enqueue(int newNum) {
        if (currSize == maxSize) {
            System.out.println("Queue is full.");
            System.exit(1);
        }
        if (end == -1) {
            start = 0;
            end = 0;
        } else
            end = (end + 1) % maxSize;
        arr[end] = newNum;
        currSize++;
        System.out.println(newNum + " enqueued.");
    }

    public int dequeue() {
        if (currSize == 0 | start == -1) {
            System.out.println("Queue is already empty!");
            return -1;
        }
        int toBeDeleted = arr[start];
        if (currSize == 1) {
            start = -1;
            end = -1;
        } else
            start = (start + 1) % maxSize;
        currSize--;
        return toBeDeleted;
    }

    public int topOfQueue() {
        if (start == -1) {
            System.out.println("Queue has no top element.");
            return -1;
        }
        return arr[start];
    }

    public int size() {
        return currSize;
    }
}
