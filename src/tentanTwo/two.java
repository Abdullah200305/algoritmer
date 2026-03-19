package tentanTwo;

import java.util.Arrays;

public class two {
/*
    public static void main(String[] args){
        System.out.println(mostStones(new int[]{1, 3, 1, 0, 2, 0, 3, 3, 0, 3, 2, 3, 0, 1}));
        System.out.println(mostStonesDyn(new int[]{1, 3, 1, 0, 2, 0, 3, 3, 0, 3, 2, 3, 0, 1}));
    }*/

    private static int mostStones(int[] stones){
        int[] item = {0,1,2,3};
        return mostStones(stones,0);
    }
    private static int two;
    private static int mostStones(int[] stones,int pos){
        two++;
        if(pos>=stones.length){
            return 0;
        }
        int a= 0;
        for (int i = 0; i <= stones[pos]; i++){
            a= Math.max(i+mostStones(stones,(pos+1+i*2)),a);
        }
        return a;
    }


    private static int mostStonesDyn(int[] stones)
    {
        int[] item = {0,1,2,3};
        int[] mem = new int[stones.length];
        Arrays.fill(mem,-1);
        return mostStonesDyn(stones,0,mem);
    }
    private static int one;
    private static int mostStonesDyn(int[] stones,int pos,int[]mem){
        one++;
        if(pos>=stones.length){
            return 0;
        }
        if( mem[pos]!=-1){
            return  mem[pos];
        }
        int a =0;

        for (int i = 0; i <= stones[pos]; i++){

           a= Math.max(i+mostStonesDyn(stones,pos+1+i*2,mem),a);

        }
        return  mem[pos] =a;
    }


    public static void main(String[] args) {


        System.out.println(mostStones(new int[]{3, 2, 1, 0, 1, 3, 1, 2, 3, 1, 2, 3, 0, 1}));
        System.out.println(two);
        System.out.println(mostStonesDyn(new int[]{3, 2, 1, 0, 1, 3, 1, 2, 3, 1, 2, 3, 0, 1}));
        System.out.println(one);
    }
}
