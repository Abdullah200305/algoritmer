package lektion6;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    private ArrayList<Character> list;     // instance variable
    private ArrayList<String> moves;       // stores moves

    private final int size;

    public Game(ArrayList<Character> list){
        this.list = new ArrayList<>(list); // make a copy to avoid external mutation
        this.moves = new ArrayList<>();
        this.size = list.size();
    }

    // Run the backtracking solver
    public boolean run(){
        for (int i = 0; i < list.size(); i++) {

            // Move '0' right
            if(list.get(i) == '0'){
                if(i+1 < size && list.get(i+1) == ' '){
                    if(move(i, i+1)) return true;
                }
                if(i+2 < size && list.get(i+2) == ' '){
                    if(move(i, i+2)) return true;
                }
            }

            // Move '1' left
            if(list.get(i) == '1'){
                if(i-1 >= 0 && list.get(i-1) == ' '){
                    if(move(i, i-1)) return true;
                }
                if(i-2 >= 0 && list.get(i-2) == ' '){
                    if(move(i, i-2)) return true;
                }
            }
        }

        // No move possible, puzzle not solved
        return false;
    }

    // Swap elements and backtrack if needed
    private boolean move(int from, int to){
        // Swap
        char temp = list.get(from);
        list.set(from, list.get(to));
        list.set(to, temp);

        // Record move
        moves.add((from+1) + "->" + (to+1));

        // Recursive call
        if(run()) return true;

        // Backtrack: undo swap
        list.set(from, temp);
        list.set(to, list.get(from)); // fixed swap back

        moves.remove(moves.size()-1);
        return false;
    }

    // Get the list of moves
    public ArrayList<String> getMoves(){
        return moves;
    }

    // Get current state of the list
    public ArrayList<Character> getList(){
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<>(Arrays.asList('0','0','0',' ','1','1','1'));
        System.out.println("Initial list: " + list);

        Game game = new Game(list);
        boolean solved = game.run();
        System.out.println("Solved: " + solved);
        System.out.println("Final list: " + game.getList());
        System.out.println("Moves: " + game.getMoves());
    }
}
