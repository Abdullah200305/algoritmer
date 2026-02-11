package test;

import java.util.Arrays;

public class CountingSort {
    static public void sort(int[]v){
        int[] count = new int[Arrays.stream(v).parallel().max().getAsInt()+1];
        int[]output=new int[v.length];
        StringBuilder str = new StringBuilder();
        for (int a:v){count[a]++;} // to count antal fron orginal array
        for (int i = 0; i < count.length; i++) {
            str.append(count[i]+" ");
        }
        StringBuilder st = new StringBuilder();
        int total=0,oldvalue;
        for (int i = 0; i < count.length; i++) {
            oldvalue = count[i];
            count[i]=total;
            total+=oldvalue;
        }
        for (int a:v){output[count[a]++]=a;};
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < output.length; i++) {
            s.append(output[i]+" ");
        }
        for (int i = 0; i < count.length; i++) {
            st.append(count[i]+" ");
        }
        System.out.println(str.toString());
        System.out.println(st.toString());
        System.out.println(s.toString());
    }
}
