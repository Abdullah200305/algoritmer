package lektion4;

public class LinkadListQueue<E> {
    private class Node<E>{
        private E data;
        private Node next;
        public Node(E data,Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node head;
    private Node tail;
    private int size;

    public LinkadListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean offer(E item) {
        Node<E> newNode = new Node<>(item, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }
    public E poll(){
        if (size==0){
            throw new IllegalArgumentException("Is empty");
        }
        E data = (E) head.data;
        head = head.next;
        size--;
        return data;
    }
    public E peek(){
        return (E) head.data;
    }

    public int Size() {
        return size;
    }

    @Override
    public String toString() {
        if (head == null) return "[]";
        StringBuilder str = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            str.append(current.data);
            if (current.next != null) str.append(" -> ");
            current = current.next;
        }
        return str.toString();
    }
    public static void main(String[] args) {
        LinkadListQueue<Integer>list = new LinkadListQueue<>();
        list.offer(10);
        list.offer(20);
        list.offer(30);
        System.out.println(list.peek());
        System.out.println(list.toString());
        list.poll();
        list.poll();
        System.out.println(list.peek());
        list.poll();
        System.out.println(list.Size());
        System.out.println(list.toString());

    }

}
