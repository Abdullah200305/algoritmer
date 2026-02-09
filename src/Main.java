import test.SelectionList;

public class Main{
    public static void main(String[] args) {
        int[] list = {2,4,5,2,1};
        SelectionList.solve(list);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            str.append(list[i]+" ");
        }
        System.out.println(str.toString());
    }

}








