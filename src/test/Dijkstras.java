package test;

import java.util.ArrayList;

public class Dijkstras {

    private int X = Integer.MAX_VALUE;
    private int[][] w = { {X, 2, X, X, X, 1, X, X},
            {2, X, 2, 2, 4, X, X, X},
            {X, 2, X, X, 3, X, X, 1},
            {X, 2, X, X, 3, 1, X, X},
            {X, 4, 3, 3, X, X, 7, X},
            {1, X, X, 1, X, X, 5, X},
            {X, X, X, X, 7, 5, X, 6},
            {X, X, 1, X, X, X, 6, X}};




    public int path(){
        boolean[] inT = new boolean[8];
        double[] d = new double[8];
        double infint = Double.POSITIVE_INFINITY;
        for (int i = 0; i < d.length; i++) {
            d[i]=infint;
            inT[i]=false;
        }
        d[0]=0;

        int[] p = new int[8];

        while (true){
           int u = -1;
           double min = Double.POSITIVE_INFINITY;
            for (int i = 0; i < d.length; i++) {
                if(!inT[i] &&d[i]<min){
                    min =d[i];
                    u=i;
                }
            }
            if (u == -1) break;
            inT[u] = true;


            for (int i = 0; i < w[u].length; i++) {
                if(!inT[i] && w[u][i]!=0){
                    int vikt = w[u][i];
                    int granne = i;
                    if(d[u]+vikt<d[granne]){
                        d[granne] = d[u]+vikt;
                        p[granne]=u;
                    }
                }
            }
        }

        for(int i=1; i<d.length;i++)
            System.out.println("Nod "+(char)(i+'A')+" har avstånd "+d[i]+" till nod A via: "+(char)(p[i]+'A'));

        return 0;
    }

    public static void main(String[] args) {
        Dijkstras dijkstras = new Dijkstras();
        dijkstras.path();
    }

}
