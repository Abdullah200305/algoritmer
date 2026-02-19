package lektion12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NB36 {

    static class Activity {
        int start, end;
        Activity(int s, int e) {
            start = s;
            end = e;
        }
    }
    public static List<Activity> schedule(List<Activity> V){

        List<Activity> result = new ArrayList<>();
        V.sort(Comparator.comparingInt(a -> a.end));

        while(!V.isEmpty()){
            Activity chosen = V.get(0);
            result.add(chosen);

            int endTime = chosen.end;
            V.removeIf(a -> a.start < endTime);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Activity> list = new ArrayList<>();
        list.add(new Activity(1,3));
        list.add(new Activity(2,5));
        list.add(new Activity(4,7));
        list.add(new Activity(6,9));

        List<Activity> res = schedule(list);

        System.out.println("Valda aktiviteter:");
        for(Activity a : res)
            System.out.println(a.start + " " + a.end);
    }
}
