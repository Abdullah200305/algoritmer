package Redovisning2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Flygplats {
    final private int tidssteg=5;
    final private int landningsTid=20;
    final private int startsTid=20;
    final private double AtStart_landad=0.05;
    final private int Year = (365*24*60);
    private Queue<Integer> landningQueue;
    private Queue<Integer> startQueue;
    private int landningsbana;  // kommer säga om den är ledig t eller inte
    private int simulering;

    public Flygplats(int years) {
        landningsbana = 0;
        simulering = (years * Year) / tidssteg;
        landningQueue = new LinkedList<>();
        startQueue = new LinkedList<>();
    }
    public void run(){
        Random random = new Random();
        int medvalue_landed = 0;
        int antal_landed = 0;
        int medvalue_start = 0;
        int antal_start = 0;


        int maxLand =0;
        int maxStart =0;

        for (int i = 0; i < simulering; i++) {
            int nuvarandeTid = i * tidssteg;

            if (random.nextDouble() < AtStart_landad) { // för land
                landningQueue.offer(nuvarandeTid);
            }
            if (random.nextDouble() < AtStart_landad) { // för start
                startQueue.offer(nuvarandeTid);
            }

            if(landningsbana==0){
                if(!landningQueue.isEmpty()){
                   landningsbana=landningsTid;
                    int ankomstTid = landningQueue.poll();
                    int vantetid = nuvarandeTid - ankomstTid;
                   medvalue_landed+=  (vantetid);
                   antal_landed++;
                    if (vantetid > maxLand) maxLand = vantetid;
                } else if (!startQueue.isEmpty()) {
                    landningsbana=startsTid;
                    int ankomstTid = startQueue.poll();
                    int vantetid = nuvarandeTid - ankomstTid;
                    medvalue_start+=  (vantetid);
                    antal_start++;
                    if(vantetid > maxStart)maxStart = vantetid;
                }

            }
            if(landningsbana>0){
                landningsbana-=tidssteg;
                if(landningsbana<0)landningsbana=0;
            }
        }
        System.out.println("Typisk medelväntetid för landning: "
                +String.format("%.1f", (double) medvalue_landed /antal_landed)
                +" min och för start "
                +String.format("%.1f", (double) medvalue_start / antal_start)
                +" min.");
        System.out.println("Max landning: " + maxLand+" Max start: "+maxStart);
    }

        public static void main(String[] args) {
            Flygplats flygplats = new Flygplats(10);
            flygplats.run();
        }
}
