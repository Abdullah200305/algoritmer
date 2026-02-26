package test;

import java.io.File;

public class MyTree <E extends Comparable<E>> {

    private class Node<E> {
        private E data;
        private Node right;
        private Node left;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node root;
    private int size;
    private E deleteItem;

    public MyTree() {
        root = null;
        size = 0;
        deleteItem = null;
    }

    public boolean add(E item) {
        if (root == null) {
            root = new Node<E>(item);
            return true;
        } else {
            return add(item, root);
        }
    }

    private boolean add(E item, Node<E> node) {
        if (node.data.compareTo(item) == 0) {
            return false;
        }
        else if (node.data.compareTo(item) > 0) {
            if (node.left == null) {
                node.left = new Node<>(item);
                return true;
            } else {
               return add(item, node.left);
            }
        }
        else {
            if (node.right == null) {
                node.right = new Node<>(item);
                return true;
            } else {
               return add(item, node.right);
            }
        }
    }


    public E remove(E target){
        root = remove(target,root);
        return deleteItem;
    }

    // om vi har inget subträd kommer ersättas till null
    private Node<E>  remove(E target,Node<E> node){
        if(node==null){
            deleteItem = null;
            return null;
        }else {
            if (target.compareTo(node.data) < 0) {
                node.left = remove(target, node.left);
                return node;
            }
            else if (target.compareTo(node.data) > 0) {
                node.right = remove(target, node.right);
                return node;
            }else {
                deleteItem = node.data;
                 if(node.left== null){
                    return node.right;
                }
                 if(node.right== null){
                    return node.left;
                }
                else {
                    Node<E> moveTo = node.right, parenent = node;
                    if(moveTo.left == null){
                        moveTo.left = node.left;
                        return moveTo;
                    }

                    while (moveTo.left!=null){
                        parenent = moveTo;
                        moveTo=moveTo.left;
                    }
                    parenent.left= moveTo.right;
                    node.data = moveTo.data;
                    return node;
                }
            }
        }
    }



    public void Inorder(Node<E> node,StringBuilder str){
        if(node!=null){
            Inorder(node.left,str);
            str.append(node.data);
            Inorder(node.right,str);

        }
    }
   /* public String Inorder(Node<E> node){
        if(node==null){
            return"";
        }
       if(node.left!=null || node.right!=null){
           return Inorder(node.left)+", "+node.data+", "+Inorder(node.right);
       }
       else {
           return node.data+"";
       }
    }*/

    public String Inorder(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        Inorder(root,str);
        str.append("]");
        return str.toString();
    }











    public void Preorder(Node<E> node,StringBuilder str){
        if(node!=null){
            str.append(node.data);
            Preorder(node.left,str);
            Preorder(node.right,str);
        }
    }
   /* public String Inorder(Node<E> node){
        if(node==null){
            return"";
        }
       if(node.left!=null || node.right!=null){
           return Inorder(node.left)+", "+node.data+", "+Inorder(node.right);
       }
       else {
           return node.data+"";
       }
    }*/

    public E find(E target){
        return (E) find(target,root);
    }
    private E find(E target,Node<E> node){
        if(node!=null){
            if(target.compareTo(node.data)==0){
                return node.data;
            }
            else if(target.compareTo(node.data)<0){
                return (E) find(target, node.left);
            }
            else {
                return (E) find(target, node.right);
            }
        }
       return null;
    }
    public String Preorder(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        Preorder(root,str);
        str.append("]");
        return str.toString();
    }



    public void PostOrder(Node<E> node,StringBuilder str){
        if(node!=null){
            PostOrder(node.left,str);
            PostOrder(node.right,str);
            str.append(node.data);
        }
    }

    public String PostOrder(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        PostOrder(root,str);
        str.append("]");
        return str.toString();
    }
}
