package test;

import java.util.ArrayList;

public class MST {
    private int X = Integer.MAX_VALUE;
    private int res=0;
    private int[][] w = {
            {X, 3, 4, 5, 6},
            {3, X, 6, 5, 6},
            {5, 5, X, 3, 2},
            {4, 6, 3, X, 4},
            {6, 6, 2, 4, X}
    };







    public int LowerCost() {
        int result = 0;
        boolean[] visited = new boolean[5];
        visited[0] = true;
        ArrayList<Integer> vistList = new ArrayList<>();
      /*  vistList.add(start);*/
      while (vistList.size()<w.length){
            int u = next(visited, vistList);


            vistList.add(u);
            visited[u] = true;
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 5; i++){
            str.append("Nod " + (char) (vistList.get(i) + 'A')+" ");

        }
        System.out.println(vistList.toString());

        System.out.println(str.toString()+" "+res);
        return result;
    }
    private int next(boolean[]taken, ArrayList<Integer> vistList){
        int min=Integer.MAX_VALUE;
        int index =0;
       for (int i:vistList){
            for (int j = 0; j < 5; j++) {
                if(!taken[j]&& min>w[i][j]){
                    min=w[i][j];
                    index=j;
                }
            }

        }
        if(min!=Integer.MAX_VALUE){
            res+=min;
        }
        return index;
    }

}
