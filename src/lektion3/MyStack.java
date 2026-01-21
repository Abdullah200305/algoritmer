/*
package lektion3;
import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<E> implements Stack<E>{
    private E[] data;
    private int size;
    private int capcity;

    public MyStack() {
        capcity = 1;
        size = -1;
        data = (E[]) new Object[capcity];
    }
    private void increaseSize(){
        int newSize = size*2;
        E[] newData = (E[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newData[i]= data[i];
        }
        data = Arrays.copyOf(newData,newSize);
        capcity = newSize;
    }
    @Override
    public E push(E obj) {
        size++;
        if(size==capcity){
            increaseSize();
        }
        data[size]= obj;
        return obj;
    }

    @Override
    public E peek() {
        if(this.empty()){
            throw new EmptyStackException();
        }
        return data[size];
    }

    @Override
    public E pop() {
        if(this.empty()){
            return null;
        }
        E temp = data[size--];
        return temp;
    }

    @Override
    public boolean empty() {
        return size==-1;
    }
    public static void main(String[] args) {
        Stack<String> list = new MyStack<String>();
        list.push("hello");
        System.out.println(list.peek());
        list.pop();
        System.out.println(list.peek());
        System.out.println(list.empty());

    }
}

*/
