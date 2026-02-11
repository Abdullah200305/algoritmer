import lektion9.MyProgram;
import lektion9.NB28;


public class Main{
    public static void main(String[] args) {
        int[] list = {2,4,5,2,1};

        list = NB28.SelectionSort(list);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            str.append(list[i]+" ");
        }
        System.out.println(str.toString());
/*
        MyProgram run = new MyProgram();
        run.run();*/










    }

}








