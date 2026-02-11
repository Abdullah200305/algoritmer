package lektion9;

public class Mergesort {


    public static void mergesort(int[] a) {
        if (a.length <= 1) {
            return;
        }
        int mid = a.length / 2;
        int[] b = new int[mid];
        for (int i = 0; i < mid; i++) {
            b[i] = a[i];
        }
        int[] c = new int[a.length - mid];
        for (int i = 0; i < c.length; i++) {
            c[i] = a[i + mid];
        }
        mergesort(b);
        mergesort(c);
        merge(b, c, a);
    }


    public static void merge(int[] b, int[] c, int[] a) {
        int indexb = 0, indexc = 0, indexa = 0;
        while (indexb < b.length && indexc < c.length) {
            if (b[indexb] <= c[indexc]) {
                a[indexa++] = b[indexb++];
            } else {
                a[indexa++] = c[indexc++];
            }
        }
        while (indexb < b.length) {
            a[indexa++] = b[indexb++];
        }
        while (indexc < c.length) {
            a[indexa++] = c[indexc++];
        }
    }

    public static void main(String[] args) {
        int[] list = {3,4,5,5,3,2,1};
        Mergesort.mergesort(list);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            str.append(list[i]+" ");
        }
        System.out.println(str.toString());
    }
}
