package lektion11;

import java.util.*;

public class PrimGrannlista {
    private static class Kant {
        String nod;
        int vikt;

        Kant(String nod, int vikt) {
            this.nod = nod;
            this.vikt = vikt;
        }
    }

    public static List<String> prim(Map<String, List<Kant>> graf, String start, Map<String, String> parentMap) {
        Set<String> mstSet = new HashSet<>();
        Map<String, Integer> key = new HashMap<>();

        for (String nod : graf.keySet()) {
            key.put(nod, Integer.MAX_VALUE);
            parentMap.put(nod, null);
        }
        key.put(start, 0);

        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(key::get));
        pq.add(start);

        List<String> ordning = new ArrayList<>();

        while (!pq.isEmpty()) {
            String u = pq.poll();
            if (mstSet.contains(u)) continue;
            mstSet.add(u);
            ordning.add(u);

            for (Kant kant : graf.getOrDefault(u, Collections.emptyList())) {
                String v = kant.nod;
                int vikt = kant.vikt;
                if (!mstSet.contains(v) && vikt < key.get(v)) {
                    key.put(v, vikt);
                    parentMap.put(v, u);
                    pq.remove(v);
                    pq.add(v);
                }
            }
        }

        return ordning;
    }



    public static void main(String[] args) {
        Map<String, List<Kant>> graf = new HashMap<>();
        graf.put("A", Arrays.asList(new Kant("B", 2), new Kant("F", 1)));
        graf.put("B", Arrays.asList(new Kant("A", 2), new Kant("C", 2), new Kant("D", 2), new Kant("E", 4)));
        graf.put("C", Arrays.asList(new Kant("B", 2), new Kant("E", 3), new Kant("H", 1)));
        graf.put("D", Arrays.asList(new Kant("B", 2), new Kant("F", 1), new Kant("E", 4)));
        graf.put("E", Arrays.asList(new Kant("B", 4), new Kant("C", 3), new Kant("D", 4), new Kant("H", 2)));
        graf.put("F", Arrays.asList(new Kant("A", 1), new Kant("D", 1), new Kant("G", 5)));
        graf.put("G", Arrays.asList(new Kant("F", 5), new Kant("H", 6)));
        graf.put("H", Arrays.asList(new Kant("C", 1), new Kant("E", 2), new Kant("G", 6)));

        String start = "A";
        Map<String, String> parentMap = new HashMap<>();
        List<String> ordning = prim(graf, start, parentMap);

        System.out.println("Node " + start + " var startnod");
        int totalVikt = 0;


        String[] outputOrder = {"F","D","B","C","H","E","G"};
        for (String nod : outputOrder) {
            String parent = parentMap.get(nod);
            int vikt = graf.get(nod).stream()
                    .filter(k -> k.nod.equals(parent))
                    .map(k -> k.vikt)
                    .findFirst()
                    .orElse(0);
            totalVikt += vikt;
            System.out.println("Nod " + nod + " anslöts till " + parent);
        }

        System.out.println("TotalVikt: " + totalVikt);
    }
}
