package tentan;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class test1 <E>{
    private int size;
    private E[] data;

    public test1(int cap){
         size =0;
         data = (E[])new Object[cap];
    }

    public boolean add(int index,E item){
        if(size>= data.length){
            data = Arrays.copyOf(data,data.length*2);
        }
        if(index<0 || index>= data.length){
           throw new IllegalArgumentException("is bigger or else");
        }
        for (int i = size; i > index; i--) {
            data[i]= data[i-1];
        }
        data[index] = item;
        size++;
        return true;
    }

    public E remove(int index){
        if(size==0){
           return null;
        }
        if(index<0 || index>= data.length){
            throw new IllegalArgumentException("is bigger or else");
        }
        E old = data[index];
        for (int i = index; i < size; i++) {
            data[i]= data[i+1];
        }
        size--;
        data[size]=null;
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
        return old;
    }




    private class MyItre implements Iterator<E>{

        private int current=0;
        @Override
        public boolean hasNext() {
            if(data.length==current){
                return false;
            }
            return true;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            return data[current++];

        }


    }



    public Iterator<E> iterator(){
        return new MyItre();
    }
}
