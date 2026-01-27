package lektion5;

public class NB15 {

    static public int run(String text){

        return run(text,0,0);
    }
    static private int run(String text,int postion,int res){
        if(postion==text.length()){
            return res;
        }
        if(text.charAt(postion) == '1'){
            res = res*2 + 1;
        } else {
            res = res*2;
        }
        return run(text, postion+1, res);
    }
}
