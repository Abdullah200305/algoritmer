package lektion12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;



public class NB39 {
    private static class Activitys{
        private double start;
        private double end;

        public Activitys(double v, double v1) {
            start = v;
            end = v1;
        }
        @Override
        public String toString() {
            return "Activitys{" +
                    "end=" + end +
                    ", start=" + start +
                    '}';
        }
    }
    private ArrayList<Activitys> list;

    public NB39() {
        list = new ArrayList<>();
    }

    public boolean add(Activitys item){
        return list.add(item);
    }


    public int antal(){
        list.sort(Comparator.comparingDouble(a -> a.start));
        PriorityQueue<Double> heap = new PriorityQueue<>();

        int maxPersons = 0;

        for(Activitys a : list){
            while(!heap.isEmpty() && heap.peek() <= a.start){
                heap.poll();
            }
            heap.add(a.end);
            maxPersons = Math.max(maxPersons, heap.size());
        }

        return maxPersons;
    }

    public static void main(String[] args) {
        NB39 nb39 =new NB39();
        nb39.add(new Activitys(1, 3));
        nb39.add(new Activitys(1, 3));
        nb39.add(new Activitys(2, 5));
        nb39.add(new Activitys(4, 6));
        nb39.add(new Activitys(4, 2));
        nb39.add(new Activitys(1, 3));
        nb39.add(new Activitys(2, 5));
        nb39.add(new Activitys(4, 6));
        nb39.add(new Activitys(4, 2));
        System.out.println(nb39.antal());

    }
}
