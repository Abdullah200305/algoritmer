package tentanEtt;

public class uppgift1 {



    static public int Min(int[][] re){
        StringBuilder stringBuilder = new StringBuilder();
        int a = Min(re,stringBuilder,0,0);
        System.out.println(stringBuilder.toString()+"k ");
        return a;
    }
    static int [][]mem = new int[100][100];
    static int aa;
    static private int Min(int[][] re,StringBuilder antal,int x,int y){
        if(mem[x][y]!=0){
            return mem[x][y];
        }
        aa++;

        if(x==re.length-1 && y==re[0].length-1) return re[x][y];
        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;
        if(x+1<re.length){
            antal.append(re[x][y]);
            a = re[x][y]+Min(re,antal,x+1,y);
        }
        if(y+1<re[0].length){
            antal.append(re[x][y]);
            b = re[x][y]+Min(re,antal,x,y+1);
        }
        mem[x][y]=Math.min(a,b);


        return mem[x][y];
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


        System.out.println(uppgift1.Min(graph));
        System.out.println(aa);


    }
}
