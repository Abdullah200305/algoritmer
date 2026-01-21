package lektion3;
import java.util.Stack;
public class postfix {
   private static Stack<Integer> list = new Stack<Integer>();
   static public int SearchToken(String text){
        for (String token : text.split("\\s+")){
                if (isDigit(token)) {
                    list.push(Integer.parseInt(token));
                } else {
                    list.push(isOperation(token.charAt(0)));
                }
            }
        int res = list.pop();
        System.out.println(list);
        return res;
        }



    private static int isOperation(char item){
        int res =0;
        int one = list.pop();
        int two = list.pop();
        switch (item){
            case '+':
                res= one + two;
                break;
            case '-':
                res= one - two;
                break;
            case '*':
                res= one * two;
                break;
            case '/':
                if(two != 0){
                    res= two/ one;
                }
                break;
            default:
                throw new IllegalArgumentException("Ogiltig operator");
        }
        return res;
    }
    private static boolean isDigit(String item){
        try {
            Integer.parseInt(item);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(postfix.SearchToken("12 6 + 3 / "));
    }
}
