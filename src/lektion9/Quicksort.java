package lektion9;

import java.util.ArrayList;
import java.util.List;

public class Quicksort {
    static public void quickSort(int[] list,int low,int heigh){
        if(low<heigh){
            int pivIndex = partition(list, low, heigh);
            quickSort(list,low,pivIndex-1);
            quickSort(list,pivIndex+1,heigh);
        }
    }
    private static int partition(int[] list,int low,int heigh){
        int pivot = list[low];
        int up = low;
        int down = heigh;
        do {
            while (up < heigh && list[up] <= pivot) {
                up++;
            }
            while (list[down] > pivot) {
                down--;
            }
            if (up < down) {
                int temp = list[up];
                list[up] = list[down];
                list[down] = temp;
            }
        }while (up < down);
        int temp = list[low];
        list[low] = list[down];
        list[down] = temp;
        return down;
    }


    public static void main(String[] args) {
        int[] list = {2,4,3,5,1};

         Quicksort.quickSort(list,0,list.length-1);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            str.append(list[i]+" ");
        }
        System.out.println(str.toString());
    }
}
