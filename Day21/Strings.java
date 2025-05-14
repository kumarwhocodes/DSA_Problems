package Day21;

import java.util.HashMap;
import java.util.HashSet;

public class Strings {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        
        // Start by assuming the whole first string is the common prefix
        String prefix = strs[0];
        
        // Compare the prefix with the rest of the strings
        for (int i = 1; i < strs.length; i++) {
            // Reduce the prefix until it matches the start of strs[i]
            while (!strs[i].startsWith(prefix)) {
                // Shorten the prefix from the end
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If prefix becomes empty, there is no common prefix
                if (prefix.isEmpty())
                    return "";
            }
        }
        
        return prefix;
    }
    
    public static boolean checkIsoMorphicStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> mapped = new HashSet<>();
        
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                if (mapped.contains(c2)) {
                    return false;
                }
                map.put(c1, c2);
                mapped.add(c2);
            }
        }
        
        return true;
    }
    
    
    public static void main(String[] args) {
//        String[] input = {"flower", "flow", "flight"};
//        String result = longestCommonPrefix(input);
//        System.out.println("Longest Common Prefix: " + result);
        System.out.println(checkIsoMorphicStrings("egg", "add"));
    }
}
