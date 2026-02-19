package lektion12;

import java.util.ArrayList;
import java.util.Scanner;

public class NB35 {
    private static class Item{
        private int value;
        private int vikt;
        public Item(int value,int vikt) {
            this.value = value;
            this.vikt = vikt;
        }
    }

   public static String Greedy( ArrayList<Item> items, int bagage){
        int[] count = new int[items.size()];
        int res=0;
    while (bagage>0){

        for (int i = 0; i < items.size(); i++) {
            if(bagage>=items.get(i).vikt){
                bagage-=items.get(i).vikt;
                count[i]++;
                res+=items.get(i).value;
                break;
            }
            if(i==items.size()-1){
                bagage=0;
            }
        }
    }
    StringBuilder str = new StringBuilder();
    str.append("It cost like :"+res+"\n");
       for (int i = 0; i < items.size(); i++) {
           str.append(items.get(i).vikt+" ");
       }
       str.append("\n");
    for (int i = 0; i < count.length; i++) {
        str.append(count[i]+" ");
    }
    return str.toString();
  }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item>items = new ArrayList<>();

        int value=-1,itemPrice,itemWeight;
        while (true){
            if(value==-1){
                System.out.print("Enter Bagage size: ");
                value= scanner.nextInt();
            }
                System.out.print("Enter item weight: ");
                itemWeight= scanner.nextInt();
                System.out.print("Enter item cost: ");
                itemPrice= scanner.nextInt();

            items.add(new Item(itemPrice,itemWeight));
            System.out.print("Exit press a: ");
            if(scanner.next().contains("a"))break;
        }




        System.out.println(NB35.Greedy(items,value));
    }
}
