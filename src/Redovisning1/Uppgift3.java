package Redovisning1;

import java.util.Iterator;

public class Uppgift3<E> {
    private Node head;
    private int size;
    private class Node<E>{
        private E data;
        private Node next;
        public Node(E data,Node next){
            this.data = data;
            this.next = next;
        }
    }
    public Uppgift3(){
        head = null;
        size = 0;
    }
    public boolean Add(E item,int index){
        if(head==null){
            AddFirst(item);
        }
        else{
          AddAfter(index,item);
        }
        return true;
    }
    public boolean Add(E item){
        if(head==null){
            AddFirst(item);
            System.out.println(head.data);
        }
        else{
            AddAfter(0,item);
        }
        return true;
    }
    private boolean AddFirst(E item){
        head = new Node<>(item,null);
        return true;
    }
    private boolean AddAfter(int index,E item){
        Node current = getNode(index);
        current = new Node<>(item,null);
        return true;
    }
    private Node<E>getNode(int index){
        if(index<0 || index>= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        Node<E> current = head;
        for (int i = index; i < size && current.next != null; i++) {
            System.out.println(current);
            current = current.next;
        }
        return current;
    }
}
