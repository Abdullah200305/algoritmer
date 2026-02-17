package test;

import java.util.ArrayList;

public class ShortestPath {
    private ArrayList<Node>[] Nodes = new ArrayList[5];

    private class Node{
        private int till;
        private int vikt;
        public Node(int till,int vikt) {
            this.till = till;
            this.vikt = vikt;
        }
    }
   // Noder: A=0, B=1, C=2, D=3, E=4

    public ShortestPath() {
        Nodes[0]=new ArrayList<>();
        Nodes[0].add(new Node(1,6));
        Nodes[0].add(new Node(3,1));

        Nodes[1]=new ArrayList<>();
        Nodes[1].add(new Node(3,2));
        Nodes[1].add(new Node(4,2));
        Nodes[1].add(new Node(0,6));

        Nodes[2]=new ArrayList<>();
        Nodes[2].add(new Node(4,5));
        Nodes[2].add(new Node(3,5));

        Nodes[3]=new ArrayList<>();
        Nodes[3].add(new Node(0,1));
        Nodes[3].add(new Node(1,2));
        Nodes[3].add(new Node(2,5));
        Nodes[3].add(new Node(4,1));

        Nodes[4]=new ArrayList<>();
        Nodes[4].add(new Node(3,1));
        Nodes[4].add(new Node(2,5));
        Nodes[4].add(new Node(1,2));
    }

    public int ShortPath(){
/*
        ArrayList<Node> StartNode = Nodes[0];
        ArrayList<Node>[] visited = new ArrayList[5];

        ArrayList<Node>[] T = Nodes.clone();
        ArrayList<Double> D = new ArrayList<>();
        for (ArrayList<Node> node: T){
            D.add(Double.POSITIVE_INFINITY);
        }
        D.set(0,0.0);
        ArrayList<Node> u = new ArrayList<>();
*/

        int n = Nodes.length;

        double[] d = new double[n];
        boolean[] inT = new boolean[n];


        for (int i = 0; i < n; i++) {
            d[i] = Double.POSITIVE_INFINITY;
            inT[i] = false;
        }
        d[0] = 0;
        int[] prevNode = new int[n];
        for (int i = 0; i < n; i++) {
            prevNode[i] = -1; // betyder: ingen föregångare än
        }

        while(true){
            int u = -1;
            double min = Double.POSITIVE_INFINITY;
            for (int v = 0; v < n; v++) {
                if (!inT[v] && d[v] < min) {
                    min = d[v];
                    u = v;
                }
            }
            if (u == -1) break;
            inT[u] = true;


            for (Node granne : Nodes[u]) {
                int v = granne.till;
                int w = granne.vikt;

                if (!inT[v] && d[u] + w < d[v]) {
                    d[v] = d[u] + w;
                    prevNode[v]=u;
                }
            }
        }
        int target = 1;
        StringBuilder path = new StringBuilder();

        int back = target;
        while (back != -1) {
            path.insert(0,back + " -> ");
            back = prevNode[back];
        }

        System.out.println("Path: " + path);
        System.out.println("Distance: " + d[target]);





        return 0;
    }


    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < Nodes.length; i++) {
            for (int j = 0; j < Nodes[i].size(); j++) {
                str.append(i+".Node go to Node: "+Nodes[i].get(j).till+" vikt: "+Nodes[i].get(j).vikt+"\n");
            }
            str.append("\n");
        }

        return str.toString();
    }



}
