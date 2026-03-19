package four;

import java.util.ArrayDeque;
import java.util.Queue;

public class DDD {
    public static void main(String[] args) {
        System.out.println(minStepsWidthC(   70));

     /*   System.out.println(minNrOfStepsB(70));
        System.out.println(minStepsWidthC(70));*/
    }
/*

    private static int s=0;
    private static int[] mem = new int[624];
    private static int minNrOfStepsA(int position){
        s++;
        if(position<1){
            return Integer.MAX_VALUE/2;
        }
        if( mem[position]!=0){
            return  mem[position];
        }
        if(position==1){return 0;}



       int  d=  minNrOfStepsA(position-7);
        if(position%7 == 0){
           d=  Math.min(minNrOfStepsA(position-20),d);
        }
        if(position%5 == 0){
            d=  Math.min(minNrOfStepsA(position-16),d);
        }
        if(position%2 == 0){
            d=  Math.min(minNrOfStepsA(position/2),d);
        }



        return  mem[position]= d+1;

    }*/
    private static class State{
        private int postion;
        private int steg;

    public State(int postion,int steg) {
        this.postion = postion;
        this.steg = steg;
    }


}
    private static int minStepsWidthC(int position) {
        Queue<State> que = new ArrayDeque<>();
        State st = new State(position,0);
        que.offer(st);


        while (!que.isEmpty()){


            State current = que.poll();
            if(current.postion==1){
                return current.steg;
            }
            que.offer(new State(current.postion-7,current.steg+1));
            if(current.postion%7 == 0){
                que.offer(new State(current.postion-20,current.steg+1));
            }
            if(current.postion%5 == 0){
                que.offer(new State(current.postion-16,current.steg+1));
            }
            if(current.postion%2 == 0){
                que.offer(new State(current.postion/2,current.steg+1));
            }
        }
        return -1;

    }
}
