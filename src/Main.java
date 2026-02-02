import lektion7.NB22_1;
import lektion7.NB23;
import lektion7.NBNB23_1;
import test.BackTrack;


public class Main{
    public static void main(String[] args) {
/*
        int[]nums = {1,2};
        System.out.println(BackTrack.subsets(nums).toString());
*/
        NBNB23_1<Character> tree = new NBNB23_1<>();


        tree.add('H');
        tree.add('B');
        tree.add('N');
        tree.add('A');
        tree.add('E');
        tree.add('C');
        tree.add('F');
        tree.add('D');
        System.out.println(tree.maxRec());
    }

}








