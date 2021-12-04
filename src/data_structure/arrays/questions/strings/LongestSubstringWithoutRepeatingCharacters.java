package data_structure.arrays.questions.strings;

import data_structure.hash_table.HashMap;

import java.util.HashSet;

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
        char[] charArray = s.toCharArray();

        if (charArray.length == 0) return 0;
        if (charArray.length == 1) return 1;

        int maxLength = 0;
        int indexA = 0;
        int indexB = 1;

        HashSet<Character> seenChars = new HashSet<>();
        seenChars.add(charArray[indexA]);

        while (indexB < charArray.length) {
            int substringLength = 0;

            if (seenChars.contains(charArray[indexB])) {
                substringLength = indexB - indexA;
                seenChars.remove(charArray[indexA]);
                indexA++;

                if (indexA == indexB) {
                    seenChars.add(charArray[indexB]);
                    indexB++;
                }
            } else {
                seenChars.add(charArray[indexB]);
                indexB++;
            }

            if (indexB == charArray.length) substringLength = indexB - indexA;
            maxLength = Math.max(substringLength, maxLength);
        }
        return maxLength;
    }

    /**
     * Time: O(N^2)
     * Space: O(N)
     **/
    public static int lengthOfLongestSubstring2(String s) {
        char[] charArray = s.toCharArray();
        int maxLength = 0;

        for (int i = 0; i < charArray.length; i++) {
            int newMax = 1;

            HashSet<Character> seenChars = new HashSet<>();
            seenChars.add(charArray[i]);

            for (int j = i + 1; j < charArray.length; j++) {
                if (!seenChars.contains(charArray[j])) {
                    seenChars.add(charArray[j]);
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
