import lektion5.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     /*  int[]list = new int[10];
        for (int i = 0; i < list.length; i++) {
            list[i]=i;
        }
        System.out.println(NB11.findBiggerTal(list,35,0));
        System.out.println(NB11.findBiggerTal(list,36,0,list.length-1));
       *//* System.out.println(fib(2,3));*/


       /* System.out.println(NB12.calculatePowerTo(4,3));
        System.out.println(NB12.calculatePowerToIterativ(4,3));
*/
/*

        System.out.println(NB13.Rot(9,1,0.0005));
*/


     /*   Scanner scanner = new Scanner(System.in);
        System.out.print("Vilken poäng ska uppnås: ");
        int point = scanner.nextInt();
        System.out.println(NB14.cost( 1, point,0));*/
/*

        Scanner scanner = new Scanner(System.in);
        System.out.print("Vilken poäng ska uppnås: ");
        int point = scanner.nextInt();
        System.out.println("Poängen kan nås med "+NB14.cost( 1, point) +" kronor");
*/


        System.out.println(NB15.run("1011"));

    }
    static int fib(int first,int sec) {
      if(sec==0 && first==0){
          return 1;
      }
      int antal =0;
      if(first>0){
          antal = fib(first-1,sec);
      }
      if(sec>0){
          antal += fib(first,sec-1);
        }
      return antal;
    }


}








