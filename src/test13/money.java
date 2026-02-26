package test13;

import java.util.Arrays;

public class money {









    private int belopp[] = {1,2};
    public int[] count = new int[belopp.length];
    public int solv(int sum){
        for (int i = 0; i < belopp.length; i++) {
            if(belopp[i]==sum){

                return 1;}
        }
        int big = 1000000;
        for (int i = 0; i < belopp.length; i++) {
            if(belopp[i]<sum){
                big = Math.min(big,1+solv(sum-belopp[i]));
            }
        }
        return big;
    }

    public static void main(String[] args) {
        money mon = new money();
        System.out.println(mon.solv(4)+" ");
        for (int i = 0; i < mon.count.length; i++) {
            System.out.print(mon.count[i]+" ");
        }

    }
}
