
import lektion3.postfix;
import lektion4.BlackBox;
import lektion4.DubbleLinkadList;
import lektion4.InfixExpression;
import lektion4.InfixToPosFix;


public class Main {
    public static void main(String[] args) {
        InfixExpression cal = new InfixExpression();
      /*  System.out.println(cal.InfixCalculate("4 * 7"));
        System.out.println(cal.InfixCalculate("4 * (7 + 2)"));
        System.out.println(cal.InfixCalculate("(4 * 7) - 20"));
        System.out.println(cal.InfixCalculate("3 + ((4 * 7) / 2)"));*/

        System.out.println(InfixToPosFix.convertToPostfix("4 * 7"));
        System.out.println(InfixToPosFix.convertToPostfix("4 * (7 + 2)"));
        System.out.println(InfixToPosFix.convertToPostfix("(4 * 7) - 20"));
        System.out.println(InfixToPosFix.convertToPostfix("3 + ((4 * 7) / 2)"));

        System.out.println(postfix.SearchToken(InfixToPosFix.convertToPostfix("4 * 7")));
        System.out.println(postfix.SearchToken(InfixToPosFix.convertToPostfix("4 * (7 + 2)")));
        System.out.println(postfix.SearchToken(InfixToPosFix.convertToPostfix("(4 * 7) - 20")));
        System.out.println(postfix.SearchToken(InfixToPosFix.convertToPostfix("3 + ((4 * 7) / 2)")));


    }
}








