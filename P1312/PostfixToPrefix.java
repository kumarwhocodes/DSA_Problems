package P1312;

import java.util.Stack;

public class PostfixToPrefix {
    
    static String postfixToPrefix(String postfix) {
        
        Stack<String> stack = new Stack<>();
        int i = 0;
        
        for (i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);
            if (Character.isLetterOrDigit(ch)){
                stack.push(String.valueOf(ch));
            } else{
                String top1 = stack.pop();
                String top2 = stack.pop();
                String toBePushed = ch + top2 + top1;
                stack.push(toBePushed);
            }
        }
        return stack.pop();
        
    }
    
    public static void main(String[] args) {
        System.out.println(postfixToPrefix("AB+CD-*"));
    }
    
}
