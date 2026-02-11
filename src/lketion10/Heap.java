package lketion10;


public class Heap{



    public boolean offer(int[]v, int index){
        int parent;
        while(index>0){
            parent = (index-1)/2;
            if(v[index]>v[parent]){
                int temp = v[parent];
                v[parent]=v[index];
                v[index]=temp;
            }
            else if(v[index]<=v[parent]){
                break;
            }
            index=parent;

        }
        return true;
    }


    public int poll(int[] a, int index) {
        int oldValue = a[0];
        a[0] = a[index - 1];
        a[index - 1] = oldValue;

        int i = 0;
        while (true) {
            int bigger = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < index-1 && a[left] > a[bigger]) {
                bigger = left;
            }
            if (right < index-1 && a[right] > a[bigger]) {
                bigger = right;
            }
            if (bigger != i) {
                int temp = a[i];
                a[i] = a[bigger];
                a[bigger] = temp;
                i = bigger;
            } else {
                break;
            }
        }
        return oldValue;
    }

    public void Heapsort(int[]v){
        int m = 1;
        while (m<v.length){
            offer(v,m++);
        }
        while (m>1){
            v[m-1]=poll(v,m);
            m--;
        }
    }


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
