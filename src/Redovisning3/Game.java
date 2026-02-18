package Redovisning3;


public class Game {
    private final int row = 5;
    private final int col = 5;
    private int[][] map =  new int[row][col];
    int solutions = 0;

    int[][][] shapes = {
            { {0,0}, {1,0}, {0,1} },
            { {0,0}, {0,1}, {1,1} },
            { {0,0}, {1,0}, {1,1} },
            { {0,0}, {1,0}, {1,-1} }
    };




    public void mapFill(int postionRow,int postionCol){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j]= 0;
            }
        }
        map[postionRow-1][postionCol-1]=1;
        System.out.println(this.toString());
    }



    public int FillRun(){
        AntalSolveTime(0);
        return solutions;
    }
    private void AntalSolveTime(int antal){
        if(antal==8){
            solutions++;
            System.out.println(this.toString());
            return;
        }
        int pos[] = findEmpty();
        if(pos==null)return;
        for (int i = 0; i < 4; i++) {
             if(CanPlace(pos,shapes[i])){
                palce(pos,shapes[i]);
                AntalSolveTime(antal+1);
                remove(pos,shapes[i]);
             }
            }


    }

    private void remove(int[] pos, int[][] shape){
        for (int i = 0; i < shape.length; i++) {
            int nx = pos[1] + shape[i][0];
            int ny = pos[0] + shape[i][1];
            map[ny][nx] = 0;
        }
    }
    private void palce(int[] pos, int[][] shape){

        for (int i = 0; i < shape.length; i++) {
            int nx = pos[1] + shape[i][0];
            int ny = pos[0] + shape[i][1];
            map[ny][nx] = 1;
        }
    }

    private boolean CanPlace(int[] pos, int[][] shape){
        for (int i = 0; i < shape.length; i++) {
            int nx = pos[1] + shape[i][0];
            int ny = pos[0] + shape[i][1];

            if (nx < 0 || nx >= col || ny < 0 || ny >= row) return false;
            if (map[ny][nx] != 0) return false;
        }
        return true;
    }
    private int[] findEmpty(){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(map[i][j]==0){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }





    @Override
    public String toString() {
       StringBuilder show = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                show.append(map[i][j]+" ");
            }
            show.append("\n");
        }
        return show.toString();
    }


    public static void main(String[] args) {
    Game game = new Game();
    game.mapFill(1,3);
    System.out.println(game.FillRun());
    }
}
