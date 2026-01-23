package Redovisning1;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
    private class Ite implements Iterator<E>{
        Node<E> current;
        Node<E> lastReturned;
        Node<E> prev;
        public Ite(Node<E> start){
            current = start;
        }
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            prev = lastReturned;
            lastReturned = current;
            current = current.next;
            return lastReturned.data;
        }

        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException("next() not called or already removed");
            }

            if (prev == null) {
                head = current;
            } else {
                prev.next = current;
            }
            size--;
            lastReturned = null;
        }
    }



    public Uppgift3(){
        head = null;
        size = 0;
    }

    public Iterator<E> iterator(){
        return new Ite(head);
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
        }
        else{
           Node<E> node = getNode(size-1);
           node.next = new Node<>(item,null);
        }
        size++;
        return true;
    }
    private boolean AddFirst(E item){
        head = new Node<>(item,null);
        return true;
    }
    private boolean AddAfter(int index,E item){
        if(index==0){
            head = new Node<>(item,head);
        }
        else {
            Node prev = getNode(index-1);
            prev.next = new Node<>(item, prev.next);
        }
        return true;
    }


    private Node<E>getNode(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }







    public int size() {
        return size;
    }



    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        if(size==0){
            str.append("[]");
        }
        Iterator<E> ite = this.iterator();
        while (ite.hasNext()){
            str.append(ite.next()+" ");
            if(ite.hasNext()){
                str.append("=> ");
            }
        }
        return str.toString();
    }
}
