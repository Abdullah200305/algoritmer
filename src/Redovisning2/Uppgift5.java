package Redovisning2;

import java.util.ArrayList;
import java.util.Arrays;

public class Uppgift5 {



    static public String bokstavsordning(ArrayList<Character> list){
        ArrayList<Character> res = new ArrayList<>(Arrays.asList('A','B','C','D','E'));
        StringBuilder path = new StringBuilder();

        Result result = bokstavsordning(list,res,path,0);
        StringBuilder str = new StringBuilder();
        str.append(list.toString()+" tar minst "+result.number+" steg och en lösning är: "+result.path+".");
        return  str.toString();
    }

    static private class Result{
        private String path;
        private int number;

        public Result(int number,String path) {
            this.number = number;
            this.path = path;
        }
    }
    static public Result bokstavsordning(ArrayList<Character> list,ArrayList<Character>test,StringBuilder path,int antal){
        if(list.equals(test)){
            return new Result(antal,path.toString());
        }
        if(antal==15){
            return new Result(Integer.MAX_VALUE,"-1");
        }
        Result one = b(list,test,antal,path);
        Result two = s(list,test,antal,path);


        return (one.number < two.number) ? one : two;

    }

    static private Result b( ArrayList<Character> list,
                          ArrayList<Character>test,
                          int antal,
                          StringBuilder path){
        ArrayList<Character> ny = new ArrayList<>(list);
        char temp = ny.get(1);
        ny.set(1,ny.get(0));
        ny.set(0,temp);
        return bokstavsordning(ny,test,new StringBuilder(path).append("b"),antal+1);
    }
    static private Result s( ArrayList<Character> list,
                          ArrayList<Character>test,
                          int antal,
                          StringBuilder path){
        ArrayList<Character> ny = new ArrayList<>(list);
        char temp = ny.remove(ny.size()-1);
        ny.add(0,temp);
        return bokstavsordning(ny,test,new StringBuilder(path).append("s"),antal+1);
    }


    public static void main(String[] args) {

        ArrayList<Character> test = new ArrayList<>(Arrays.asList('B','E','C','A','D'));

        System.out.println(Uppgift5.bokstavsordning(test));
    }
}
