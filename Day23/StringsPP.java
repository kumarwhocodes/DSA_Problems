package Day23;

import java.util.Map;

public class StringsPP {
    
    //Check whether two strings are anagram or not
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int it : count) {
            if (it != 0) return false;
        }
        return true;
    }
    
    
    //check whether string s can be shifted sometimes to achieve goal
    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String doubled = s + s;
        return doubled.contains(goal);
    }
    
    // Maximum Nesting Depth of the Parentheses
    public static int maxDepthOfParenthesis(String s) {
        int maxDepth = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            if (s.charAt(i) == ')') {
                maxDepth = Math.max(count, maxDepth);
                count--;
            }
        }
        return maxDepth;
    }
    
    //Roman numeral to integer conversion
    public static int romanToInteger(String roman) {
        int sum = 0;
        int index = 0;
        
        while (index < roman.length()) {
            char ch = roman.charAt(index);
            char ch_ = (index + 1 < roman.length()) ? roman.charAt(index + 1) : ' ';
            
            if (ch == 'I') {
                if (ch_ == 'V') {
                    sum += 4;
                    index += 2;
                } else if (ch_ == 'X') {
                    sum += 9;
                    index += 2;
                } else {
                    sum += 1;
                    index++;
                }
            } else if (ch == 'X') {
                if (ch_ == 'L') {
                    sum += 40;
                    index += 2;
                } else if (ch_ == 'C') {
                    sum += 90;
                    index += 2;
                } else {
                    sum += 10;
                    index++;
                }
            } else if (ch == 'C') {
                if (ch_ == 'D') {
                    sum += 400;
                    index += 2;
                } else if (ch_ == 'M') {
                    sum += 900;
                    index += 2;
                } else {
                    sum += 100;
                    index++;
                }
            } else if (ch == 'V') {
                sum += 5;
                index++;
            } else if (ch == 'L') {
                sum += 50;
                index++;
            } else if (ch == 'D') {
                sum += 500;
                index++;
            } else if (ch == 'M') {
                sum += 1000;
                index++;
            }
        }
        return sum;
    }
    
    //Roman To Integer Conversion Through Map
    public static int romanToIntegerThroughMap(String s) {
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );
        
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = map.get(s.charAt(i));
            int next = (i + 1 < s.length()) ? map.get(s.charAt(i + 1)) : 0;
            
            // If the current value is less than the next, subtract it
            // This is done because Roman numerals use a subtractive rule for special cases like: IX = X - I = 10 - 1 = 9
            if (current < next) {
                sum -= current;
            } else {
                sum += current;
            }
        }
        return sum;
    }
    
    public static int atoi(String s) {
        if (s.isBlank()) return -1;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - '0';
            num = num * 10 + ch;
        }
        return num;
    }
    
    public static void main(String[] args) {
//        System.out.println(isAnagram("anagram", "grabana"));

//        System.out.println(rotateString("abcde", "cdeab"));

//        System.out.println(maxDepthOfParenthesis("(1+(2*3)+((8)/4))+1"));
        
//        System.out.println(romanToIntegerThroughMap("MCMXCIV"));
        
        System.out.println(atoi("112"));
    }
    
}
