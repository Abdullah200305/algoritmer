package lektion14;

import Redovisning2.Uppgift5;

import java.util.ArrayList;
import java.util.Arrays;

public class BottomUpp {



    public String solve(char[] list){
        char[] re = {'A','B','C','D','E'};
        return solve(list,re,0);
    }
    private String solve(char[] list,char[] re,int antal){

        char[][] DP= new char[list.length][list.length];
        while(true){
            antal++;
            if(list.equals(re)){break;}
            list = b(list);
            list =  s(list);
            System.out.println( Arrays.toString(list));
        }

        return Arrays.toString(list)+" Antal: "+antal;
    }


    private char[] b(char[] list){
        char[] ny = list.clone();
        char temp = ny[1];
        /*    for (int i = 0; i < ny.length; i++) {
            System.out.print(ny[i]+" ");
        }
        System.out.println();*/
        ny[1]= ny[0];
        ny[0]=temp;
         /*   for (int i = 0; i < ny.length; i++) {
            System.out.print(ny[i]+" ");
        }*/
        return  ny;
    }
    private char[] s(char[] list){
        char[] ny = list.clone();
     /*   for (int i = 0; i < ny.length; i++) {
            System.out.print(ny[i]+" ");
        }*/
       /* System.out.println();*/
        for (int i = ny.length-1; i > 0; i--) {
            char t = ny[i];
            ny[i]= ny[i-1];
            ny[i-1]=t;
        }
    /*    for (int i = 0; i < ny.length; i++) {
            System.out.print(ny[i]+" ");
        }*/
        return ny;
    }

    public static void main(String[] args) {
    BottomUpp b = new BottomUpp();
    char[] list = {'B', 'E','C','A','D'};
    b.solve(list);



    }
}
