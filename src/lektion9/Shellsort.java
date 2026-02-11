package lektion9;

public class Shellsort {


    public static void shellSort(int[] a){
        int n = a.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int index = gap; index < n; index++) {
                int data = a[index];
                int dataIndex = index;
                while (dataIndex > gap-1 && data < a[dataIndex - gap]) {
                    a[dataIndex] = a[dataIndex - gap];
                    dataIndex -= gap;
                }
                a[dataIndex] = data;
            }
            if (gap == 2) {
                gap = 1;
            } else {
                gap = (int)(gap / 2.2);
            }
        }


    }

    public static void main(String[] args) {
        int[] list = {3,4,5,5,3,2,1};
        Shellsort.shellSort(list);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            str.append(list[i]+" ");
        }
        System.out.println(str.toString());
    }
}
