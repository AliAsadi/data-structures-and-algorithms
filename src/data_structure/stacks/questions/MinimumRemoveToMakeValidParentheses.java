package data_structure.stacks.questions;

import data_structure.stacks.Stack;

/**
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting
 * parentheses string is valid and return any valid string.
 * <p>
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * <p>
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * <p>
 * Input: s = "))(("
 * Output: ""
 * <p>
 * Input: s = "(a(b(c)d)"
 * Output: "a(b(c)d)"
 * <p>
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class MinimumRemoveToMakeValidParentheses {

    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();

        char open = '(';
        char close = ')';
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == open || ch == close) {
                if (ch == open) {
                    stack.push(i);
                } else {
                    if (stack.isEmpty()) chars[i] = ' '; else stack.pop();
                }
            }

        }

        while (!stack.isEmpty()) chars[stack.pop()] = ' ';

        StringBuilder sp = new StringBuilder();
        for (char ch : chars) if (ch != ' ') sp.append(ch);
        return sp.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
    }
}
