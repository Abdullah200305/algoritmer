package Redovisning3;



public class Uppgift8 <E extends Comparable<E>> {
    private Node root;
    private class Node{
        private int value;
        private Node left;
        private Node right;
        public Node(int value) {
            this.value = value;
            left=right=null;
        }
    }
    public boolean add(int item){

        if(root==null){
            root=new Node(item);
            return true;
        }
        return add(item,root);
    }
    private boolean add(Integer item,Node node){
        if(item.compareTo(node.value)==0){
            return false;
        } else if (item.compareTo(node.value)>0) {
            // go till höger
            if(node.right!=null){
               return add(item,node.right);
            }
            else {
                node.right = new Node(item);
                return true;
            }
        }
        else {
            // go till väster
            if(node.left!=null){
                return add(item,node.left);
            }
            else {
                node.left = new Node(item);
                return true;
            }
        }
    }

    public Integer getNextLarger(int target){
        return getNextLarger(target,root,null);
    }
    private Integer getNextLarger(int target,Node node,Integer value){
        if(node==null){
            return value;
        }
        if(target<node.value) {
          return   getNextLarger(target,node.left,node.value);
        }
        else {
           return getNextLarger(target,node.right,value);
        }
    }




    public String Inorder(){
        StringBuilder str = new StringBuilder();
        Inorder(root,str);
        return  str.toString();
    }
    private void Inorder(Node node,StringBuilder str){
        if(node!=null){
            Inorder(node.left,str);
            str.append(node.value+" ");
            Inorder(node.right,str);
        }
    }



    public static void main(String[] args) {
        Uppgift8 uppgift8 = new Uppgift8();

        uppgift8.add(5);

        uppgift8.add(2);
        uppgift8.add(1);

        uppgift8.add(8);
        uppgift8.add(12);

        System.out.println(uppgift8.Inorder());
        System.out.println(uppgift8.getNextLarger(7));
        System.out.println(uppgift8.getNextLarger(2));
        System.out.println(uppgift8.getNextLarger(13));


        Uppgift8 uppgift1 = new Uppgift8();
        System.out.println(uppgift1.getNextLarger(3));

    }
}



