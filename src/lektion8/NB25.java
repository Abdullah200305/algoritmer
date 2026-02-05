package lektion8;

import java.util.LinkedList;

public class NB25<K, V> {
    private static class Entry<K, V> {

        public K key;
        public V value;

        public Entry(K k, V v) {
            key = k;
            value = v;
        }
    }

    private LinkedList<Entry<K, V>>[] table;
    private int size;
    @SuppressWarnings("unchecked")
    public NB25(int initialSize) {
        table = new LinkedList[initialSize];
        size = 0;
    }

    public V get(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            return null;
        }
        for (Entry<K, V> e : table[index]) {
            if (e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }

    public V put(K key, V value) {
        if (size >= table.length * 0.75) {
            increase();
        }
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        } else {
            V oldValue;
            for (Entry<K, V> e : table[index]) {
                if (e.key.equals(key)) {
                    oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }
        }
        table[index].addFirst(new Entry<>(key, value));
        size++;
        return null;
    }
    @SuppressWarnings("unchecked")
    private void increase() {
        LinkedList<Entry<K, V>>[] oldTable = table;
        table = new LinkedList[oldTable.length * 2];
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null) {
                for (Entry<K, V> e : oldTable[i]) {
                    int index = e.key.hashCode() % table.length;
                    if (index < 0) index += table.length;

                    if (table[index] == null) {
                        table[index] = new LinkedList<>();
                    }
                    table[index].addFirst(e);
                }
            }
        }
    }
    public V remove(K key){
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            return null;
        }
        var it = table[index].iterator();
        while (it.hasNext()) {
            Entry<K, V> e = it.next();
            if (e.key.equals(key)) {
                V oldValue = e.value;
                it.remove();
                return oldValue;
            }
        }
        return null;
    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < table.length; i++) {
            str.append(i).append(": ");

            if (table[i] == null) {
                str.append("null");
            } else {
                for (Entry<K, V> e : table[i]) {
                    str.append("(")
                            .append(e.key)
                            .append(", ")
                            .append(e.value)
                            .append(") ");
                }
            }

            str.append("\n");
        }

        return str.toString();
    }
    public static void main(String[] args) {

        NB25<Integer, String> hash = new NB25<>(4);
        hash.put(0,"one");
        hash.put(1,"two");
        hash.put(2,"three");
        hash.put(3,"Go");
        System.out.println(hash.toString());
        hash.remove(2);
        System.out.println(hash.toString());
    }

}
