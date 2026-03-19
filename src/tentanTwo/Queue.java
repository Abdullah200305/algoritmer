package tentanTwo;

public class Queue {
    private int size;
    private Node head;
    private Node tail;
    private class Node{
        private String data;
        private Node next;
        public Node(String data,Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean enqueue(String item){
        if(head==null){
            head = new Node(item,head);
            tail = head;
        }
        else {
           tail.next = new Node(item,null);
           tail = tail.next;
        }
        size++;
        return true;
    }
    public boolean isEmpty(){
        return size==0;
    }
       public String dequeue(){
        if(isEmpty()){
            return null;
        }
        String old = head.data;
        head = head.next;
        size--;
        return old;
    }
    public String peek(){
        return head.data;
    }





}
