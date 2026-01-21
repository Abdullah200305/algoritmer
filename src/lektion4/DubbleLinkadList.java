package lektion4;

public class DubbleLinkadList<E>{
    private class Node<E>{
        private Node next;
        private Node prev;
        private E data;
        public Node(Node next,Node prev,E data){
            this.data=data;
            this.next=next;
            this.prev=prev;
        }
    }
    private Node<E> head;
    private Node<E> tail;
    private int size;
    public DubbleLinkadList(){
        head = null;
        tail = null;
        size = 0;
    }
    public boolean offerFirst(E item){
        if(head == null){
            Node<E> newNode = new Node<>(null,null,item);
            tail = newNode;
            head = newNode;
        }
        else {
            Node<E> newNode =new Node<>(head, null,item);
            head = newNode;
            System.out.println(head.next.data);
        }
        size++;
        return true;
    }
    public E pollFirst(){
        if(isEmpty()){
            throw new IllegalArgumentException("is empty");
        }
        E data = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return data;
    }

    public boolean offerLast(E item){
        if (head == null){
            Node<E> newNode = new Node<>(null,null,item);
            tail = newNode;
            head = newNode;
        }
         else {
            Node<E> newNode =new Node<>(null, tail,item);
            tail.next = newNode;
            tail = newNode;
        }
         size++;
        return true;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public E pollLast(){
        if(isEmpty()){
            throw new IllegalArgumentException("is empty");
        }
        E data = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return data;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        Node current  = head;

        while (current!=null){
            str.append(current.data);
            if(current.next!=null){
                str.append("->");
            }
            current = current.next;
        }
        return str.toString();
    }
    public static void main(String[] args) {
        DubbleLinkadList<Integer> list = new DubbleLinkadList<>();
        list.offerFirst(10);
        list.offerFirst(20);
        list.offerFirst(30);
        list.offerLast(50);
        System.out.println(list.toString());

    }
}
