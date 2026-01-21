package lektion3;

import java.util.EmptyStackException;

public class MyStackLink<E> implements Stack<E> {
    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }
    private Node<E> top;
    public MyStackLink() {
        top = null;
    }
    @Override
    public E push(E obj) {
        top = new Node<E>(obj, top);
        return obj;
    }
    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            E result = top.data;
            top = top.next;
            return result;
        }
    }
    @Override
    public int size() {
        int count =0;
        Node<E> current = top;
        while(current!=null){
            count++;
            current  = current.next;
        }
        return count;
    }
    @Override
    public E peek(int n) {
        if (n < 0 || n >= size()) {
            throw new IndexOutOfBoundsException(n);
        }
        Node<E> current = top;
        for (int i = 0; i < n; i++) {
            current = current.next;
        }
        return current.data;
    }
    @Override
    public E flush(){
            if (top == null) {
                return null;
            }
            E last = top.data;
            top = null;
            return last;
    }
    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            return top.data;
        }
    }
    @Override
    public boolean empty() {
        return top == null;
    }
    public static void main(String[] args) {
        Stack<String> list = new MyStackLink<>();
        list.push("superman");
        list.push("run");
        list.push("batman");
        System.out.println(list.peek(1));
        System.out.println(list.peek(2));
        System.out.println(list.flush());
        System.out.println(list.peek());
        System.out.println(list.peek());
    }
}
