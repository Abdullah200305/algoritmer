package five;



import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<E>{
        private E data;
        private Node<E> left,right;
        private Node(E d){
            data=d;
            left=right=null;
        }
        @Override
        public String toString(){
            return data.toString();
        }
    }

    private Node<E> root;

    public BinarySearchTree(){
        root=null;
    }

    private String toString(Node<E> node){
        if(node!=null){
            return toString(node.left) + node + " " + toString(node.right);
        }
        return "";
    }

    @Override
    public String toString(){
        return toString(root);
    }

    private boolean add(E data,Node<E> node){
        if(data.compareTo(node.data)==0)
            return false;
        else if(data.compareTo(node.data)<0)
            if(node.left==null){
                node.left = new Node<>(data);
                return true;
            }else
                return add(data,node.left);
        else
        if(node.right==null){
            node.right = new Node<>(data);
            return true;
        }else
            return add(data,node.right);
    }
    public boolean add(E data){
        if(root==null){
            root = new Node<>(data);
            return true;
        }else{
            return add(data,root);
        }
    }
    private class State<E>{
        private E data;
        private Node<E> node;

        public State(E data,Node<E> node) {
            this.data = data;
            this.node = node;
        }

        public Node<E> getNode() {
            return node;
        }

        public E getData() {
            return data;
        }
    }

    public String widthFirstString(){
        if(root==null){
            return null;
        }
        Queue<State<E>> qu = new ArrayDeque<>();
        State<E> state = new State<>(root.data,root);
        qu.offer(state);
        StringBuilder str = new StringBuilder();

        while(!qu.isEmpty())
        {
            State<E> cu = qu.poll();
            str.append(cu.getData()+" ");
            if(cu.getNode().left!=null){
                qu.offer(new State<>(cu.getNode().left.data,cu.getNode().left));
            }
            if(cu.getNode().right!=null){
                qu.offer(new State<>(cu.getNode().right.data,cu.getNode().right));
            }

        }
            return str.toString();
    }

    public static void buildTree(BinarySearchTree<Integer> b, int[] v){
        for(int data:v)
            b.add(data);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        System.out.println(bst.widthFirstString());
        buildTree(bst,new int[] {4,2,6,1,3,5,7});
        System.out.println(bst.widthFirstString());
        bst = new BinarySearchTree<>();
        buildTree(bst,new int[] {20,10,30,5,15,25,35,2,7,13,17,27,33,37,1,4,11,14,31,34,36,45,3,6,8,9});
        System.out.println(bst.widthFirstString());
    }

}
