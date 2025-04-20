package P0204;

public class Stringss {
    
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
    }
    
    public static String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (count > 0) ans.append(c);
                count++;
            } else {
                count--;
                if (count > 0) ans.append(c);
            }
        }
        
        return ans.toString();
    }
    
    
}
