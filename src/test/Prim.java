package test;

public class Prim {
    private  int X = Integer.MAX_VALUE;
   private int graph[][] = new int[][] {
            { X, 2, X, 6, X },
            { 2, X, 3, 8, 5 },
            { X, 3, X, X, 7 },
            { 6, 8, X, X, 9 },
            { X, 5, 7, 9, X }
    };
   private int V = graph.length;


   public void solve(){


       int [] values = new int[V];
       boolean[] visited = new boolean[V];
       int[] parent = new int[V];
       for (int i = 0; i < values.length; i++) {
           values[i]=Integer.MAX_VALUE;
           visited[i]=false;
       }
       values[0]=0;

       for (int i = 0; i < V; i++) {
           int u = next(visited,values);
           visited[u]=true;


           for (int j = 0; j < V; j++) {
               if(visited[j]== false&&
                  graph[u][j]<values[j]){
                   parent[j] = u;
                   values[j] = graph[u][j];

               }
           }
       }
       printMST(parent, graph);
    }
    void printMST(int parent[], int graph[][])
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < graph.length; i++)
            System.out.println(parent[i] + " - " + i + "\t"
                    + graph[parent[i]][i]);
    }
    private int next( boolean[] visited, int [] values){
       int min = Integer.MAX_VALUE;
       int min_index = -1;
        for (int i = 0; i < V; i++) {
            if(!visited[i] && values[i]<min){
                min=values[i];
                min_index=i;
            }
        }
       return min_index;
    }
}
