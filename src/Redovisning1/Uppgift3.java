
package Redovisning1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Uppgift3<E> {
    private Node<E> head;
    private int size;

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private class Ite implements Iterator<E> {
        Node<E> current = head;
        Node<E> lastReturned = null;
        Node<E> prev = null;

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();

            prev = lastReturned;
            lastReturned = current;
            current = current.next;
            return lastReturned.data;
        }

        public void remove() {
            if (lastReturned == null)
                throw new IllegalStateException("remove() utan next()");

            if (prev == null) {
                head = current;
            } else {
                prev.next = current;
            }
            size--;
            lastReturned = null;
        }
    }

    public Uppgift3() {
        head = null;
        size = 0;
    }

    public Iterator<E> iterator() {
        return new Ite();
    }

    public boolean add(E item) {
        if (head == null) {
            head = new Node<>(item, head);
        } else {
            Node<E> n = getNode(size - 1);
            n.next = new Node<>(item, null);
        }
        size++;
        return true;
    }

    public boolean add(E item, int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            head = new Node<>(item, head);
        } else {
            Node<E> prev = getNode(index - 1);
            prev.next = new Node<>(item, prev.next);
        }
        size++;
        return true;
    }

    private Node<E> getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(index);

        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) sb.append(" => ");
        }
        sb.append("]");
        return sb.toString();
    }
}






















