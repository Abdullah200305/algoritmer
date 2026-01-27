package lektion5;

public class NB14 {
 /*   static public int cost(int points, int goal,int result){
        if(points==goal){
            return result;
        }
        if(points>goal){
            return -1;
        }
        int tal1 = cost(points + 4, goal, result + 5);
        int tal2 = cost(points * 3, goal, result + 10);

        if (tal1 == -1 && tal2 == -1) return -1;
        if (tal1 == -1) return tal2;
        if (tal2 == -1) return tal1;
        return Math.min(tal1, tal2);
    }*/


    static public int cost(int points, int goal){
        if(points==goal){
            return 0;
        }
        return cost(points,goal,0);
    }
    static private int cost(int points, int goal,int result){
        if(points==goal){
            return result;
        }
        if(points>goal){
            return -1;
        }
        int tal1 = cost(points + 4, goal, result + 5);
        int tal2 = cost(points * 3, goal, result + 10);

        if (tal1 == -1 && tal2 == -1) return -1;
        if (tal1 == -1) return tal2;
        if (tal2 == -1) return tal1;
        return Math.min(tal1, tal2);
    }



}
