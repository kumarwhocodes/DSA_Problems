package P1224;

import java.util.HashSet;

public class SlidingWindowAndTwoPointer {
    
    static int longestSubstringWithoutRepeatingChar(String s) {
        if (s == null || s.isEmpty()) return 0;
        
        int left = 0, right = 0, maxLen = 0;
        HashSet<Character> visited = new HashSet<>();
        
        while (right < s.length()) {
            if (!visited.contains(s.charAt(right))) {
                visited.add(s.charAt(right));
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                visited.remove(s.charAt(left));
                left++;
            }
        }
        
        return maxLen;
    }
    
    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println("Length of the longest substring: " + longestSubstringWithoutRepeatingChar(input));
    }
    
}
