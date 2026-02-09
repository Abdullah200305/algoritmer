package test;

public class SelectionList {
    static public int[] solve(int [] unorderlist){
        for (int i = 0; i < unorderlist.length-1; i++) {
            int mint = i;
            for (int j = i+1; j < unorderlist.length; j++) {
                if(unorderlist[mint]>unorderlist[j]){
                    mint = j;
                }
            }
            int temp = unorderlist[i];
            unorderlist[i]= unorderlist[mint];
            unorderlist[mint]=temp;

        }

        return unorderlist;
    }
}
