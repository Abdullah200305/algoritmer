package lektion4;
import java.util.Arrays;
public class BlackBox<E> {

    private int front, rear, size, maxSize;
    private E[] data;

    public BlackBox(int initialSize){
        size = 0;
        front = 0;
        maxSize = initialSize;
        rear = 0;
        data = (E[]) new Object[maxSize];
    }

    public boolean offer(E element){
        if(size==maxSize)
            reallocate();
        data[rear] = element;
        rear = (rear+1)%maxSize;
        System.out.println(3%maxSize);
        size++;
        return true;
    }

    public E peek(){
        if(size==0) return null;
        return data[front];
    }
    public int getFront() {
        return front;
    }

    public int Size() {
        return size;
    }

    public int getRear() {
        return rear;
    }

    public E poll(){
        if(size==0){
            return null;
        }else{
            size--;
            E element = data[front];
            data[front] =null;
            front =(front+1)%maxSize;
            return element;
        }
    }

    private void reallocate() {
        E[] newData = (E[]) new Object[maxSize * 2];
        for (int i = 0; i < size; i++) {
            System.out.println((rear+i) % maxSize+" "+rear);
            newData[i] = data[(front + i) % maxSize];
        }
        data = newData;
        maxSize*=2;
        front = 0;
        rear = size;
    }

        @Override
        public String toString(){
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < maxSize; i++) {

                if(i != maxSize-1){
                    str.append(data[i]+"->");
                }
                else {
                    str.append(data[i]);
                }
            }
            return str.toString();
        }

    public static void main(String[] args) {
        BlackBox<Integer> list = new BlackBox<>(3);
        list.offer(10);
        list.offer(20);
        list.offer(30);
        list.poll();
        System.out.println(list.Size());
        list.offer(40);
        list.offer(50);
        System.out.println(list.toString());

    }
}
