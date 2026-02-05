import lektion8.NB26_3;

public class Main{
    public static void main(String[] args) {
        NB26_3<String,Integer>hashTabel = new NB26_3<>(1);
        hashTabel.put("cow",10);
        hashTabel.put("run",10);
        hashTabel.put("dow",10);
        System.out.println(hashTabel.toString());
        hashTabel.remove("dow");
        System.out.println(hashTabel.toString());

    }

}








