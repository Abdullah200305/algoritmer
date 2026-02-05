package lektion8;

import java.util.HashSet;

public class NB26_2 {
    static public int GetUnikCalls(String[] list){
        HashSet check = new HashSet();

        for (int i = 0; i < list.length; i++) {
                check.add(list[i]);
        }
        return check.size();
    }
    public static void main(String[] args) {
        System.out.println(NB26_2.GetUnikCalls(new String[]{ "gråter", "man", " tänker", "när"}));
    }

}
