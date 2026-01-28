import Redovisning1.SingleLinkedList;
import Redovisning1.Uppgift3;
import lektion5.*;

import java.util.Iterator;


public class Main{
    public static void main(String[] args) {
    /*    SingleLinkedList<Integer> listone = new SingleLinkedList<>();

        listone.add(1);
        listone.add(2);
        listone.add(3);
        listone.add(0,12);

        System.out.println(listone.remove(0));
        System.out.println(listone.remove(1));
        System.out.println(listone.remove(1));
        System.out.println(listone.remove(0));
        System.out.println("Size: " + listone.get(3)+" "+listone.toString());
*/


        Uppgift3<Integer> list = new Uppgift3<>();
        list.add(1);
        list.add(999,0);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            int data = it.next();
            if(data%3==0){
                it.remove();
            }
            System.out.println(data);
        }

        System.out.println(list.toString());



    }

}








