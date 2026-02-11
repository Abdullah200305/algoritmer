package lketion10;

import java.util.Arrays;

public class NB30<E extends Comparable<E>>{
    private E[] data;
    private int size;
    private int nextPos;

    public NB30(int storlek) {
        this.data = (E[]) new Comparable[storlek];
        nextPos = 0;
    }
    public boolean insert(E data) {
        if(nextPos >= this.data.length) {
            this.data = Arrays.copyOf(this.data, this.data.length * 2);
        }
        this.data[nextPos]=data;
        size++;
        int currentIndex=nextPos++;
        int parent;
        while(currentIndex>0){
            parent = (currentIndex-1)/2;
            if(this.data[parent].compareTo(data)>0){
                E temp = this.data[parent];
                this.data[parent]=data;
                this.data[currentIndex]=temp;
            }
            if(this.data[parent].compareTo(data)<0){
                break;
            }
            currentIndex=parent;
        }
        return true;
    }
      public E extract(){
        if(size == 0) return null;
        E oldValue = this.data[0];
        this.data[0]= this.data[size-1];
        this.data[size-1]= null;
        size--;
        nextPos--;
        int i = 0;

        while(true){
            int smallest =i;
            int right = i*2+2;
            int left = i*2+1;
            if(right<size && this.data[right].compareTo(this.data[i])<0){
                smallest = right;
            }
            if(left<size && this.data[left].compareTo(this.data[i])<0){
                smallest  = left;
            }
            if(smallest!=i){
               E temp = this.data[smallest];
               this.data[smallest]= this.data[i];
               this.data[i] = temp;
               i = smallest;
            }
            else {
                break;
            }
        }
        return oldValue;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
    public static void main(String[] args) {
        NB30<String> heap = new NB30<>(5);
        heap.insert("A");
        heap.insert("B");
        heap.insert("D");
        heap.insert("E");
        heap.insert("A");
        heap.extract();
        heap.extract();
        heap.insert("E");
        heap.insert("F");

        System.out.println(heap.toString());
    }
}
