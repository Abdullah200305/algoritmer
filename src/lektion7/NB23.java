package lektion7;

public class NB23<E extends Comparable<E>>{
    private class Node<E>{
        private E data;
        private Node<E> left,right;

        public Node(E data) {
            this.data = data;
            left=null;
            right=null;
        }
        @Override
        public String toString(){
            return data.toString();
        }
    }
    Node<E> root;
    public NB23(){
        this.root = null;
    }
    public boolean add(E item){
        if(root==null){
            root = new Node<>(item);
            return true;
        }
        return add(item,root);
    }
    private boolean add(E item, Node<E> node){
        if(item.compareTo(node.data)==0){
            return false;
        } else if (item.compareTo(node.data)>0) {
            if(node.right==null){
                node.right = new Node<>(item);
                return true;
            }
            else {
                return add(item,node.right);
            }
        }
        else {
            if(node.left==null){
                node.left = new Node<>(item);
                return true;
            }
            else {
                return add(item,node.left);
            }
        }
    }




    public int numberOfLeaves(Node<E> node){
        if(node==null){
            return 0;
        }
        if (node.left == null && node.right == null) return 1;
        return numberOfLeaves(node.left) + numberOfLeaves(node.right);
    }
    public int numberOfLeaves(){
        return numberOfLeaves(root);
    }

    public int numberOfNodes(Node<E> node){
        if(node==null){
            return 0;
        }
        return 1 + numberOfNodes(node.left) + numberOfNodes(node.right);
    }
    public int numberOfNodes(){
        return numberOfNodes(root);
    }
    public int height(){
        return height(root,0);
    }
    public int height(Node<E> node,int count){
        if(node==null){
            return 0;
        }
        if (node.left == null && node.right == null) return count-1;
        int res = Math.max(height(node.left,count+1) , height(node.right,count+1));
        return res;
    }

    public static void main(String[] args) {
        NB23<Character> tree = new NB23<>();


        tree.add('H');
        tree.add('B');
        tree.add('N');
        tree.add('A');
        tree.add('E');
        tree.add('C');
        tree.add('F');
        tree.add('D');
        System.out.println(tree.numberOfLeaves());
        System.out.println(tree.numberOfNodes());
        System.out.println(tree.height());
    }
}


