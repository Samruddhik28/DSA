import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push expected closing bracket onto the stack
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If stack is empty or top doesn't match current closing bracket
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        // Valid only if all opened brackets have been matched
        return stack.isEmpty();
    }
}