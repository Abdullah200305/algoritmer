package Redovisning1;


public class uppgiftEtt {



    public int solve(int[][] graph){
        return solve(graph,0,0);
    }
    private static int count =0;
    private int[][] topDown= new int[100][100];
    private int solve(int[][] graph,int x,int y){
        if(topDown[x][y]!=0){
            return topDown[x][y];
        }
        count++;
        if(x==graph.length-1 && y== graph[0].length-1){return graph[x][y];};
        int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE;
        if(x+1< graph.length){
          a= graph[x][y]+solve(graph, x+1, y);
        }
        if(y+1< graph[0].length){
            b= graph[x][y]+solve(graph, x, y+1);
        }
        topDown[x][y] = Math.min(a,b);
        return topDown[x][y];
    }



    public static void main(String[] args) {
        int[][] graph = {
                {4, 3, 8, 7, 2, 7},
                {2, 8, 8, 9, 3, 5},
                {1, 4, 1, 9, 4, 2},
                {2, 8, 3, 9, 5, 9},
                {9, 9, 8, 3, 1, 7},
                {5, 6, 1, 3, 7, 2},
                {9, 2, 2, 5, 6, 3},
                {1, 3, 3, 8, 3, 1},
                {8, 4, 6, 8, 2, 5}
        };

        uppgiftEtt los = new uppgiftEtt();
        System.out.println(los.solve(graph));
        System.out.println(count);
    }


}

