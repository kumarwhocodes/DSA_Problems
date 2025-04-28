package P270425;

public class Recursion {
    
    public static Integer atoi(String str) {
        str = str.trim();
        if (str.isEmpty()) return 0;
        
        boolean isNegative = false;
        int index = 0;
        
        if (str.charAt(0) == '-') {
            isNegative = true;
            index++;
        } else if (str.charAt(0) == '+') {
            index++;
        }
        
        return isNegative ? -helper(str, index, 0) : helper(str, index, 0);
    }
    
    private static Integer helper(String str, int index, int result) {
        //Base case: stop if it's the last digit or any non-digit char encountered
        if (str.length() == index || !Character.isDigit(str.charAt(index))) {
            return result;
        }
        
        // ASCII value of '3' is 51 and of '0' is 48 -> so we get '3' - '0' = 3
        int digit = str.charAt(index) - '0';            //subtracting from the ASCII value of 0 to get the integer
        result = result * 10 + digit;
        
        return helper(str, index + 1, result);
    }
    
    /**
     * Find power using recursion
     */
    public static Integer findPow(int x, int n) {
        if (n == 0) return 1;
        return x * findPow(x, n - 1);
    }
    
    public static void main(String[] args) {
        System.out.println(atoi("1234"));
        System.out.println(findPow(2, 2));
    }
    
}
