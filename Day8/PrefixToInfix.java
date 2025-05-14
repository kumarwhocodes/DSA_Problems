package Day8;

import java.util.Stack;

public class PrefixToInfix {
    
    static String prefixToInfix(String prefix) {
        Stack<String> stack = new Stack<>();
        
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String toBePushed = "(" + operand1 + c + operand2 + ")";
                stack.push(toBePushed);
            }
        }
        return stack.pop();
    }
    
    public static void main(String[] args) {
        String prefix = "*+abc";
        String infix = prefixToInfix(prefix);
        System.out.println("Infix expression: " + infix);
    }
}
