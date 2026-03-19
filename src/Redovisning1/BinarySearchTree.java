package Redovisning1;

public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<E> {

        private E data;
        private Node<E> left, right;

        private Node(E d) {
            data = d;
            left = right = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<E> root;

    public BinarySearchTree() {
        root = null;
    }

    private boolean add(E data, Node<E> node) {
        if (data.compareTo(node.data) == 0) {
            return false;
        } else if (data.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new Node<>(data);
                return true;
            } else {
                return add(data, node.left);
            }
        } else if (node.right == null) {
            node.right = new Node<>(data);
            return true;
        } else {
            return add(data, node.right);
        }
    }

    public boolean add(E data) {
        if (root == null) {
            root = new Node<>(data);
            return true;
        } else {
            return add(data, root);
        }
    }

    public int height(){
        return height(root,0);
    }
    private int height(Node<E> node,int antal){
        if(node==null){return antal;};
        return Math.max( height(node.left,antal+1),height(node.right,antal+1));
    }

    public int nrNodesWith2Grandchildren(){
        return nrNodesWith2Grandchildren(root);
    }

    private int nrNodesWith2Grandchildren(Node<E> node){
        if(node==null){
            return 0;
        }

        if(barnBarn(node.left) + barnBarn(node.right) == 2){
          return 1+nrNodesWith2Grandchildren(node.left) + nrNodesWith2Grandchildren(node.right);
        }
        return nrNodesWith2Grandchildren(node.left) + nrNodesWith2Grandchildren(node.right);
    }
    private int barnBarn(Node<E> node){
        if (node==null){return 0;};
        int count = 0;
        if(node.left!=null){ count++; };
        if(node.right!=null){ count++;};
        return count;
    }




}
