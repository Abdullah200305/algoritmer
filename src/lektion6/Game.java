package lektion6;

import java.util.*;

public class Game {

    static char[] goal = {'#','#','#',' ','*','*','*'};
    static List<String> moves = new ArrayList<>();

    public static void main(String[] args) {
        char[] start = {'*','*','*',' ','#','#','#'};
        System.out.println(String.valueOf(start));
        solve(start);
    }

    static boolean solve(char[] board) {


        if (Arrays.equals(board, goal)) {

            System.out.println(String.join(", ", moves));
            for (int i = 0; i < board.length; i++) {
                System.out.print(board[i]);
            }
            return true;
        }

        for (int i = 0; i < board.length; i++) {


            if (board[i] == '*') {
                if (i + 1 < board.length && board[i + 1] == ' ') {
                    if (move(board, i, i + 1)) return true;
                }
                if (i + 2 < board.length && board[i + 2] == ' ') {
                    if (move(board, i, i + 2)) return true;
                }
            }


            if (board[i] == '#') {
                if (i - 1 >= 0 && board[i - 1] == ' ') {
                    if (move(board, i, i - 1)) return true;
                }
                if (i - 2 >= 0 && board[i - 2] == ' ') {
                    if (move(board, i, i - 2)) return true;
                }
            }
        }
        return false;
    }

    static boolean move(char[] board, int from, int to) {
        char temp = board[from];
        board[from] = ' ';
        board[to] = temp;

        moves.add((from + 1) + "->" + (to + 1));

        if (solve(board)) return true;


        moves.remove(moves.size() - 1);
        board[to] = ' ';
        board[from] = temp;

        return false;
    }
}
