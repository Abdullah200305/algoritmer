package lektion12;

public class NB34 {
    static public int[] change(int value,int[] valutorna){
        int[] count = new int[valutorna.length];

        while (value!=0){

            for (int i = 0; i < valutorna.length; i++) {
                if(value>=valutorna[i]){
                    value-=valutorna[i];
                    count[i]++;
                    break;
                }
            }
        }


        return count;
    }
    public static void main(String[] args) {
         int[] list= NB34.change(789,new int[] {1000,500,100,50,20,10,5,1});
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]+" ");
        }
    }

}
