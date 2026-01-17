package lektion3;
import java.util.Stack;
public class postfix {
    Stack<Integer> list = new Stack<Integer>();

    public void SearchToken(String text){
        int count =0;
        StringBuilder item = new StringBuilder();
        while (count < text.length()){
            if(text.charAt(count)==' ') {
                if (isDigit(item.toString())) {
                    list.push(Integer.parseInt(item.toString()));
                } else {
                    list.push(isOperation(item.charAt(0)));
                }


            item = new StringBuilder();
            }
            else {
                item.append(text.charAt(count));
            }

            count++;
        }
        System.out.println(list);

    }


    private int isOperation(char item){
        System.out.println(list);
        int res =0;
        int one = list.peek();
        list.pop();
        System.out.println(list);

        switch (item){
            case '+':
                res= one + list.peek();
                break;
            case '-':
                res= one - list.peek();
                break;
            case '*':
                res= one * list.peek();
                break;
            case '/':
                if(list.peek() != 0){
                    res= list.peek()/ one;
                }
                break;
        }
        list.pop();
        System.out.println(list);
        return res;
    }
    private boolean isDigit(String item){
        try {
            Integer.parseInt(item);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
