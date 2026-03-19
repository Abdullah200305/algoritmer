package tentan;

import java.util.Arrays;

public class Queue {
    private int front;
    private int rear;
    private int[] data;
    private int size;
    private int s;
    public Queue() {
        this.size =3;
        this.s = 0;
        this.front = 0;
        this.rear = size-1;
        this.data = new int[size];
    }

    public boolean push(int item){
        if(s==data.length){
            return false;
        }
        rear = (rear+1)% size;
        data[rear]= item;
        return true;
    }

    public boolean poll(){
        if(s == 0) return false; // tom kö
        front = (front + 1) % data.length;
        s--;
        return true;
    }

    @Override
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]+" ");
        }
        return stringBuilder.toString();
    }
}
