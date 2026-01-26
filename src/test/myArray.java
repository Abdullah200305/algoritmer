package test;

import java.util.Arrays;

public class myArray<E> {
  private E[] data;
  private int size;
  private int maxInit;
  public myArray(){
      maxInit = 2;
      size = 0;
      data = (E[]) new Object[maxInit];
  }
  public E get(int index){
      if(index<=0||index>size){
          throw new IndexOutOfBoundsException(index);
      }
      return data[index];
  }
  public int indexOf(E item){
      for (int i = 0; i < size; i++) {
          if(data[i] == item){
             return i;
          }
      }
      return -1;
  }
  public int[] indexesOf(E item){
        int[] indexs = new int[10];
        int antal =0;
        for (int i = 0; i < size; i++) {
            if(data[i] == item){
               indexs[antal++]=i;
            }
        }
        if(indexs!=null){
            indexs = Arrays.copyOf(indexs,antal);
            return indexs;
        }
        return null;
    }
  public boolean Add(E item){
      if(size==maxInit){
          Incrase();
      }
      data[size++]=item;
      return true;
  }
  public boolean Add(int index,E item){
      if(index<0||index>size){
          throw new IndexOutOfBoundsException(index);
      }
      if(size==maxInit){
          Incrase();
      }
      for (int i = size; i > index; i--) {
         data[i]=data[i-1];
      }
      data[index]=item;
      size++;
      return true;
  }

  public E remove(int index){
      if(size==0){
          throw new IllegalStateException("Array is empty");
      }
      if(index<0||index>size){
          System.out.println("ddd");
          throw new IndexOutOfBoundsException(index);
      }
      E oldValue = data[index];
      for (int i = index; i < size; i++) {
          data[i] = data[i+1];
      }
      size--;
      data[size]=null;
      return oldValue;
  }
  private void Incrase(){
      int newMaxInit = maxInit*2;
      data = Arrays.copyOf(data,newMaxInit);
      maxInit = newMaxInit;
  }
  public int Size(){
      return size;
  }
  public int max(){
        return maxInit;
    }
  @Override
  public String toString(){
      StringBuilder str = new StringBuilder();

      for (int i = 0; i < size; i++) {
          str.append(data[i]+" ");
      }
      return str.toString();
  }

}
