package tentan;

import java.util.Iterator;

public class test2<E> {
    private int size;
    private Node<E> head;
    private Node<E> tail;

    private class Node<E>{
        private Node next;
        private E data;
        public Node(Node next,E data) {
            this.next = next;
            this.data = data;
        }
    }
    public test2(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public boolean Add(int index, E data){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if(index==0){
                head =new Node<>(head,data);
        }
        else {
            Node current = next(index-1);
            current.next = new Node<>(current.next,data);
            tail=  current.next;
        }
        size++;
        return true;
    }
    private Node<E> next(int index){
        Node<E> node = head;
        for (int i = 0; i <index && node!=null; i++) {
            node = node.next;
        }
        return node;
    }
    public E Remove(int index){
        E temp = null;
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if(index==0){
            temp = head.data;
            head =head.next;
            Node<E> node = next(size-1);

            node.next = head;
        }
        else {
            Node<E> node = next(index-1);
            Node re = node.next;
            temp = (E) re.data;
            node.next = re.next;
        }
        size--;
        return temp;
    }

    public int getSize() {
        return size;
    }

/* public Iterator<E> iterator(){
        return new itr();
    }*/

    public Iterator<E> Eventiterator(){
        return new itr();
    }


    private class itr implements Iterator<E>{
        private Node current = head;
        private Node prv = null;
        private Node last = null;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public E next() {
            E temp = (E) current.data;
            prv = last;
            last = current;
            current = current.next;
          /*  if(current.next!=null){
                current= current.next.next;
            }
            else{
                current = current.next;
            }*/
            return temp;
        }
        @Override
        public void remove() {
            if( prv==null){
                head= current;
            }
            else {
                prv.next = current;
            }
            last=null;

        }
    }
}
