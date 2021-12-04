package data_structure.arrays.questions.strings;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
 * removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * <p>
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * <p>
 * Input: s = " "
 * Output: true
 * <p>
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    /**
     * Time: O(n)
     * Space: O(1)
     **/
    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) return true;
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while (!Character.isLetterOrDigit(chars[left])) left++;
            while (!Character.isLetterOrDigit(chars[right])) right--;

            if (Character.toLowerCase(chars[left]) == Character.toLowerCase(chars[right])) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
        System.out.println(isPalindrome("9559"));
        System.out.println(isPalindrome("5995"));
        System.out.println(isPalindrome("wsa"));
    }
}
