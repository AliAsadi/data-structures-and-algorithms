package data_structure.arrays.questions.strings;

/**
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 * <p>
 * Input: s = "aba"
 * Output: true
 * <p>
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * <p>
 * Input: s = "abc"
 * Output: false
 * <p>
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
public class AlmostPalindrome {

    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) return true;
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                return validSubPalindrome(chars, left + 1, right) || validSubPalindrome(chars, left, right - 1);
            }
        }
        return true;
    }

    public static boolean validSubPalindrome(char[] chars, int left, int right) {
        if (chars.length == 0) return true;
        while (left < right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("eeccccbebaeeabebccceea"));
        System.out.println(isPalindrome("deeee"));
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("abca"));
        System.out.println(isPalindrome("laceacal"));
        System.out.println(isPalindrome("abccdba"));
        System.out.println(isPalindrome("abc"));
        System.out.println(isPalindrome("abdcdefdba"));

    }

}
