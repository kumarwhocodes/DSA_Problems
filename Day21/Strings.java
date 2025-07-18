package Day21;

import java.util.*;

public class Strings {
    
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        
        // Start by assuming the whole first string is the common prefix
        String prefix = strs[0];
        
        // Compare the prefix with the rest of the strings
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        
        return prefix;
    }
    
    //check whether string is iso morphic or not
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
    
    //Reverse words in string
    public static String reverseWordsInString(String str) {
        String[] words = str.trim().split("\\s+");
        StringBuilder s = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            s.append(words[i]);
            s.append(" ");
        }
        return s.toString().trim();
    }
    
    //sort characters by frequency
    public static List<Character> frequencySort(String s) {
        s = s.trim();
        HashMap<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Character> chars = new ArrayList<>(frequency.keySet());                        //returns a set of all the keys in the map
        chars.sort((a, b) -> frequency.get(b) - frequency.get(a));      //comparator
        
        List<Character> result = new ArrayList<>();
        for (char c : chars) {
            int count = frequency.get(c);
            for (int i = 0; i < count; i++) {
                result.add(c);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
//        String[] input = {"flower", "flow", "flight"};
//        String result = longestCommonPrefix(input);
//        System.out.println("Longest Common Prefix: " + result);
//        System.out.println(checkIsoMorphicStrings("egg", "add"));
//        System.out.println(reverseWordsInString("HELLO WORLD!"));
        System.out.println(frequencySort("tree"));
    }
}
