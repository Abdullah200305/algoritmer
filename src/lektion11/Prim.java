package lektion11;
    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

    /**
     *
     * @author bfelt
     */

    public class Prim {



        public static void main(String[] args) {
            int X = Integer.MAX_VALUE;
            int[][] w = {
                    {	X, 2, X, X, X, 1, X, X},
                    {	2, X, 2, 2, 4, X, X, X},
                    {	X, 2, X, X, 3, X, X, 1},
                    {	X, 2, X, X, 4, 1, X, X},
                    {	X, 4, 3, 4, X, X, 7, X},
                    {	1, X, X, 1, X, X, 5, X},
                    {	X, X, X, X, 7, 5, X, 6},
                    {	X, X, 1, X, X, X, 6, X}};
            int[] p = prim(w);
            System.out.println("Node A var startnode");
            for(int i=1; i<p.length;i++)
                System.out.println("Nod "+(char)(i+'A')+" anslöts via "+(char)(p[i]+'A'));
            int distance =0;
            for(int i=1;i<w.length;i++)
                distance+=w[i][p[i]];
            System.out.println("Totalvikt: "+distance);
        }

        public static int minSpanTree(int[][] w, int[] connections){
            int[] p = prim(w);

            System.arraycopy(p,0,connections,0,connections.length);

            int distance =0;
            for(int i=1;i<w.length;i++)
                distance+=w[i][p[i]];

            return distance;
        }

        // w - förbindelsematris, prim returnerar en array p, där p[i] är den nod som noden i anslöts till (i>0)
        private static int[] prim(int[][] w){
            int n = w.length;
            int[] p = new int[n];
            int[] key = new int[n];
            boolean[] mstSet = new boolean[n];


            for (int i = 0; i < n; i++) {
                key[i] = Integer.MAX_VALUE;
                p[i] = -1;
                mstSet[i] = false;
            }
            key[0] = 0;


            for (int count = 0; count < n; count++) {
                int u = minKey(key, mstSet);
                mstSet[u] = true;


                for (int v = 0; v < n; v++) {
                    if (w[u][v] != Integer.MAX_VALUE && !mstSet[v] && w[u][v] < key[v]) {
                        key[v] = w[u][v];
                        p[v] = u;
                    }
                }
            }

            return p;
        }
        private static int minKey(int[] key, boolean[] mstSet) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int v = 0; v < key.length; v++) {
                if (!mstSet[v] && key[v] < min) {
                    min = key[v];
                    minIndex = v;
                }
            }

            return minIndex;
        }



}
