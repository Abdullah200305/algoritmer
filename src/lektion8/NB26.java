package lektion8;

import java.util.HashSet;

public class NB26 {

    static public HashSet Union(HashSet<String> setA,HashSet<String> setB){
        HashSet NewForm = new HashSet<>(setA);
        NewForm.addAll(setB);
        return NewForm;
    }
    static public HashSet intersection (HashSet<String> setA,HashSet<String> setB){
        HashSet NewForm = new HashSet<>(setA);
        NewForm.retainAll(setB);
        return NewForm;
    }

    public static void main(String[] args) {
        HashSet setA = new HashSet();
        HashSet setB = new HashSet();
        String[] listA = {"Ann", "Sally", "Jill", "Sally"};
        String[] listB = {"Bob", "Bill", "Ann", "Jill"};
        for (int i = 0; i < listA.length; i++) {
            setA.add(listA[i]);
        }
        for (int i = 0; i < listB.length; i++) {
            setB.add(listB[i]);
        }
        System.out.println(NB26.Union(setA,setB));
        System.out.println(NB26.intersection(setA,setB));
    }
}
