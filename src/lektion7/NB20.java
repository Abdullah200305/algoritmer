package lektion7;

import org.w3c.dom.Node;

public class NB20 {
        private int n;
        private int[] pos;   // pos[row] = column
        private int count = 0;

        public NB20(int n) {
            this.n = n;
            pos = new int[n];
        }

        public void solve() {
            placeQueen(0);
            System.out.println("Antal lösningar: " + count);
        }

        private void placeQueen(int row) {
            if (row == n) {
                printBoard();
                count++;
                return;
            }
            for (int col = 0; col < n; col++) {
                if (isSafe(row, col)) {
                    pos[row] = col;
                    placeQueen(row + 1);
                }
            }
        }

        private boolean isSafe(int row, int col) {
            for (int i = 0; i < row; i++) {

                if (pos[i] == col)
                    return false;
                if (Math.abs(pos[i] - col) == row - i)
                    return false;
            }
            return true;
        }

        private void printBoard() {
            System.out.println("Lösning " + (count + 1) + ":");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (pos[i] == j)
                        System.out.print("Q ");
                    else
                        System.out.print(". ");
                }
                System.out.println();
            }
            System.out.println();
        }

        public static void main(String[] args) {
            int n = 8;
            NB20 q = new NB20(n);
            q.solve();
        }
    }




