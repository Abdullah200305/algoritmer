package lektion3;
import java.util.Stack;
public class ParentesMatch {
    public static boolean matchStr(String item) {
        java.util.Stack<Character> Starttag = new Stack<Character>();
        for (char c: item.toCharArray()) {
            switch (c) {
                case '(':
                    Starttag.push(c);
                    break;
                case '{':
                    Starttag.push(c);
                    break;
                case '[':
                    Starttag.push(c);
                    break;
                default:
                    break;
            }
            if (Starttag.isEmpty()) {
                return false;
            }

            if(c=='}' && Starttag.peek() == '{' ||
                    c==']' && Starttag.peek() == '[' ||
                    c==')' && Starttag.peek() == '('){
                Starttag.pop();
            }
        }
        return Starttag.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(ParentesMatch.matchStr("{[]([(){]}}"));
    }
}
