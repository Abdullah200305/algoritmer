package test;

import java.util.ArrayList;

public class MaxHeap {
    private ArrayList<Integer> HeapArray;
    public MaxHeap() {
        HeapArray = new ArrayList<>();
    }
    public boolean add(int item){
        HeapArray.add(item);
        siftUp(HeapArray.size()-1);
        return true;
    }

    ///  regler to het right left and parent index node
    private int right(int i){
        return i*2+2;
    }
    private int left(int i){
        return i*2+1;
    }
    private int parent(int i){
        return (i-1)/2;
    }

    private void siftUp(int NodeIndex){
        int currentNode = HeapArray.get(NodeIndex);
        while(NodeIndex>0){
            int parent = HeapArray.get(parent(NodeIndex));
            if(parent<currentNode){
                int temp = parent;
                HeapArray.set(parent(NodeIndex),currentNode);
                HeapArray.set(NodeIndex,temp);
            }
            else if(parent==currentNode){
                break;
            }
            NodeIndex = parent(NodeIndex);
        }
    }


    public int pop(){
        if(HeapArray.isEmpty()){
            return -1;
        }
        int oldValue = HeapArray.get(0);
        HeapArray.set(0, HeapArray.get(HeapArray.size()-1));
        HeapArray.remove(HeapArray.size()-1);
       siftDown(0);
       return oldValue;
    }
    private void siftDown(int NodeIndex){
        int size = HeapArray.size();
        while(true){
            int leftIndex = left(NodeIndex);
            int rightIndex = right(NodeIndex);
            int bigger = NodeIndex;
            if(rightIndex<size  &&HeapArray.get(rightIndex) > HeapArray.get(bigger) ){
                bigger = rightIndex;
            }
            if(leftIndex<size  &&HeapArray.get(leftIndex) > HeapArray.get(bigger)){
                bigger = leftIndex;
            }
            if(bigger!=NodeIndex){
                int temp = HeapArray.get(NodeIndex);
                HeapArray.set(NodeIndex, HeapArray.get(bigger));
                HeapArray.set(bigger, temp);
                NodeIndex = bigger;
            }
            else {
                break;
            }
        }
    }



    public ArrayList heapSort(){

        ArrayList temp = new ArrayList<>();

        while(HeapArray.size()>0){
            temp.add(0,this.pop());
        }
        HeapArray = temp;
        return temp;
    }
    @Override
    public String toString() {
       return HeapArray.toString();
    }
    public static void main(String[] args) {
        MaxHeap max = new MaxHeap();
        max.add(10);
        max.add(20);
        max.add(30);
        max.add(50);
        max.add(40);
        max.add(5);
        max.add(60);
        max.add(25);
        max.add(15);
        max.add(70);
        max.add(35);


        System.out.println(max.toString());

        System.out.println(max.heapSort());
    }
}
