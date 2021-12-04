package data_structure.arrays.questions.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * <p>
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Time: O(n)
     * Space: O(n)
     **/
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();

        int maxLength = 0;
        int left = 0;
        int right = 0;

        HashSet<Character> seen = new HashSet<>();

        while (right < chars.length) {
            if (seen.contains(chars[right])) {
                seen.remove(chars[left++]);
                if (left == right) seen.add(chars[right++]);
            } else {
                seen.add(chars[right++]);
            }

            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }

    /**
     * Time: O(n)
     * Space: O(n)
     **/
    public int lengthOfLongestSubstringSlidingWindow(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0;
        Map<Character, Integer> seen = new HashMap<>();
        for (int j = 0, i = 0; j < chars.length; j++) {
            if (seen.containsKey(chars[j])) {
                i = Math.max(seen.get(chars[j]), i);
            }
            maxLength = Math.max(maxLength, j - i + 1);
            seen.put(chars[j], j + 1);
        }
        return maxLength;
    }

    /**
     * Time: O(N^2)
     * Space: O(N)
     **/
    public static int lengthOfLongestSubstringBruteForce(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0;

        for (int i = 0; i < chars.length; i++) {
            int newMax = 1;

            HashSet<Character> seen = new HashSet<>();
            seen.add(chars[i]);

            for (int j = i + 1; j < chars.length; j++) {
                if (!seen.contains(chars[j])) {
                    seen.add(chars[j]);
                    newMax++;
                } else {
                    break;
                }
            }
            maxLength = Math.max(newMax, maxLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbbabcde"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("abcdba"));
        System.out.println(lengthOfLongestSubstring(" "));
    }
}
