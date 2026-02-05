package lektion8;
import java.util.Iterator;
import java.util.LinkedList;

public class NB24<K, V> {
        private static class Entry<K, V> {

            public K key;
            public V value;

            public Entry(K k, V v) {
                key = k;
                value = v;
            }
        }

        private LinkedList<Entry<K, V>>[] table;

        @SuppressWarnings("unchecked")
        public NB24(int initialSize) {
            table = new LinkedList[initialSize];
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
            return null;
        }

        public V remove(K key){
            int index = key.hashCode() % table.length;
            if (index < 0) {
                index += table.length;
            }
            if (table[index] == null) {
                return null;
            }
            Iterator it = table[index].iterator();
            while (it.hasNext()) {
                Entry<K, V> e = (Entry<K, V>) it.next();
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

        NB24<Integer, String> hash = new NB24<>(4);
        hash.put(0,"apple");
        hash.put(1,"Run");
        hash.put(2,"Done");
        hash.put(3,"Go");
        System.out.println(hash.toString());
        hash.remove(2);
        System.out.println(hash.toString());
    }

}
