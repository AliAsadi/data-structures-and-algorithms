package data_structure.arrays.questions.strings;

import data_structure.hash_table.HashMap;

import java.util.HashSet;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Input: s = "abcabcbb"
 * Output: 3
 *
 * Input: s = "bbbbb"
 * Output: 1
 *
 * Input: s = "pwwkew"
 * Output: 3
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        if (charArray.length == 0) return 0;
        if (charArray.length == 1) return 1;
        int maxLength = 0;

        int indexA = 0;
        int indexB = 1;


        HashSet<Character> characters = new HashSet<>();

        while (indexB < charArray.length) {
            int newMax = 0;

            characters.add(charArray[indexA]);

            if (characters.contains(charArray[indexB])) {
                characters.remove(charArray[indexA]);
                newMax = indexB - indexA;

                indexA++;
                if (indexA == indexB) {
                    characters.add(charArray[indexB]);
                    indexB++;
                }
            } else {
                characters.add(charArray[indexB]);
                indexB++;
            }


            if (indexB == charArray.length) newMax = indexB - indexA;

            maxLength = Math.max(newMax, maxLength);
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

            HashSet<Character> characters = new HashSet<>();
            characters.add(charArray[i]);

            for (int j = i + 1; j < charArray.length; j++) {
                if (characters.contains(charArray[j])) {
                    break;
                } else {
                    characters.add(charArray[j]);
                    newMax++;
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
