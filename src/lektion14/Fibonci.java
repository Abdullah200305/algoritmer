package lektion14;

import java.util.ArrayList;

public class Fibonci {
    static private int a;
    static int[] mem = new int[100];

    static public int Fib(int R){
        if(R==1 || R==2){return 1;}

        int []list = new int[R+1];
        list[1]=1;
        list[2]=1;
        for (int i = 3; i <= R; i++) {
            list[i]=list[i-1]+list[i-2];
        }
        return list[R];

      /*  if (mem[R] != 0) return mem[R];
        a++;
        if(R==1 || R==2){return 1;}

        mem[R]= Fib(R-1)+Fib(R-2);
        return mem[R];*/
    }


    public static void main(String[] args) {
        System.out.println(Fibonci.Fib(40)+" "+a);
    }
}
