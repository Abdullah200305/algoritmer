package three;

public class MinHeap {
    public int[] data;
    private int size;
    public MinHeap() {
        data = new int[1000];
        size=0;
    }

    private int left(int index){
        return 2*index+1;
    }
    private int right(int index){
        return 2*index+2;
    }
    private int parent(int index){
        return (index-1)/2;
    }
    public boolean offer(int item){
        if(size==data.length){
            return false;
        }
        data[size]= item;
        int currentIndex = size;
        while(true){
            int pr = parent(currentIndex);

            if(pr>=0 && data[pr]>item){
                int temp =  data[currentIndex];
                data[currentIndex]= data[pr];
                data[pr] = temp;
                currentIndex = pr;
            }
            else {
                break;
            }
        }
        size++;
        return true;
    }


    public int poll(){
        if(size==0){
            return  Integer.MAX_VALUE;
        }
        int temp = data[0];
        data[0] = data[size-1];
        data[size-1]= 0;

        size--;
        int index = 0; // indexCurrent
        int S =  index; // min
        while(true){
           int le = left(S);
           int ri = right(S);

           if(le<size && data[le]<data[S]){
               S = le;
           }
            if(ri<size && data[ri]<data[S]){
                S = ri;
            }
            if(S!= index){
                int t = data[index];
                data[index] = data[S];
                data[S] = t;
                index = S;
            }
            else {
                break;
            }
        }

        return temp;
    }

    static void main() {
        MinHeap heap = new MinHeap();
        heap.offer(2);
        heap.offer(1);
        heap.offer(3);

        heap.poll();
        for (int i = 0; i < heap.size; i++) {
            System.out.println(heap.data[i]);
        }
    }
}
