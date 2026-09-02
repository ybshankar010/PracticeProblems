package in.bhavanishankar.longestValidParanthesis;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        int longestValidParenthesesLength = 0,stringLength = s.length();

        Stack<Integer> positionStack = new Stack<>();

        char curr,prev;
        for (int i=0;i<stringLength;++i) {
            curr = s.charAt(i);

            if (curr == '(') {
                positionStack.push(i);
            } else if(curr == ')') {
                if (positionStack.isEmpty()) {
                    positionStack.push(i);
                } else {
                    int top = positionStack.peek();
                    prev = s.charAt(top);
                    if (prev == '(') {
                        positionStack.pop();
                        if (positionStack.isEmpty()) {
                            longestValidParenthesesLength = i+1;
                        } else {
                            top = positionStack.peek();
                            longestValidParenthesesLength = Math.max(longestValidParenthesesLength,i-top);
                        }
                    } else {
                        positionStack.push(i);
                    }
                }
            }
        }

        return longestValidParenthesesLength;
    }
}
