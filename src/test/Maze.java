package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static java.util.Collections.shuffle;

public class Maze {
    private int row;
    private int col;
    private int[][]map;
    private int path[][]={{0,1},{0,-1},{1,0},{-1,0}};
    private int vist[][];
    public Maze(int col,int row) {
        this.col = col;
        this.row = row;
        this.map = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.map[i][j]=1;
            }
        }
        vist= new int[row][col];
        Generate(0,0);
    }
    public void Generate( int x, int y){
        int[] check = {0, 1, 2, 3};
        this.map[x][y]=0;
        this.vist[x][y]=1;

        Random random = new Random();
        for (int i = check.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = check[i];
            check[i] = check[j];
            check[j] = temp;
        }

        for (int i = 0; i < 4; i++) {
            int dx =path[check[i]][1]*2;
            int dY =path[check[i]][0]*2;
            int nyx = dx+x;
            int nyY = dY+y;
            if(nyY>=0&&nyY<row &&
                    nyx>=0&&nyx<col){
                if(map[nyx][nyY]!=0){
                    map[x + dx/2][y + dY/2] = 0;
                    Generate(nyx,nyY);
                }
            }
        }

    }






    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                str.append(map[i][j]);
            }
            str.append("\n");
        }
        return str.toString();
    }
}
