package lektion11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class NB32 {

    private Map<String, List<Kant>> adjList = new HashMap<>();
    private static class Kant {
        String till;
        int vikt;
        Kant(String till, int vikt) {
            this.till = till;
            this.vikt = vikt;
        }
        @Override
        public String toString() {
            return till + "(" + vikt + ")";
        }
    }

    public NB32(String filnamn) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filnamn));
        String rad;
        while ((rad = br.readLine()) != null) {
            String[] delar = rad.split("\\s+");
            if (delar.length == 0) continue;
            String nod = delar[0];
            List<Kant> kanter = new ArrayList<>();
            for (int i = 1; i < delar.length; i += 2) {
                String granne = delar[i];
                int vikt = Integer.parseInt(delar[i + 1]);
                kanter.add(new Kant(granne, vikt));
            }
            adjList.put(nod, kanter);
        }
        br.close();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String nod : adjList.keySet()) {
            sb.append(nod).append(": ");
            List<Kant> kanter = adjList.get(nod);
            for (Kant k : kanter) {
                sb.append(k).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    public List<String> kortasteVag(String start, String slut) {
        Map<String, Integer> avstand = new HashMap<>();
        Map<String, String> foregaende = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(avstand::get));


        for (String nod : adjList.keySet()) {
            avstand.put(nod, Integer.MAX_VALUE);
        }
        avstand.put(start, 0);
        pq.add(start);

        while (!pq.isEmpty()) {
            String nod = pq.poll();
            if (nod.equals(slut)) break;
            if (adjList.get(nod) == null) continue;
            for (Kant kant : adjList.get(nod)) {
                int nyDist = avstand.get(nod) + kant.vikt;
                if (nyDist < avstand.getOrDefault(kant.till, Integer.MAX_VALUE)) {
                    avstand.put(kant.till, nyDist);
                    foregaende.put(kant.till, nod);
                    pq.remove(kant.till);
                    pq.add(kant.till);
                }
            }
        }
        List<String> vag = new LinkedList<>();
        String steg = slut;
        while (steg != null) {
            vag.add(0, steg);
            steg = foregaende.get(steg);
        }
        if (!vag.get(0).equals(start)) return Collections.emptyList();
        return vag;
    }


    public static void main(String[] args) throws IOException {
        NB32 graf = new NB32("src/lektion11/map.txt");
        System.out.println("Grannlista:\n" + graf);

        List<String> vag = graf.kortasteVag("A", "D");
        System.out.println("Kortaste väg från A till D: " + vag);
    }
}
