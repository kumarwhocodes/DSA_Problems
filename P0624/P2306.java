package P0624;

public class P2306 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("word"));
        System.out.println("-------------------------");


    }

    //check if string is palindrome or not
    static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            char atLeft = word.charAt(left);
            char atRight = word.charAt(right);
            if (Character.toLowerCase(atLeft) != Character.toLowerCase(atRight))
                return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    static boolean isPalindromeRecursive(String word){
        return true;
        //same complexity as the previous one
    }

    
}
