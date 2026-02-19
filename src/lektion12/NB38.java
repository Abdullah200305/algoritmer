package lektion12;

public class NB38 {
    private int cityes;
    private boolean[] visited;
    private int[] TimeCost;
    private int[] Parent;
    private int start;
    private int result;
    private int X = Integer.MAX_VALUE;
  /*  private int graph[][] = new int[][] {
            { X, 2, 3, 1},
            { 2, X, 4, 3},
            { 3, 4, X, 2},
            { 1, 3, 2, X},
    };*/

    private int graph[][] = {
            { X, 4, 2, 7, 3},
            { 4, X, 5, 1, 6},
            { 2, 5, X, 4, 3},
            { 7, 1, 4, X, 2},
            { 3, 6, 3, 2, X}
    };

    public NB38(int cityes,int start){
        this.cityes = cityes;
        TimeCost = new int[cityes];
        visited = new boolean[cityes];
        Parent = new int[cityes];
        this.start = start;

        result=0;
        for (int i = 0; i < cityes; i++) {
            TimeCost[i]=Integer.MAX_VALUE;
            visited[i]=false;
        }
        if(start<0||start>=cityes){
            throw new IllegalArgumentException("out of Journey");
        }
        Parent[0]=-1;
        TimeCost[start]=0;
    }

    public int AntalCost(){
        int current = start;
        for (int i = 0; i < cityes; i++) {
            int u = next(visited,TimeCost);
            visited[u]=true;
            result += TimeCost[u];
            for (int j = 1; j < cityes; j++) {
                int min =Integer.MAX_VALUE;
                if(visited[j]== false&&
                        graph[u][j]<min){
                    min=graph[u][j];
                    TimeCost[j] = min;
                    Parent[j]=u;
                }
            }
            current = u;
        }

        result += graph[current][start];
        Parent[start] = current;




        return result;
    }
    private int next(boolean[]visited,int[]TimeCost){
        int index=-1;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < TimeCost.length; i++) {
            if(!visited[i] && min>TimeCost[i]){
                min=TimeCost[i];
                index=i;
            }
        }
        return index;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();

        int current = start;

        do {
            int next = -1;
            for(int i = 0; i < cityes; i++){
                if(Parent[i] == current){
                    next = i;
                    break;
                }
            }
            if(next == -1) break;
            str.append("Node from: ")
                    .append((char)(current+'A'))
                    .append(" to ")
                    .append((char)(next+'A'))
                    .append(" vikt: ")
                    .append(graph[current][next])
                    .append("\n");
            current = next;

        } while(current != start);

        return str.toString();
    }
    public static void main(String[] args) {
        NB38 nb38=new NB38(5,0);
        System.out.println(nb38.AntalCost()+" \n"+nb38.toString());
    }
}
