package data_structure.stacks.questions;

import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * <p>
 * Input: s = "()"
 * Output: true
 * <p>
 * Input: s = "()[]{}"
 * Output: true
 * <p>
 * Input: s = "(]"
 * Output: false
 * <p>
 * Input: s = "([)]"
 * Output: false
 * <p>
 * Input: s = "{[]}"
 * Output: true
 * <p>
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s.length() == 1) return false;

        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (char ch : s.toCharArray()) {
            boolean isOpenChar = map.containsKey(ch);
            if (isOpenChar) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                if (map.get(stack.pop()) != ch) return false;
            }

        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("(("));
    }
}
