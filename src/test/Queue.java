package test;

import java.util.Arrays;

public class Queue<E> {
    private E[] data;
    private int size;
    private int front;
    private int rear;
    private int maxInit;
    public Queue(){
        maxInit = 4;
        size = 0;
        front = 0;
        rear = 0;
        data = (E[]) new Object[maxInit];
    }
    public boolean offer(E item){
        if(size==maxInit){
            Incrase();
        }

        data[rear]=item;
        rear = (rear+1) % maxInit;
        size++;
        return true;
    }
    public boolean poll(){
        size--;
        data[front]= null;
        front = (front+1) % maxInit;
        return true;
    }

    public int getRear() {
        return rear;
    }

    public int getFront() {
        return front;
    }

    private void Incrase(){
        int newMaxInit = maxInit*2;
        E[] newData = (E[]) new Object[newMaxInit];
        for (int i = 0; i < size; i++) {
            System.out.println((rear+i) % maxInit+" "+rear);
            newData[i] = data[(rear+i) % maxInit];
        }
        front = 0;
        rear = size;
        data = newData;
        maxInit = newMaxInit;
    }


    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < maxInit; i++) {
            str.append(data[i]+" ");
        }
        return str.toString();
    }


}
