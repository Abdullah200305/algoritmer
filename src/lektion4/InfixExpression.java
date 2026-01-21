package lektion4;


import java.util.Arrays;
import java.util.Stack;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfixExpression {
    private Stack<Character> operater;
    private Stack<Character> priority;
    private Stack<Integer> listNum;

    public InfixExpression() {
        operater = new Stack<Character>();
        priority = new Stack<Character>();
        listNum = new Stack<Integer>();
    }

    public int InfixCalculate(String expression){
        expression = expression.replaceAll("\\s+", "");
        String[] tokens = expression.split("(?<=[-+*/()])|(?=[-+*/()])");
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            token = token.trim();
            if(isDigit(token)){
                listNum.push(Integer.parseInt(token));
            }
            else{
                isOperator(token);
            }
           if(!priority.isEmpty() && token.contains(")")&& i+1== tokens.length){
               priority.pop();
               getInfix();
           }
            if(!priority.isEmpty() && token.contains(")")){
                priority.pop();
                getInfix();
            }
            else {
                if(listNum.size()==2 && priority.isEmpty()){
                   getInfix();
                }
            }
        }

        return listNum.pop();
    }


    private int getInfix(){
        int first = 0;
        switch (operater.pop()){
            case '+':
                listNum.push(listNum.pop() + listNum.pop());
                break;
            case '-':
                first = listNum.pop();
                listNum.push(listNum.pop() - first);
                break;
            case '*':
                listNum.push(listNum.pop() * listNum.pop());
                break;
            case '/':
                first = listNum.pop();
                if( first != 0){
                    listNum.push(listNum.pop() / first);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operater.pop());
        };
        return listNum.peek();
    }

    private boolean isOperator(String item){
        switch (item){
            case "+":
                operater.push(item.charAt(0));
                break;
            case "-":
                operater.push(item.charAt(0));
                break;
            case "*":
                operater.push(item.charAt(0));
                break;
            case "/":
                operater.push(item.charAt(0));
                break;
            case "(":
                priority.push(item.charAt(0));
                break;
            case ")":
                break;
            default:
                throw new IllegalArgumentException("Ogiltig operator");
        }
        return true;
    }
    private boolean isDigit(String item){
        try {
            Integer.parseInt(item);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void main(String[] args) {
        InfixExpression cal = new InfixExpression();
        System.out.println(cal.InfixCalculate("4 * 7"));
        System.out.println(cal.InfixCalculate("4 * (7 + 2)"));
        System.out.println(cal.InfixCalculate("(4 * 7) - 20"));
        System.out.println(cal.InfixCalculate("3 + ((4 * 7) / 2)"));



    }
}
