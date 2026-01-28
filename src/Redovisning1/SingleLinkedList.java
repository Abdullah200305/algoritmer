




package Redovisning1;

import java.util.Iterator;

public class SingleLinkedList<E> {

    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SingleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private void addFirst(E item) {
        head = new Node<>(item, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void add(E item) {
        if (size == 0) {
            addFirst(item);
        } else {
            tail.next = new Node<>(item, null);
            tail = tail.next;
            size++;
        }
    }

    public void add(int index, E item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(index);

        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            add(item);
        } else {
            Node<E> prev = getNode(index - 1);
            prev.next = new Node<>(item, prev.next);
            size++;
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if(index==(size-1)){
            return tail.data;
        }
        return getNode(index).data;
    }

    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        E data;
        if (index == 0) {
            data = head.data;
            head = head.next;
            if (size == 1) {
                tail = null;
            }
        } else {
            Node<E> prev = getNode(index - 1);
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

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;
        while (current!=null) {
            sb.append(current.data);
            if (current.next!=null) sb.append(" => ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}





















