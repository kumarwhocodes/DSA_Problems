package P1312;

import java.util.Stack;


public class PrefixToPostfix {
    
    static String prefixToPostfix(String prefix) {
        
        Stack<String> stack = new Stack<>();
        
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String top1 = stack.pop();
                String top2 = stack.pop();
                String toBePushed = top1 + top2 + ch;
                stack.push(toBePushed);
            }
        }
        return stack.pop();
    }
    
    public static void main(String[] args) {
        System.out.println(prefixToPostfix("*+AB-CD"));
    }
    
}
