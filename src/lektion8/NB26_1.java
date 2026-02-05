package lektion8;

import java.util.HashMap;

public class NB26_1 {


    static public int GetMoreCalls(String[] list){
        HashMap<String,Integer> check = new HashMap<>();
        int max = 0;
        for (int i = 0; i < list.length; i++) {
            int count = check.getOrDefault(list[i], 0) + 1;
            check.put(list[i],(count));
                if(max<count){

                    max = count;
                }
            }
        return max;
    }
    public static void main(String[] args) {
        System.out.println( NB26_1.GetMoreCalls(new String[]{"man", "gråter", "när", "man", " tänker", "när"}));
    }
}
