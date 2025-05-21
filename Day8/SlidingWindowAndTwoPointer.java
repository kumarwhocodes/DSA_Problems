package Day8;

import java.util.Arrays;
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
    
    public static int[][] setMatrixZerosBrute(int[][] matrix, int m, int n) {
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        
        // Step 1: Mark rows and columns that have 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        
        // Step 2: Set marked rows and columns to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        return matrix;
    }
    
    public static void main(String[] args) {
//        String input = "abcabcbb";
//        System.out.println("Length of the longest substring: " + longestSubstringWithoutRepeatingChar(input));
        
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(setMatrixZerosBrute(matrix, 3, 3)));
    }
    
}
