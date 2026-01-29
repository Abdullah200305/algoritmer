package lektion6;

import Redovisning1.SingleLinkedList;

public class NB17<E> {
    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E data,Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;


    public NB17() {
        head = null;

    }

    private void addFirst(E item) {
        head = new Node<E>(item, head);
    }

    public void add(E item) {
        if (size() == 0) {
            addFirst(item);
        } else {
            Node<E> prev = getNode(size() - 1);
            prev.next = new Node<>(item, prev.next);

        }
    }
    public void add(int index, E item) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException(index);

        if (index == 0) {
            addFirst(item);
        } else if (index == size()) {
            add(item);
        } else {
            Node<E> prev = getNode(index - 1);
            prev.next = new Node<>(item, prev.next);

        }
    }

    public E get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        return getNode(index).data;
    }




    private Node<E> getNode(int index) {
        return getNode(index,0,head);
    }
    // Rekursiv
    private Node<E> getNode(int index,int postion,Node<E> head){
        if(postion==index){
            return head;
        }
        return getNode(index,postion+1,head.next);
    }



    public int size() {
        return size(head);
    }
    // Rekursiv
    private int size(Node<E> head){
        if(head==null){
            return 0;
        }
        return 1+size(head.next);
    }

    public String toString(){
        if(head!=null) return "["+toString(head)+"]";
        return "[]";
    }
    //Rekursiv
    private String toString(Node<E> head){
        if(head.next!=null){
            return head.data.toString()+","+toString(head.next);
        }
        return head.data.toString();
    }

    public static void main(String[] args) {
        NB17<Integer> list = new NB17<>();
        list.add(10);
        list.add(20);
        list.add(1,340);
        System.out.println(list.toString());
    }
}
