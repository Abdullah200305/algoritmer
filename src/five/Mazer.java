package five;

import java.util.Arrays;

public class Mazer {

    public static void main(String[] args) {
      /*   int[][] matrix = {
                {1,2,4},
                {2,4,3},
                {6,7,8}};*/
        int[][] matrix = {
                {1,5,4,7,8,3,1},
                {2,6,3,4,7,1,5},
                {3,5,1,9,1,7,1},
                {1,3,1,4,5,8,2},
                {3,1,8,3,1,2,1}};
        System.out.println(maxSum(matrix,1));
        System.out.println(a);
    }



    private static int a=0;
    private static int maxSum(int[][] matrix, int startCol) {
        int[][] mem = new int[matrix.length][matrix[0].length];

        return maxSum(matrix,startCol,0,mem);
    }
    private static int maxSum(int[][] matrix, int col,int row,int [][]mem){
        int[] path = {-1,0,1};
        a++;
     /*   if( mem[row][col]!=0){
            return    mem[row][col];
        }*/
        if(row==matrix.length-1){return matrix[row][col];}

        int way = 3;
        int start =0;
        if(col==0){
            start=1;
        }
        if(col==matrix[0].length-1){
            way=2;
        }
        int max = -1;
        for (int i = start; i < way; i++) {
            int NyX = path[i]+col;
            int NyY = row+1;
            max = Math.max(max,matrix[row][col]+maxSum(matrix,NyX,NyY,mem));
        }
        mem[row][col] = max;
        return max;
    }
}
