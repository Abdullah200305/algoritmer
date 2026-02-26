/*
package test;

import Redovisning3.Uppgift9;
import lektion9.Shellsort;

import java.util.Arrays;

public class MySelectionSort {








*/
/*
    static int partition(int[] arr, int low, int high) {

        // choose the pivot
        int pivot = arr[high];

        // index of smaller element and indicates
        // the right position of pivot found so far
        int i = low - 1;

        // traverse arr[low..high] and move all smaller
        // elements to the left side. Elements from low to
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);
        return i + 1;
    }

    // swap function
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // the QuickSort function implementation
    static void sort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is the partition return index of pivot
            int pi = partition(arr, low, high);

            // recursion calls for smaller elements
            // and greater or equals elements
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
*//*


*/
/*
    static  public void sort(int []list){
        if(list.length<=1){
            return;
        }
        int pivot = list.length-1;
        int index = -1;
            for (int j = 0; j < list.length; j++) {
                    if(list[pivot]>=list[j]){
                        index++;
                        int temp = list[index];
                        list[index]=list[j];
                        list[j]=temp;
                    }
            }

        // fill

        int[] rightA = new int[list.length-index];
        int[] leftA = new int[index];
        int right=0,left=0;
        for (int i = 0; i < list.length; i++) {
            if(list[index]>list[i]){
                leftA[left++]=list[i];
            }
            else {
                rightA[right++]=list[i];
            }
        }




        sort(rightA);
        sort(leftA);
        int k = 0;
        for (int i = 0; i < leftA.length; i++) {
            list[k++] = leftA[i];
        }
        for (int i = 0; i < rightA.length; i++) {
            list[k++] = rightA[i];
        }
    }*//*

   */
/* static  private void add(int []left,int[]right,int[]or){

    }*//*




 */
/*   private int size;
    private int[] data;
    private int nextPos;
    public MySelectionSort(int size) {
        this.size = size;
        data = new int[size];
        nextPos = 0;
    }
    public boolean insert(int dat) {
        if (nextPos==0){
            data[nextPos++]=dat;
            return true;
        }
        else {
            int parent= 0;

            int index = nextPos;
            data[nextPos++]=dat;
           while (parent>=0){

               parent  = (index-1)/2;
               if(data[parent]>dat){
                   int temp = data[parent];
                   data[parent]= data[index];
                   data[index]= temp;
                   index = parent;
               }
               else {
                   break;
               }
           }
        }
        return true;
    };
    public int remove() {
            if(size==0){
                return -1;
            }
            else {

                int a = 0;
                int old = data[0];
                data[a]= data[nextPos-1];
                data[nextPos-1]=0;
                size--;
                nextPos--;
                while (true){
                    int index = a;
                    int right= a*2 +2;
                    int left= a*2 +1;
                    if(left<size && data[index]>data[left]){
                        index = left;
                    }
                    if(right<size && data[index]>data[right]){
                        index = right;
                    }

                    if (a != index){
                        int temp = data[a];
                        data[a]=data[index];
                        data[index]=temp;
                        a = index;
                    }
                    else {
                       return old;
                    }
                }
            }
    }


*//*


    */
/*

        static public void sort(int[] list){
            if(list.length==1){
                return;
            }
            int mid = list.length/2;
            int[] leftA = new int[mid];
            for (int i = 0; i < leftA.length; i++) {
                leftA[i] = list[i];
            }
            int[] rightA = new int[list.length-mid];
            for (int i = 0; i < rightA.length; i++) {
                rightA[i] = list[i+mid];
            }
             sort(leftA);
             sort(rightA);
             add(list,leftA,rightA);
        }

        static public void add(int[] or,int[] left , int[] right){
            int a=0,le=0,ri=0;
            while(left.length>le && right.length>ri){
                if(right[ri]>=left[le]){
                    or[a++]= left[le++];
                }
                else {
                    or[a++]= right[ri++];
                }
            }
            while (ri<right.length){
                or[a++]=right[ri++];
            }
            while (le<left.length){
                or[a++]=left[le++];
            }

        }

    *//*





*/
/*

    static public void sort(int[] list){
        int gap = list.length/2;
        while (gap>0){
            for (int i = gap; i < list.length; i++) {
                int data = list[i];
                int j = i;
                while (j>gap-1 && list[j-gap]>data){
                    list[j]= list[j-gap];
                    j--;
                }
                list[j]=data;
            }
            if(gap==2){
                gap = 1;
            }
            else {
                gap = (int)(gap / 2.2);
            }
        }
    }
*//*


 */
/*   static public void sort(int[] list){

        for (int i = 1; i < list.length; i++) {
            int j = i;
            int key = list[i];
            while (j>0 && list[j-1]>key){
                list[j]=list[j-1];
                j--;
            }
            list[j]= key;

        }
    }*//*


  */
/*  static public void sort(int[] list){

        for (int i = 0; i < list.length; i++) {
            int small = i;
            for (int j = i+1; j < list.length; j++) {
                if(list[small]>list[j]){
                    small = j;
                }
            }
            int temp = list[i];
            list[i] = list[small];
            list[small] = temp;
        }

    }*//*




    public static void main(String[] args) {
        int[] list = {10,80,30,3,4,4,4,23,2,190,40};

        long start = System.nanoTime();

        MySelectionSort.sort(list,0, list.length - 1);

        long end = System.nanoTime();

        long time = end - start;
        double ms = time / 1_000_000.0;
        System.out.println("Tid: " + ms + " ms");




        StringBuilder str = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            str.append(list[i]+" ");
        }
        System.out.println(str.toString());
    }
}
*/
