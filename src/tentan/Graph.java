package tentan;

public class Graph {
    public static void main(String[] args) {
        int X = Integer.MAX_VALUE;
        int[][] w6 = {{X, 5, X, 3},
                {5, X, 2, 1},
                {X, 2, X, X},
                {3, 1, X, X}};
        System.out.println(Graph.solve(w6));
    }




   static public int solve(int [][]w){
        Boolean[] taken= new Boolean[w.length];
        int[] cost = new int[w.length];
        int[] prev= new int[w.length];
       for (int i = 0; i < cost.length; i++) {
           taken[i]=false;
           cost[i]=Integer.MAX_VALUE;
       }

       cost[0]=0;


       for (int i = 0; i < w.length-1; i++) {
           int u = next(cost,taken);
           for (int j = 0; j < w[u].length; j++) {
               int vikt = w[u][j];

               if(!taken[j]&& vikt!=Integer.MAX_VALUE && cost[j] > cost[u] + vikt){
                   cost[j] = cost[u] + vikt;
                   prev[j] = u;
               }
           }
       }


       for (int i = 1; i < prev.length; i++) {
           System.out.println("Nod "+(char)(i+'A')+" anslöts via "+(char)(prev[i]+'A')+" med vikt:"+cost[i]);
       }
     /*  int sum =0;
       for (int i = 0; i < cost.length; i++) {
           sum += cost[i];
       }*/
        return cost[2];
    }


    private static int next(int[]cost,Boolean[]visit){
        int index= 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < cost.length; i++) {
            if(!visit[i] && cost[i]<min){
                min = cost[i];
                index = i;
            }
        }
        visit[index]= true;
        return index;
    }
}
