package Redovisning2;

import java.util.*;

public class Uppgift5Bredd {

    static private class State{
        private int antal;
        private String path;
        private ArrayList<Character> list;
        public State(int antal,String path,ArrayList<Character> list){
            this.antal = antal;
            this.path  = path;
            this.list  = list;
        }
    }
    static public String SolveBox(ArrayList<Character> list){
        ArrayList<Character> SolveList = new ArrayList<>(Arrays.asList('A','B','C','D','E'));
        ArrayList<ArrayList<Character>> visited = new ArrayList<>();
        Queue<State> QueueList = new ArrayDeque<>();
        State state = new State(0,"",new ArrayList<>(list));
        QueueList.offer(state);

        int count =0;
        while (!QueueList.isEmpty()){
            state = QueueList.poll();

            if (state.list.equals(SolveList)) {
                return list.toString() + " tar minst " + state.antal +
                        " steg och en lösning är: " + state.path + ".";
            }

            State childS = s(state);
            if(!visited.contains(childS.list)){
                QueueList.offer(childS);
                visited.add(childS.list);
            }
            State childB = b(state);
            if(!visited.contains(childB.list)){
                QueueList.offer(childB);
                visited.add(childB.list);
            }


        }
        return "Ingen lösning hittades.";
    }
    static private State b(State state){
        ArrayList<Character> ny = new ArrayList<>(state.list);
        char temp = ny.get(0);
        ny.set(0,ny.get(1));
        ny.set(1,temp);
        return new State(state.antal+1,state.path.toString()+"b",ny);
    }

    static private State s(State state){
        ArrayList<Character> ny = new ArrayList<>(state.list);
        char temp = ny.remove(ny.size()-1);
        ny.add(0,temp);
        return new State(state.antal+1,state.path.toString()+"s",ny);
    }




    public static void main(String[] args) {

        ArrayList<Character> test = new ArrayList<>(Arrays.asList('B','E','C','A','D'));

        System.out.println(Uppgift5Bredd.SolveBox(test));
    }
}
