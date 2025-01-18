package P1312;

import java.util.Stack;

public class PostfixToInfix {
    
    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
    static String postfixToInfix(String postfix) {
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            }
            
            else if (isOperator(c)) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                
                String infix = "(" + operand1 + c + operand2 + ")";
                
                stack.push(infix);
            }
        }
        
        return stack.pop();
    }
    
    public static void main(String[] args) {
        String postfix = "ab+c*";
        String infix = postfixToInfix(postfix);
        
        System.out.println("Postfix: " + postfix);
        System.out.println("Infix: " + infix);
    }
    
}
