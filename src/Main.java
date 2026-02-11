import lektion9.MyProgram;
import lektion9.NB28;
import lektion9.Shellsort;
import lketion10.Heap;
import lketion10.NB30;
import test.CountingSort;
import test.MaxHeap;


public class Main{
    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] list = {22,4,3,-1,-2,3,3,2,21,1,1,3,52,1};
        heap.Heapsort(list);



        StringBuilder str = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            str.append(list[i]+" ");
        }
        System.out.println(str.toString());
    }

}








