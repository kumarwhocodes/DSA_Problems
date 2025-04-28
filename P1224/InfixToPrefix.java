package P1224;

import static P1224.InfixToPostFix.infixToPostFix;

//TODO patta se poochna hai
public class InfixToPrefix {
    private static String reverseInfix(String s) {
        StringBuilder reversed = new StringBuilder(s);
        reversed.reverse();
        
        for (int i = 0; i < reversed.length(); i++) {
            char ch = reversed.charAt(i);
            if (ch == '(') {
                reversed.setCharAt(i, ')');
            } else if (ch == ')') {
                reversed.setCharAt(i, '(');
            }
        }
        
        return reversed.toString();
    }
    
    
    private static String infixToPrefix(String infix) {
        String reversedInfix = reverseInfix(infix);
        String postfix = infixToPostFix(reversedInfix);
        return reverseInfix(postfix);
    }
    
    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Prefix: " + infixToPrefix(infix));
    }
}
