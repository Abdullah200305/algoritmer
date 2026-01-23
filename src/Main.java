import Redovisning1.Uppgift3;

import java.util.Iterator;
public class Main {
    public static void main(String[] args) {
        Uppgift3<Integer> list = new Uppgift3<>();
        list.Add(10);
        list.Add(20);
        list.Add(30);
        list.Add(50);
        list.Add(60);
        Iterator ite = list.iterator();
        while (ite.hasNext()){
            System.out.println(ite.next());
            ite.remove();

        }
        System.out.println(list.toString());





    }
}








