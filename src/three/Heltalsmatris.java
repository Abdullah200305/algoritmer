package three;

import java.util.Arrays;

public class Heltalsmatris {
    public static void main(String[] args){

        int[][] maze = {
                {31,32,33,34,37,11,36},
                {32,33,35,26,35,36,39},
                {31,32,13,32,31,37,37},
                {11,39,13,14,15,16,17},
                {18,19,33,32,31,32,33},
                {16,38,21,22,23,24,25}};
        System.out.println(existsPath(maze));
        for (int i = 0; i < mem.length; i++) {
            for (int j = 0; j < mem[i].length; j++) {
                System.out.print(mem[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    private static   int[][]mem = new int[6][7];
    private static int[][] way={ {1,0},
            {0,1},   // höger
            {0,-1}   // vänster
     };
    private static boolean existsPath(int[][] maze) {

        for (int i = 0; i < mem.length; i++) {
            Arrays.fill(mem[i],0);
        }
        return existsPath(maze,0,0,mem);
    }

    private static boolean existsPath(int[][] maze,int row,int col,int[][] mem) {

        if(row < 0 || row >= maze.length || col < 0 || col >= maze[0].length){
            return false;
        }

        // Kontrollera om värdet redan finns i mem (det betyder att vi redan gått på det)
        for(int r = 0; r < maze.length; r++){
            for(int c = 0; c < maze[0].length; c++){
                if(mem[r][c] == maze[row][col]){
                    return false;
                }
            }
        }

        // Målkontroll
        if(row == maze.length-1 && col == maze[0].length-1){
            mem[row][col] = maze[row][col]; // spara sista cell
            return true;
        }

        // Markera nuvarande cell i mem
        mem[row][col] = maze[row][col];

        for (int i = 0; i < 3; i++) {
            int nr = row + way[i][0];
            int nc = col + way[i][1];

            if(existsPath(maze,nr,nc,mem)){
                return true; // om någon riktning leder till mål, behåll cellen
            }
        }

        // Om ingen riktning leder till mål, ta bort markeringen
        mem[row][col] = 0;
        return false;
    }

}
