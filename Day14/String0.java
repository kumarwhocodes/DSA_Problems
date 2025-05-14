package Day14;

public class String0 {
    
    public static String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int depth = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (depth > 0) ans.append(c); // Skip the outermost '('
                depth++;
            } else { // c == ')'
                depth--;
                if (depth > 0) ans.append(c); // Skip the outermost ')'
            }
        }
        
        return ans.toString();
    }
    
    /**
     * If you used split(" ") instead, you'd get empty strings where multiple spaces occur.
     * \\s+ means: Match one or more whitespace characters.
     */
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        
        // Append words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" ");
        }
        
        return sb.toString();
    }
    
    /**
     * Largest Odd Number String from the given string
     */
    public static String largeOddNum(String s) {
        int index = s.length() - 1;
        while (index >= 0) {
            if ((s.charAt(index) - '0') % 2 == 1) {
                break;
            }
            index--;
        }
        if (index < 0) return "";
        return s.substring(0, index + 1);
    }
    
    public static void main(String[] args) {
//        String input = "(()())(())";
//        String result = removeOuterParentheses(input);
//        System.out.println(result);

//        String sentence = "Hello there!";
//        System.out.println(reverseWords(sentence));
        
        System.out.println(largeOddNum("5347"));
    }
    
}
