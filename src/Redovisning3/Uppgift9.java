package Redovisning3;

import java.util.Random;

public class Uppgift9 {




    public int[] RadixSort(int[]V){
        int maxValue = V[0];
        for (int i = 0; i < V.length; i++) {
            if (maxValue<V[i]){
                maxValue=V[i];
            }
        }
        int [] out = new int[V.length];
        int upp=1;
        while(maxValue / upp > 0){
            int []  count = new int[10];
            out = new int[V.length];
            for (int i:V){
                int digit =(i/upp) %10;
                count[digit]++;
            }
            int total = 0,oldvalue;
            for (int i = 0; i < count.length; i++) {
                oldvalue=count[i];
                count[i]=total;
                total+=oldvalue;
            }
            for (int a: V){
                int digit = (a / upp) % 10;
                out[count[digit]++]=a;
            }
            for (int i = 0; i < V.length; i++){
                V[i] = out[i];
            }
           upp*=10;
        }



        StringBuilder s = new StringBuilder();
        for (int i = 0; i < out.length; i++) {
            s.append(out[i]+" ");
            if(i%10==0){
                s.append("\n");
            }
        }
        System.out.println(s.toString());
        return out;
    }
    public static void main(String[] args) {
        Random random = new Random();
        int[] list = new int[1000000];
        for (int i = 0; i < list.length; i++) {
            list[i]= random.nextInt(10000);
        }
        Uppgift9 run = new Uppgift9();
        run.RadixSort(list);
    }
}
