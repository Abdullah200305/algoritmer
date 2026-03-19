package three;

import java.util.Iterator;

public class EnkelList<E> implements Iterable<E> {
    private int size;
    private Node<E> head;
    private class Node<E>{
        private E data;
        private Node<E> next;
        public Node(E data,Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    public boolean Add(E item){
        if(head==null){
            head = new Node<>(item,head);
        }
        else {
            Node current = next(size-1);
            current.next = new Node<>(item,null);
        }
        size++;
        return true;
    }
    private Node<E> next(int index){
        Node <E>Current = head;
        for (int i = 0; i <index &&Current!=null; i++) {
            Current = Current.next;
        }
        return Current;
    }
    public Iterator<E> iterator(){
        return new itr();
    }



    private class itr implements Iterator<E>{
        Node<E> current = head;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public E next() {
            E temp = current.data;
            current= current.next;
            return temp;
        }
    }



    public Iterator<E> Indexiterator(int index){
        if(index<0 && index>=size){
            throw new RuntimeException();
        }
        return new itrIndext(index);
    }



    private class itrIndext implements Iterator<E>{
        Node<E> current = head;
        public itrIndext(int start){
            for (int i = 0; i <start && current!=null ; i++) {
                current=current.next;
            }
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public E next() {
            E temp = current.data;
            current= current.next;
            return temp;
        }
    }
    public static void main(String[] args) {
        EnkelList<Integer> list = new EnkelList<>();
        list.Add(0);
        list.Add(1);
        list.Add(2);
        list.Add(3);
      /*  Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/

        Iterator a = list.Indexiterator(3);
        while (a.hasNext()){
            System.out.println(a.next());
        }
    }

}
