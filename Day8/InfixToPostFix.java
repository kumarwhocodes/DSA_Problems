package Day8;

import java.util.Stack;

public class InfixToPostFix {
    static int priority(char operator) {
        if (operator == '+' || operator == '-') return 1;
        if (operator == '*' || operator == '/') return 2;
        if (operator == '^') return 3;
        return -1;
    }
    
    static boolean isLeftAssociative(char operator) {
        return operator != '^';
    }
    
    static String infixToPostFix(String infix) {
        int i = 0;
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        
        while (i < infix.length()) {
            char ch = infix.charAt(i);
            
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || Character.isDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() &&
                        (priority(ch) < priority(stack.peek()) ||
                                (priority(ch) == priority(stack.peek()) && isLeftAssociative(ch)))) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
            i++;
        }
        
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        
        return postfix.toString();
    }
    
    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Postfix: " + infixToPostFix(infix));
    }
}
