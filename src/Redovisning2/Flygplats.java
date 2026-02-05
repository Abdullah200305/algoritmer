/*
package Redovisning2;



import java.util.*;

public class Flygplats {
    final int TIDSSTEG = 5;
    final int LANDNINGSTID = 20;
    final int STARTTID = 20;
    final double LANDNINGSCHANS = 0.05;
    final double STARTCHANS = 0.05;
    final int STEG_PER_AAR = (365 * 24 * 60) / TIDSSTEG;
    final int SIMULERINGSTEG = 10 * STEG_PER_AAR;

    private int bananTid = 0;  // om bana ledigt
    String paGangTyp = null; // "landning" eller "start"

    private Queue<Integer> StartQueue;
    private Queue<Integer> landQueue;

    List<Integer> landningVantetid = new ArrayList<>();
    List<Integer> startVantetid = new ArrayList<>();

    public Flygplats() {
        StartQueue= new LinkedList<>();
        landQueue= new LinkedList<>();
    }
    public void  run(){
        Random rand = new Random();
        for (int i = 0; i < SIMULERINGSTEG; i++) {
            int nuvarandeTid = i * TIDSSTEG;
            if(rand.nextDouble()<LANDNINGSTID){
                landQueue.offer(nuvarandeTid);
            }

            if(rand.nextDouble()<STARTTID){
                StartQueue.offer(nuvarandeTid);
            }
            if(bananTid==0){
                if(!landQueue.isEmpty()){
                    int ankomstTid = landQueue.poll();
                    landningVantetid.add(nuvarandeTid - ankomstTid);
                    bananTid = LANDNINGSTID;
                    paGangTyp = "landning";
                } else if (!StartQueue.isEmpty()) {
                    int ankomstTid = StartQueue.poll();
                    startVantetid.add(nuvarandeTid - ankomstTid);
                    bananTid = STARTTID;
                    paGangTyp = "start";
                }
            }
            if (bananTid > 0) {
                bananTid -= TIDSSTEG;
                if (bananTid < 0) bananTid = 0;
            }
        }
        // Statistik
        double medelLandning = landningVantetid.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        double medelStart = startVantetid.stream().mapToInt(Integer::intValue).average().orElse(0.0);

        System.out.println("Medelväntetid landning: " + medelLandning + " min");
        System.out.println("Medelväntetid start: " + medelStart + " min");
    }
}
*/



package Redovisning2;

import java.util.*;

public class Flygplats {
    // Parametrar
    final int TIDSSTEG = 5;       // minuter per steg
    final int LANDNINGSTID = 20;  // tid för en landning
    final int STARTTID = 20;      // tid för en start
    final double LANDNINGSCHANS = 0.05; // 5% chans per steg
    final double STARTCHANS = 0.05;     // 5% chans per steg

    final int STEG_PER_AAR = (365 * 24 * 60) / TIDSSTEG;
    final int SIMULERINGSTEG = 10 * STEG_PER_AAR; // 10 år

    private int bananTid = 0;      // tid kvar tills banan är ledig
    private String paGangTyp = null; // "landning" eller "start"

    private Queue<Integer> landQueue;
    private Queue<Integer> startQueue;

    private List<Integer> landningVantetid;
    private List<Integer> startVantetid;

    public Flygplats() {
        landQueue = new LinkedList<>();
        startQueue = new LinkedList<>();
        landningVantetid = new ArrayList<>();
        startVantetid = new ArrayList<>();
    }

    public void run() {
        Random rand = new Random();

        for (int steg = 0; steg < SIMULERINGSTEG; steg++) {
            int nuvarandeTid = steg * TIDSSTEG;

            // Nya plan dyker upp
            if (rand.nextDouble() < LANDNINGSCHANS) {
                landQueue.offer(nuvarandeTid);
            }
            if (rand.nextDouble() < STARTCHANS) {
                startQueue.offer(nuvarandeTid);
            }

            // Banan ledig?
            if (bananTid == 0) {
                if (!landQueue.isEmpty()) {
                    int ankomstTid = landQueue.poll();
                    landningVantetid.add(nuvarandeTid - ankomstTid);
                    bananTid = LANDNINGSTID;
                    paGangTyp = "landning";
                } else if (!startQueue.isEmpty()) {
                    int ankomstTid = startQueue.poll();
                    startVantetid.add(nuvarandeTid - ankomstTid);
                    bananTid = STARTTID;
                    paGangTyp = "start";
                }
            }

            // Minska pågående operation
            if (bananTid > 0) {
                bananTid -= TIDSSTEG;
                if (bananTid < 0) bananTid = 0;
            }
        }

        // Statistik
        double medelLandning = landningVantetid.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        double medelStart = startVantetid.stream().mapToInt(Integer::intValue).average().orElse(0.0);

        int maxLandning = landningVantetid.stream().mapToInt(Integer::intValue).max().orElse(0);
        int maxStart = startVantetid.stream().mapToInt(Integer::intValue).max().orElse(0);

        System.out.println("Medelväntetid landning: " +String.format("%.1f", medelLandning)  + " min");
        System.out.println("Medelväntetid start: " + String.format("%.2f", medelStart) + " min");
        System.out.println("Maximal väntetid landning: " + maxLandning + " min");
        System.out.println("Maximal väntetid start: " + maxStart + " min");
    }

    public static void main(String[] args) {
        Flygplats flygplats = new Flygplats();
        flygplats.run();
    }
}

