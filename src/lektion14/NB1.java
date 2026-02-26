package lektion14;

import java.util.ArrayList;

public class NB1 {

    static private int a;
    static  private ArrayList<Integer> DP = new ArrayList<>();
   static public int solve(int[][]tri,int posX,int posY){

    /*   if(DP.contains(tri[posX][posY]+tri[posX][posY])){
           return tri[posX][posY]+tri[posX][posY];
       }*/
       a++;
       if (posX == tri.length - 1) {
           return tri[posX][posY];
       }
       int left = solve(tri, posX + 1    , posY);
       int right = solve(tri, posX + 1, posY + 1);

        DP.add(0,tri[posX][posY] + Math.max(left, right));
       return DP.get(0);
    }
    public static void main(String[] args) {
        int[][] tri = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        System.out.println(NB1.solve(tri,0,0));
        System.out.println(a);

    }
}
