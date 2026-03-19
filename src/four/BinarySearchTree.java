package four;

public class BinarySearchTree<E extends Comparable<E>> {
    private static class Node<E>{
        private E data;
        private Node<E> left,right;
        private Node(E data){
            this.data=data;
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

  /*  public int height(){
        return height(root);
    }
    private int height(Node node){
        if(node==null){
            return 0;
        }
        int a= 1+height(node.left);
        int b= 1+height(node.right);
        return Math.max(a,b);
    }*/
    public static void main(String[] args){

        BinarySearchTree<String> bst = new BinarySearchTree<>();
        buildTree(bst,new String[] {"H", "B", "N", "A", "E", "C", "F", "D", "P", "M"});

        System.out.println(bst.height("Z"));
        System.out.println(bst.siblings("A","E"));

    }

    private static void buildTree(BinarySearchTree<String> bst, String[] strings) {
        for(String data:strings) bst.add(data);
    }

    public int height(E data){
        Node<E> current = next(root,data);
        System.out.println(current);
        return height(current);
    }
    private Node<E> next(Node<E> node,E data){
            if(node==null){
                return null;
            }
        if(node.data.compareTo(data)==0){
                return node;
            }
            else if(node.data.compareTo(data)>0){
                return next(node.left,data);
            }
           return next(node.right,data);
    }
    private int height(Node<E> node){
        if(node==null){
            return 0;
        }
        int a= 1+height(node.left);
        int b= 1+height(node.right);
        return Math.max(a,b);
    }



    public boolean siblings(E data1, E data2){
        return siblings(data1,data2,root);
    }
    private boolean siblings(E data1, E data2,Node<E> node){
        if(node==null){
            return false;
        }
        if(data1.compareTo(node.data)>0){
            return siblings(data1,data2,node.left);
        }
        else if(data1.compareTo(node.data)<0){
            return siblings(data1,data2,node.left);
        }

        if(siblings(data1,data2,node.left)){return true;};
        if(siblings(data1,data2,node.right)){return true;};
        return false;
    }
}
