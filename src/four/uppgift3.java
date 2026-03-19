package four;

public class uppgift3 {

    private Node head;
    private int size;



    private class Node{
        private String data;
        private Node next;

        public Node(String data,Node next) {
            this.data = data;
            this.next = next;
        }
    }


    public uppgift3() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size==0;
    }
    public boolean push(String item){
        if(head==null){
            head = new Node(item,head);
        }
        else {

            head = new Node(item,head);
        }
        size++;
        return true;
    }

    public String peek(){
        if (isEmpty()){
            return null;
        }
        return head.data;
    }
    public String poll(){
        if (isEmpty()){
            return null;
        }
        String temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

    @Override
    public String toString() {

        Node cu = head;
        for (int i = 0; i < size; i++) {
            System.out.println(cu.data+" f");
            cu = cu.next;
        }
        return null;
    }

    static void main() {
        uppgift3 sss = new uppgift3();
        sss.push("A");
        sss.push("B");
        sss.push("C");
        sss.push("D");


        System.out.println(sss.peek());
    }
}
