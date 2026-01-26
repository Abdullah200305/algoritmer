package test;

import java.util.EmptyStackException;

public class myStackList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int top;
    private class Node<E>{
      private E data;
      private Node<E> next;
      public Node(E data,Node next){
          this.data = data;
          this.next = next;
        }
    }
    public myStackList(){
        head =null;
        top  =0;
    }
    public E pop(){
        if (IsEmpty()){
            throw new EmptyStackException();
        }

        return tail.data;
    }
   /* public E peek(){
        if (IsEmpty()){
            throw new EmptyStackException();
        }
        return tail.data;
    }*/
    public boolean IsEmpty(){
        return top == 0;
    }
    public E push(E item){
        head = new Node<>(item,head);
        return item;
    }
    @Override
    public String toString(){
        Node<E> current = head;
        StringBuilder str = new StringBuilder();
        while (current!=null){
            str.append(current.data+" ");
            current= current.next;
        }
        return str.toString();
    }
}
