package lektion9;

public class NB28 {

    static public int[]SelectionSort(int[] list){
        int[] temp = list.clone();
        for (int i = 0; i < temp.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < temp.length; j++) {
                if(temp[minIndex]>temp[j]){
                    minIndex = j;
                }
            }
            int tempp = temp[i];
            temp[i] = temp[minIndex];
            temp[minIndex]= tempp;
        }
        return temp;
    }
    static public int[] InsertionSort(int[] list){
        int[] temp = list.clone();
        for (int i = 1; i < temp.length; i++) {
           int key = temp[i];
           int j = i;
           while(j > 0 && key<temp[j-1]){
               temp[j]=temp[j-1];
               j--;
           }
           temp[j]=key;
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] list = {2,4,5,2,1};

        list = NB28.InsertionSort(list);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            str.append(list[i]+" ");
        }
        System.out.println(str.toString());
    }
}
