package lektion4;
import java.util.Arrays;
public class ArrayQueue<E>{
        private int front, rear, size, maxSize;
        private E[] data;

        public ArrayQueue(int initialSize){
            size = 0;
            front = 0;
            maxSize = initialSize;
            rear = 0;
            data = (E[]) new Object[maxSize];
        }

        public boolean offer(E element){
            if (size == maxSize) {
                reallocate();
            }
        rear = (rear+1) % maxSize;
        data[rear] = element;
        size++;
        return true;
        }

        public E peek(){
            if(size==0) return null;
            return data[front];
        }

        public E poll(){
        if(size==0) return null;
        size--;
        MaxSizekrympa();
        E element = data[front];
        front =(front+1) % maxSize;
        return element;
        }


        public int Size(){
            return this.size;
        }
        public int MaxSize(){
            return this.maxSize;
        }

        private void MaxSizekrympa(){
            if(size<= maxSize / 4){
                maxSize = (maxSize/2);
                data = Arrays.copyOf(data,maxSize);
                front = 0;
                rear = size;
            }
        }


        private void reallocate() {
        int newMaxSize = 2 * maxSize;
        E[] newData = (E[]) new Object[newMaxSize];
        int j = front;
        for (int i = 0; i < size; i++) {
            newData[i] = data[j];
            j = (j + 1) % maxSize;
        }
        front = 0;
        rear = size - 1;
        maxSize = newMaxSize;
        data = newData;
    }


    public static void main(String[] args) {
        ArrayQueue<Integer> list = new ArrayQueue<>(12);
        list.offer(10);
        list.offer(10);
        list.offer(10);
        list.offer(10);
        list.offer(10);
        list.offer(10);
        list.offer(10);
        list.offer(10);
        list.offer(10);
        list.offer(10);
        list.offer(20);
        list.offer(10);
        list.offer(20);
        System.out.println(list.Size()+" "+ list.MaxSize());
        list.poll();
        list.poll();
        list.poll();
        list.poll();
        list.poll();
        list.poll();
        list.poll();
        System.out.println(list.Size()+" "+ list.MaxSize());
        list.poll();
        list.poll();
        list.poll();
        System.out.println(list.Size()+" "+ list.MaxSize());
    }
}
