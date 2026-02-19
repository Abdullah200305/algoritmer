package lektion12;

import lektion9.Mergesort;

import java.util.Random;

public class NB40 {
    private final int intervall= 2;

    public int antal(double[] list) {
        int count = 0;
        int i = 0;
        int n = list.length;

        while (i < n) {
            double start = list[i];
            double end = start + intervall;
            count++;
            while (i < n && list[i] <= end) {
                i++;
            }
        }

        return count;
    }



    public static void main(String[] args) {
        Random random = new Random();
        double[] list = new  double[10];
        for (int i = 0; i < 10; i++) {
            list[i] = random.nextDouble() * 10;
        }
        Mergesort.mergesort(list);
        NB40 nb40 = new NB40();

        System.out.println(nb40.antal(list));
    }
}
