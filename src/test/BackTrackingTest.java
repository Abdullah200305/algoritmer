package test;

import java.util.ArrayList;

public class BackTrackingTest{

// hissen
  /*  static public int solve(int max,int upp,int down,int des,int antal,int curent){
        if(des==curent){
            return 0;
        }
        if(antal==13){
            return Integer.MAX_VALUE/2;
        }
        int one=Integer.MAX_VALUE,two=Integer.MAX_VALUE;

        if(max>=curent+upp){
          one=  1+solve(max,upp,down,des,antal+1,curent+upp);
        }
        if(1<=curent-down) {
          two=  1+solve(max,upp,down,des,antal+1,curent-down);
        }

        return Math.min(one,two);
    }*/

 // hissen in BFS
  /*  static public int solve(int max,int upp,int down,int des,int antal,int curent){
        return 0;
    }*/

    private int n =8;
    private int[][] map = new int[n][n];
    private ArrayList<Integer> res = new ArrayList<>();
    public BackTrackingTest() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               map[i][j]=0;
            }
        }
    }

    public String printMap(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                str.append(map[i][j]+" ");
            }
            str.append("\n");
        }
        return str.toString();
    }


    public int solve(int x,int antal){
        if(antal==n){
            System.out.println(printMap());
            return 1;
        }int a=0;
            for (int i = 0; i < n; i++) {
                if(check(x,i)){
                    add(x,i);
                    a+=solve(x+1,antal+1);
                    remove(x,i);
                }
            }
        return a;
    }
    private boolean check(int x,int y){
     // col and row
        for (int i = 0; i < n; i++) {
            if(x<n&&  map[x][i]!=0 && y!=i){
                return false;
            }
            if(y<n&& i!=x &&map[i][y]!=0){
                return false;
            }
        }
        // dignorla
        for (int i = 1; i < n; i++) {
            if(x+i<n && y+i<n &&map[x+i][y+i]!=0 ||
                    x-i>=0 && y-i>=0 &&map[x-i][y-i]!=0 ){
                return false;
            }
            if(x-i>=0 && y+i<n &&map[x-i][y+i]!=0 ||
                    y-i>=0 && x+i<n &&map[x+i][y-i]!=0){
                return false;
            }
        }
        return true;

    }
    private void add(int x,int y){
       map[x][y]=1;
    }
    private void remove(int x,int y){
        map[x][y]=0;
    }






    public static void main(String[] args) {
       /* System.out.println(solve(78,15,8,35,0,1));*/



        BackTrackingTest backTrackingTest = new BackTrackingTest();
        System.out.println(backTrackingTest.printMap());
        System.out.println( backTrackingTest.solve(0,0));




    }

}

