package lektion4;
import java.util.Stack;

public class InfixToPosFix {
    public static String convertToPostfix(String infix) {
        StringBuilder res = new StringBuilder();
        Stack<String> opera = new Stack<>();
        infix = infix.replaceAll("\\s+", "");
        String[] tokens = infix.split("(?<=[-+*/()])|(?=[-+*/()])");
        for (String token : tokens) {
            if (isDigit(token)) {
                res.append(token).append(" ");
            } else if (token.equals("(")) {
                opera.push(token);
            } else if (token.equals(")")) {
                while (!opera.isEmpty() && !opera.peek().equals("(")) {
                    res.append(opera.pop()).append(" ");
                }
                if (!opera.isEmpty() && opera.peek().equals("(")) {
                    opera.pop();
                }
            } else {
                while (!opera.isEmpty() && precedence(opera.peek()) >= precedence(token)) {
                    res.append(opera.pop()).append(" ");
                }
                opera.push(token);
            }
        }
        while (!opera.isEmpty()) {
            res.append(opera.pop()).append(" ");
        }

        return res.toString().trim();
    }

    private static boolean isDigit(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int precedence(String op) {
        switch (op) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        String infix = "12 + 3 * (4 - 5)";
        System.out.println(convertToPostfix(infix));
    }
}

