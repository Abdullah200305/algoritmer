package lektion8;
public class NB26_3<K,V>{
    private int size;
    private Entry<K,V>[] table;

    public NB26_3(int init) {
        this.size = 0;
        this.table = new Entry[init];
    }

    private static class Entry<K,V> {
        K key;
        V value;
        boolean dummy;

        public Entry(boolean dummy,K key,V value) {
            this.dummy = dummy;
            this.key = key;
            this.value = value;
        }
    }
    public V remove(K key){
        int index = Math.floorMod(key.hashCode(), table.length);
        int start = index;

        while (table[index] != null){
            if (!table[index].dummy && table[index].key.equals(key)){
                table[index].dummy = true;
                size--;
                return table[index].value;
            }
            index = (index + 1) % table.length;
            if (index == start) break;
        }
        return null;
    }

    public V get(K key) {
        int index = Math.floorMod(key.hashCode(), table.length);
        int start = index;

        while (table[index] != null) {
            if (!table[index].dummy && table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + 1) % table.length;
            if (index == start) break;
        }
        return null;
    }

    public V put(K key,V value){
        if (size >= table.length * 0.75) rehash();

        int index = Math.floorMod(key.hashCode(), table.length);
        int start = index;

        while (true) {
            if (table[index] == null || table[index].dummy) {
                table[index] = new Entry<>(false, key, value);
                size++;
                return null; // ny entry
            } else if (table[index].key.equals(key)) {
                V oldValue = table[index].value;
                table[index].value = value;
                return oldValue;
            }

            index = (index + 1) % table.length;
            if (index == start) throw new RuntimeException("Tabellen är full!");
        }
    }
    @SuppressWarnings("unchecked")
    private void rehash(){
        Entry[] old = table;
        table = new Entry[table.length*2];
        size = 0;
        for (int i = 0; i < old.length; i++) {
            if (old[i] != null && !old[i].dummy) {
                Entry<K,V> e = (Entry<K,V>) old[i];
                put(e.key, e.value);
            }
        }

    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            str.append(i+": ");
            if (table[i] != null && !table[i].dummy) {
                str.append("key="+table[i].key+", value="+table[i].value+", dummy="+table[i].dummy);
            }
            str.append("\n");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        NB26_3<String,Integer>hashTabel = new NB26_3<>(1);
        hashTabel.put("cow",10);
        hashTabel.put("run",10);
        hashTabel.put("dow",10);
        System.out.println(hashTabel.toString());
        hashTabel.remove("dow");
        System.out.println(hashTabel.toString());

    }

}
