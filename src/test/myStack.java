package test;

import java.util.EmptyStackException;

public class myStack<E> {
    private E[]data;
    private int size;
    private int maxInit;
    public myStack(){
        size = -1;
        maxInit= 2;
        data = (E[]) new Object[maxInit];
    }
    public boolean push(E item){
        if(size==maxInit-1){
            Increase();
        }
        size++;
        data[size]= item;
        return true;
    }
    private void Increase(){
        int newMaxInit= maxInit*2;
        E[] newData = (E[])new Object[newMaxInit];
        for (int i = 0; i < size; i++) {
            newData[i]=data[i];
        }
        data = newData;
        maxInit = newMaxInit;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public E pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return data[size--];
    }
    public E peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E temp=data[size];
        return temp;
    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; i++) {
            str.append(data[i]+" ");
        }
        return str.toString();
    }
}
