package lektion6;

public class BollsBox {
    static public int AntalExchang(int blue,int white,int red,int antal){
        if(blue==white&&white==red){
            return antal;
        }

        if(antal==15){
            return -1;
        }
        int show = -1;
        if(white>0) {
            show=  Math.max(show,AntalExchang(blue + 2, white - 1, red + 4, antal + 1));
        }
        if(blue>0) {
            show= Math.max(show, AntalExchang(blue-1,white+1,red+3,antal+1));
        }
        if(red>0) {
            show= Math.max(show,AntalExchang(blue+1,white+5, red-1,antal+1));
        }
        return show;
    }

    public static void main(String[] args) {
        System.out.println(BollsBox.AntalExchang(2,1,0,0));
    }
}
