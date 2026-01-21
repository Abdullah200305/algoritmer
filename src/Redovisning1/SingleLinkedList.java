package Redovisning1;

public class SingleLinkedList<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next;
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node<E> head;
    private Node<E> tail;
    private int size;
    public SingleLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    public void addFirst(E item) {
        head = new Node<E>(item, head);
        size++;
    }
    public void addAfter(E item) {
        Node node = getNode(size-1);
        node.next = new Node<E>(item, node.next);
        tail = node.next;
        size++;
    }
    public void addAfter(int index,E item) {
        Node node = getNode(index-1);
        node.next = new Node<E>(item, node.next);
        tail = getNode(size);
        size++;
    }
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        System.out.println(tail.data);
        return node.data;
    }
    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    public E remove(int index){
        E data = null;
        if(index == 0){
            data = head.data;
            head = head.next;
            if (size == 1) {
                tail = null;
            }
        }
        else {
            Node<E> prev = getNode(index-1);
            Node<E> toDelete = prev.next;
            data = toDelete.data;
            prev.next = toDelete.next;
            if (toDelete == tail) {
                tail = prev;
            }
        }
        size--;
        return data;
    }






}
