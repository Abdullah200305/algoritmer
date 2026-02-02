package lektion7;

public class NBNB23_1<E extends Comparable<E>> {
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
    public NBNB23_1(){
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

    public E maxRec(){
        return maxRec(root);
    }
    private E maxRec(Node<E> node){
        if(node==null){
            return null;
        }

        E leftMax = maxRec(node.left);
        E rightMax = maxRec(node.right);

        E max = node.data;

        if (leftMax != null && leftMax.compareTo(max) > 0) {
            max = leftMax;
        }
        if (rightMax != null && rightMax.compareTo(max) > 0) {
            max = rightMax;
        }
        return max;
    }


    public static void main(String[] args) {
        NBNB23_1<Character> tree = new NBNB23_1<>();
        tree.add('H');
        tree.add('B');
        tree.add('N');
        tree.add('A');
        tree.add('E');
        tree.add('C');
        tree.add('F');
        tree.add('D');
        System.out.println(tree.maxRec());
    }

}
