package lektion13;

public class NB43 {
    static int[] mynt = {1, 5, 10, 25};
    static int n = mynt.length;

    static int vaxel(int belopp) {
        for (int i = 0; i < n; i++) {
            if (mynt[i] == belopp) {
                return 1;
            }
        }

        int bast = 100000;

        for (int i = 0; i < n; i++) {
            if (mynt[i] < belopp) {
                bast = Math.min(bast, 1 + vaxel(belopp - mynt[i]));
            }
        }

        return bast;
    }
    public static void main(String[] args) {
        int belopp = 3;
        System.out.println("Minsta antal mynt: " + vaxel(belopp));
    }
}
