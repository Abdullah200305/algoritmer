/*
package test;

import java.util.LinkedList;

public class MyHashTabell<K,V>{

    private class Node<K,V> {
        private V value;
        private K key;

        public Node(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }
        private LinkedList<Node<K,V>>[] table;

        public MyHashTabell(int size) {
            this.table = new LinkedList[size];
        }

        public V put(K key,V value){
            int index = key.hashCode() % table.length;
            if(index<0){index+=table.length;}
            if(table[index]==null){
                table[index]=new LinkedList<Node<K,V>>();
                table[index].add(new Node<>(key,value));
                return null;
            }
            else {
                V oldValue;
                for (Node<K,V> item: table[index]){
                    if(item.key.equals(key)){
                        oldValue = item.value;
                        item.value = value;
                        return oldValue;
                    }
                    else {
                        oldValue=null;

                    }
                }
                table[index].add(index,new Node<>(key,value));

            }
        }

        @Override
        public String toString(){
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < table.length; i++) {
                str.append(i+": "+table[i].toString());
            }

            return str.toString();
        }

}
*/
