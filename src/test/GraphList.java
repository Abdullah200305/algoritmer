package test;

import java.util.ArrayList;

public class GraphList {

    private ArrayList<Node>[] Noder;

    private class Node {
        private int vikt;
        private int till;

        public Node(int till, int vikt) {
            this.till = till;
            this.vikt = vikt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "till=" + till +
                    ", vikt=" + vikt +
                    '}';
        }
    }

    public GraphList() {
        Noder = new ArrayList[4];
        for (int i = 0; i < Noder.length; i++) {
            Noder[i] = new ArrayList<>();
        }
    }

    public boolean add(int i, int till, int vikt) {
        Noder[i].add(new Node(till, vikt));
        return true;
    }
    private int X = Integer.MAX_VALUE;
    int[][] w = {
            {X, 1, 4, X},  // A
            {1, X, 2, 5},  // B
            {4, 2, X, 1},  // C
            {X, 5, 1, X}   // D
    };

    public int solve (){
        boolean[] visit = new boolean[w.length];
        int[]cost = new int[w.length];
        int[]prev = new int[w.length];

        for (int i = 0; i < w.length; i++) {
            visit[i]=false;
            cost[i]=Integer.MAX_VALUE;
            prev[i]=-1;
        }
        cost[0]=0;


        while(true){
            int u = next(cost,visit);
            if(u== -1){break;}
            visit[u]=true;

            for (int i = 0; i < w[u].length; i++) {
                if(w[u][i]!=Integer.MAX_VALUE&& cost[i]> cost[u]+w[u][i]){
                    cost[i]= cost[u]+w[u][i];
                    prev[i] = u;
                }
            }


        }
        System.out.println(cost[3]);
        int tar = 0;
        for (int i = 0; i < prev.length; i++) {
            System.out.println((char)(i+'A')+" "+(char)(prev[i]+'A'));
        }

        return 0;
    }
    private int next(int[] cost,boolean[] visit){
        int index = -1;
        int lessCost = Integer.MAX_VALUE;
        for (int i = 0; i < cost.length; i++) {
            if(!visit[i] &&lessCost>cost[i]){
                lessCost = cost[i];
                index = i;
            }
        }
        return index;
    }


/*
    public int solve (){
        boolean[] visit = new boolean[Noder.length];
        int[]cost = new int[Noder.length];
        int[]prev = new int[Noder.length];

        for (int i = 0; i < Noder.length; i++) {
            visit[i]=false;
            cost[i]=Integer.MAX_VALUE;
            prev[i]=0;
        }
        cost[0]=0;


        while(true){
            int u = next(cost,visit);

            if(u== -1){break;}
            visit[u]=true;

            for (int i = 0; i < Noder[u].size(); i++) {
                Node e = Noder[u].get(i);
                int v = e.till;

                if (cost[v] > cost[u] + e.vikt) {
                    cost[v] = cost[u] + e.vikt;
                    prev[v] = u;
                }
            }


        }
        int k =3;
        for (int i = 0; i < prev.length-1; i++) {
            System.out.print((char)(k + 'A')+" ");
            k = prev[k];
        }

        return 0;
    }
    private int next(int[] cost,boolean[] visit){
        int index = -1;
        int lessCost = Integer.MAX_VALUE;
        for (int i = 0; i < cost.length; i++) {
            if(!visit[i] &&lessCost>cost[i]){
                lessCost = cost[i];
                index = i;
            }
        }
        return index;
    }*/

    public static void main(String[] args) {
        GraphList graphList = new GraphList();
    /*    GraphList graphList = new GraphList();

        graphList.add(0, 1, 2);
        graphList.add(0, 2, 5);

        graphList.add(1, 2, 2);
        graphList.add(1, 3, 1);
        graphList.add(1, 0, 2);

        graphList.add(2, 1, 2);
        graphList.add(2, 0, 5);
        graphList.add(2, 3, 4);

        graphList.add(3, 1, 1);
        graphList.add(3, 2, 4);
*/
        graphList.solve();
    }
}