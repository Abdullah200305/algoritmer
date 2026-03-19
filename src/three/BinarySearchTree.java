/*
package three;

import java.util.LinkedList;
import java.util.Queue;

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

    public boolean complete(){
        Queue<Node<E>> queue = new LinkedList<>();
        boolean foundNull = false;
        queue.offer(root);
        while(!queue.isEmpty()){
            Node<E> currentNode = queue.poll();
            if(currentNode == null){
                foundNull = true;
            }else{
                if(foundNull) return false;
                queue.offer(currentNode.left);
                queue.offer(currentNode.right);
            }
        }
        return true;
    }

    public boolean complete(){
        return complete(root);
    }



    private boolean complete(Node node){
        if(node== null){
            return true;
        }

        if(node.left!= null && node.right==null){
            return true;
        }
        if(!complete(node.left))return false;
        if(!complete(node.right))return false;


        return false;
    }

    public static void main(String[] args){

        BinarySearchTree<String> bst = new BinarySearchTree<>();
        buildTree(bst,new String[] {"B","A","C"});
        System.out.println(bst.complete());
    }

    private static void buildTree(BinarySearchTree<String> bst, String[] strings) {
        for(String data:strings) bst.add(data);
    }

}
*/
