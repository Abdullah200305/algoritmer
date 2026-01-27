package lektion5;

public class NB12 {
    static public int calculatePowerTo(int base,int power){
      if(power==1){
          return base;
      }
      return base*calculatePowerTo(base,power-1);
    };

    static public int calculatePowerToIterativ(int base,int power){
        int res = 1;
        for (int i = 0; i < power; i++) {
            res*=base;
        }
        return res;
    };
}
