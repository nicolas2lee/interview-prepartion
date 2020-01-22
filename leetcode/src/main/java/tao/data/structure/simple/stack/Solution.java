package tao.data.structure.simple.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
class Solution {
    public boolean isValid(String s) {
        final Integer length = s.length();
        if (length == 0) return true;
        if (length %2 != 0) return false;

        char[] inputCharArray = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i<length;i++){
            char current = inputCharArray[i];
            if (isLeftSide(current)){
                stack.add(current);
            } else {
                if (!stack.isEmpty()){
                    char top = stack.pop();
                    if (!isMatch(current, top)){
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

    boolean isMatch(char current, char top){
        return (current == ')' && top =='(') || (current == '}' && top =='{')
                || (current == ']' && top =='[');
    }

    boolean isLeftSide(char c){
        return c == '(' || c == '{' || c =='[';
    }
}