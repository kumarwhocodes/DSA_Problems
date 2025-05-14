package Day13;

import java.util.ArrayList;

class Heap<T extends Comparable<T>> {
    
    private ArrayList<T> list;
    
    public Heap() {
        list = new ArrayList<>();
    }
    
    private void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }
    
    private int parent(int index) {
        return (index - 1) / 2;
    }
    
    private int left(int index) {
        return 2 * index + 1;
    }
    
    private int right(int index) {
        return 2 * index + 2;
    }
    
    public void insert(T value) {
        list.add(value);
        upHeap(list.size() - 1);
    }
    
    private void upHeap(int index) {
        if (index == 0) return;                    //if there is only one entry in heap
        
        int p = parent(index);
        if (list.get(index).compareTo(list.get(p)) < 0) {
            swap(index, p);
            upHeap(p);
        }
    }
    
    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from an empty heap!!");
        }
        
        T temp = list.getFirst();
        
        T last = list.removeLast();
        if (!list.isEmpty()) {
            list.set(0, last);
            downHeap(0);
        }
        return temp;
    }
    
    private void downHeap(int index) {
        int min = index;
        int left = left(index);
        int right = right(index);
        
        if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }
        
        if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }
        
        if (min != index) {
            swap(min, index);
            downHeap(min);
        }
    }
    
    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();
        while (!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }
    
}

class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();
        
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        
        System.out.println(heap.remove()); // Output: 1
        System.out.println(heap.remove()); // Output: 3
        System.out.println(heap.remove()); // Output: 5
        System.out.println(heap.remove()); // Output: 8
    }
}
