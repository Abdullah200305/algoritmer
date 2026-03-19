package tentanTwo;


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

    private void inOrder(Node<E> node, StringBuilder sb){
        if(node!=null){
            inOrder(node.left, sb);
            sb.append(": ").append(node);
            inOrder(node.right, sb);
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        inOrder(root,sb);
        return sb.toString();
    }

    public boolean add(E data){
        if(root==null){
            root = new Node<>(data);
            return true;
        }
        else {
            return add(data,root);
        }
    };
    private boolean add(E data,Node<E> node){
        if(data.compareTo(node.data)==0){
            return false;
        }
        else if(data.compareTo(node.data)<0){
            if(node.left==null){
                node.left = new Node<>(data);
                return true;
            }
            else {
                return add(data,node.left);
            }
        }
        else{
            if(node.right==null){
                node.right = new Node<>(data);
                return true;
            }
            else {
                return add(data,node.right);
            }
        }
    }

    public boolean full(){
        return full(root);
    }
    private boolean full(Node<E> node){
        if(node==null){
            return true;
        }
        if(!full(node.left)){return false;};
        if(!full(node.right)){return false;};

        if(node.right!=null && node.left!=null ||
                node.right==null && node.left==null){
            return true;
        }
        return false;
    }

}