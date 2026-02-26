package test;

public class test {


    int X = Integer.MAX_VALUE;
    int[][] graph = {
            {X,100,1,X},
            {100,X,X,50},
            {1,X,X,1},
            {X,50,1,X}
    };


   /* public void solve(){
        int[] cost = new int[graph.length];
        boolean[]taken = new boolean[graph.length];
        int[]prev = new int[graph.length];

        int infinty = Integer.MAX_VALUE;

        for (int i = 0; i < graph.length; i++) {
            cost[i]=infinty;
            taken[i]=false;
            prev[i]=-1;
        }
        cost[0]=0;


        for (int i = 0; i < graph.length-1; i++) {
            int u = next(cost,taken);
            taken[u]= true;

            for (int j = 0; j < graph[u].length; j++) {
                if(!taken[j]&&graph[u][j]<Integer.MAX_VALUE && cost[j]>graph[u][j]+cost[u]){
                    cost[j]= graph[u][j]+cost[u];
                    prev[j]= u;

                }
            }

        }

        System.out.println("Edge   Weight");
        for (int i = 1; i < graph.length; i++) {
            System.out.println((char)(prev[i]+'A') + " - " +
                    (char)(i+'A') + "   " +
                    graph[prev[i]][i]);
        }
         *//*   for (int i = 1; i < graph.length; i++){
                System.out.println(prev[i] + " - " + i + "\t"
                        + graph[prev[i]][i]);
            }*//*


    }
    private int  next(int[]cost,boolean[]taken){
        int index =-1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < cost.length; i++) {
            if(!taken[i] && min>cost[i]){
                min = cost[i];
                index= i;
            }
        }
       *//* System.out.println(min+" "+index);*//*
        return index;
    }*/
   public int solve (){
       boolean[] visit = new boolean[graph.length];
       int[]cost = new int[graph.length];
       int[]prev = new int[graph.length];

       for (int i = 0; i < graph.length; i++) {
           visit[i]=false;
           cost[i]=Integer.MAX_VALUE;
           prev[i]=-1;
       }
       cost[0]=0;


       while(true){
           int u = next(cost,visit);
           if(u== -1){break;}
           visit[u]=true;

           for (int i = 0; i < graph[u].length; i++) {
               if(graph[u][i]!=Integer.MAX_VALUE&& cost[i]> graph[u][i]){
                   cost[i]= graph[u][i];
                   prev[i] = u;
               }
           }


       }

       System.out.println(cost[1]);
       int count =0;
       for (int i = 1; i < prev.length; i++) {
           System.out.println((char)(i+'A')+" "+(char)(prev[i]+'A'));
       }

       for (int i = 0; i < prev.length; i++) {
           System.out.println(cost[i]);
       }

       System.out.println(count);

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



    public static void main(String[] args) {
        test prim = new test();
        prim.solve();



    }
}
