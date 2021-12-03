package data_structure.arrays.questions.strings;

import java.util.Stack;

/**
 * Created by Ali Asadi on 03/12/2021
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

        int charToSkipA = 0;
        int charToSkipB = 0;

        while (indexA != 0 || indexB != 0) {
            if (charToSkipA > 0) indexA--;
            if (charToSkipB > 0) indexB--;
            if (arrayA[indexA] == '#') charToSkipA++;
            if (arrayB[indexB] == '#') charToSkipB++;

            if (charToSkipA == 0 && charToSkipB == 0) {
                if (arrayA[indexA] != arrayB[indexB]) return false;
                indexA--;
                indexB--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a##c", "#a#c"));
        System.out.println(backspaceCompare("a#c", "b"));
    }
}
