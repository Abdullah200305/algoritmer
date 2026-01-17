package lektion3;
import java.util.Stack;
public class ParentesMatch {
    public static boolean matchStr(String item){

        Stack<Character>Starttag=new Stack<Character>();
        Stack<Character>Endtag=new Stack<Character>();
        for (int i = 0; i < item.length(); i++) {
            switch (item.charAt(i)){
                case '(':
                    Starttag.push(item.charAt(i));
                    break;
                case '{':
                    Starttag.push(item.charAt(i));
                    break;
                case '[':
                    Starttag.push(item.charAt(i));
                    break;
                default:
                    break;
            }
            switch (item.charAt(i)){
                case ')':
                    Endtag.push(item.charAt(i));
                    break;
                case '}':
                    Endtag.push(item.charAt(i));
                    break;
                case ']':
                    Endtag.push(item.charAt(i));
                    break;
                default:
                    break;
            }

            if(!(Endtag.isEmpty()) && !(Starttag.isEmpty())){
                StringBuilder match = new StringBuilder();
                match.append(Starttag.peek()+" "+Endtag.peek());
                if(Starttag.peek()=='(' && Endtag.peek()==')'){
                    Starttag.pop();
                    Endtag.pop();
                }
                else if (Starttag.peek()=='{' && Endtag.peek()=='}') {
                    Starttag.pop();
                    Endtag.pop();
                }
                else if(Starttag.peek()=='[' && Endtag.peek()==']'){
                    Starttag.pop();
                    Endtag.pop();
                }
            };
        }
        return Starttag.isEmpty() && Endtag.isEmpty();
    }
}
