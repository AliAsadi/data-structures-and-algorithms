package data_structure.arrays.questions.strings;

import java.util.Stack;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors.
 * '#' means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 *
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 *
 * Follow up: Can you solve it in O(n) time and O(1) space?
 *
 * https://leetcode.com/problems/backspace-string-compare/
 */
public class BackspaceStringCompare {
    public static boolean backspaceCompare(String s, String t) {
        return checkEqualTwoPointer(s, t);
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    private static String getStringWithoutSpaces(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }


    /**
     * Time: O(n)
     * Space: O(n) -> Start from the end of the string
     **/
    private static String getStringWithoutSpaces2(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        int charToSkip = 0;

        for (int i = charArray.length - 1; i > 0; i--) {
            if (charArray[i] == '#') {
                charToSkip++;
            } else {
                if (charToSkip > 0) {
                    charToSkip--;
                } else {
                    sb.append(charArray[i]);
                }
            }
        }


        return sb.toString();
    }

    /**
     * Time: O(n)
     * Space: O(1) -> Two Pointer Technique
     **/
    private static boolean checkEqualTwoPointer(String s, String t) {
        char[] arrayA = s.toCharArray();
        char[] arrayB = t.toCharArray();

        int indexA = arrayA.length - 1;
        int indexB = arrayB.length - 1;

        while (indexA >= 0 || indexB >= 0) {

            indexA = skipIndexes(arrayA, indexA);
            indexB = skipIndexes(arrayB, indexB);

            if (indexA < 0 && indexB < 0) return true;
            if (indexA < 0 || indexB < 0) return false;
            if (arrayA[indexA] != arrayB[indexB]) return false;
            indexA--;
            indexB--;
        }

        return true;
    }

    static int skipIndexes(char[] array, int index) {
        if (array[index] == '#') {
            int charToSkip = 2;
            while (charToSkip > 0) {
                index--;
                charToSkip--;
                if (index >= 0 && array[index] == '#') charToSkip += 2;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a##c", "#a#c"));
        System.out.println(backspaceCompare("a#c", "b"));
        System.out.println(backspaceCompare("2", "b"));
        System.out.println(backspaceCompare("#", "b"));
        System.out.println(backspaceCompare("##", "b##"));
        System.out.println(backspaceCompare("##", "#"));
    }
}
