package lektion6;
import java.util.ArrayDeque;
import java.util.Queue;


public class BollsBoxBredd {
    private static class State {
        public int white, antal,blue,red;
        public State(int blue,int white,int red, int antal) {
            this.blue = blue;
            this.white = white;
            this.red = red;
            this.antal = antal;
        }

    }
    static public int AntalExchang(int blue,int white,int red,int antal){
        Queue<State> q = new ArrayDeque<>();
        State t = new State(blue,white,red,antal);
        while (!(t.red==t.white&&t.blue==t.white) && t.antal<15){
            if(t.white>0) {
                q.offer(new State(t.blue + 2, t.white - 1, t.red + 4, t.antal + 1));
            }
            if(t.blue>0) {
                q.offer(new State(t.blue-1,t.white+1,t.red+3,t.antal+1));
            }
            if(t.red>0) {
                q.offer(new State(t.blue+1,t.white+5, t.red-1,t.antal+1));
            }
            t = q.poll();
        }
        if(!(t.red==t.white&&t.blue==t.white)){
            return -1;
        }
        return t.antal;
        }

    public static void main(String[] args) {
        System.out.println(BollsBoxBredd.AntalExchang(2,1,3,0));
    }
}

