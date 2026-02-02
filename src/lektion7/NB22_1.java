package lektion7;


import lektion6.BollsBoxBredd;

import java.util.ArrayDeque;
import java.util.Queue;

public class NB22_1<E extends Comparable<E>> {
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
    public NB22_1() {
        this.root = null;
    }
    public boolean add(E item){
        if(root==null){
            root = new Node<>(item);
            return true;
        }
        return add(item,root);
    }
    private boolean add(E item,Node<E> node){
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

    private class State{
        private Node<E> position;
        private int anInt;
        public State(Node<E> position,int anInt){
            this.position = position;
            this.anInt = anInt;
        }
    }
    private void toString(Node<E> node, StringBuilder sb){
        if (node == null) return;

        Queue<State> list = new ArrayDeque<>();
        State state = new State(node, 0);

        list.offer(state);
        int currentLevel = 0;
        while (!list.isEmpty()) {
            state = list.poll();
            if (state.anInt > currentLevel) {
                sb.append("\n");
                currentLevel = state.anInt;
            }
            if (state.position == null) {
                sb.append("null ");
            } else {
                sb.append(state.position.data).append(" ");
                list.offer(new State(state.position.left, state.anInt + 1));
                list.offer(new State(state.position.right, state.anInt + 1));
            }

        }
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        toString(root,sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        NB22_1<Character> tree = new NB22_1<>();

        tree.add('H');
        tree.add('B');
        tree.add('N');
        tree.add('A');
        tree.add('E');
        tree.add('C');
        tree.add('F');
        tree.add('D');
        System.out.println(tree.toString());
    }

}
