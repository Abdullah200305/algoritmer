package lektion12;

import java.math.BigInteger;

public class NB37 {

    public static void solve(BigInteger a,BigInteger b){

        StringBuilder str = new StringBuilder();

        while (!a.equals(BigInteger.ZERO)){
            BigInteger n = b.divide(a);

            if (!b.mod(a).equals(BigInteger.ZERO)) {
                n = n.add(BigInteger.ONE);
            }
            System.out.println("1/" + n);
            a = a.multiply(n).subtract(b);
            b = b.multiply(n);
        }
    }


    public static void main(String[] args) {
    BigInteger a = BigInteger.valueOf(5);
    BigInteger b = BigInteger.valueOf(121);
        NB37.solve(a,b);
    }
}
