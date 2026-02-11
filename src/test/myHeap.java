package test;

import lektion9.NB28;
import org.w3c.dom.Node;

import javax.print.DocFlavor;
import java.util.ArrayList;

public class myHeap <E extends Comparable<E>>{
    private ArrayList<Integer> data;

    public myHeap() {
        this.data = new ArrayList<>();
    }
    private int right(int i){
        return (i*2)+2;
    }
    private int left(int i){
        return (i*2)+1;
    }
    private int parent(int i){

        return (i-1)/2;

    }

    int peek() {
        return data.get(0);
    }
    public boolean add(int item){
        if(data.contains(item)){
            return false;
        }
        data.add(item);
        NodeUp(data.size() - 1);
        return true;
    }

    private void NodeUp(int index) {
        while (index > 0) {
            int parentIndex = parent(index);
            if (data.get(parentIndex) <= data.get(index)) {
                break;
            }
            int temp = data.get(parentIndex);
            data.set(parentIndex, data.get(index));
            data.set(index, temp);
            index = parentIndex;
        }
    }

    public int pop() {
        if (data.isEmpty()) {
           return 0;
        }

        int min = data.get(0);                  // save root
        int last = data.get(data.size() - 1);   // last element
        data.set(0, last);                      // move last to root
        data.remove(data.size() - 1);           // remove last

        siftDown(0);                             // restore heap property

        return min;
    }

    private void siftDown(int index) {
        int size = data.size();
        while (true) {
            int leftIndex = left(index);
            int rightIndex = right(index);
            int smallest = index;

            if (leftIndex < size && data.get(leftIndex) < data.get(smallest)) {
                smallest = leftIndex;
            }
            if (rightIndex < size && data.get(rightIndex) < data.get(smallest)) {
                smallest = rightIndex;
            }

            if (smallest != index) {
                int temp = data.get(index);
                data.set(index, data.get(smallest));
                data.set(smallest, temp);
                index = smallest; // continue down
            } else {
                break; // heap property restored
            }
        }
    }
    @Override
    public String toString() {
      return data.toString();
    }

    public void heapSort(){

    }


    public static void main(String[] args) {
    myHeap<Integer> heap = new myHeap();
        heap.add(6);
        heap.add(2);
        heap.add(1);
        heap.add(4);
        heap.add(5);

        System.out.println(heap.toString());
        heap.pop();
        System.out.println(heap.toString());


    }
}
