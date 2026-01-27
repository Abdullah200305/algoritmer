package lektion5;

public class NB13 {
    static public double Rot(double n,double a, double e){
        if(Math.abs(a * a - n) < e){
            return a;
        }
        return Rot(n,(((a*a)+n)/(2*a)),e);
    }
}
