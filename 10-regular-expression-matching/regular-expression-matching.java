class Solution {
    private Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p);
    }

    private boolean dp(int i, int j, String s, String p) {
        // Base case: pattern exhausted
        if (j == p.length()) {
            return i == s.length();
        }

        // Return memoized result if available
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        // Check if current characters match
        boolean firstMatch = (i < s.length() && 
                             (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

        boolean result;

        // Check if next character in pattern is '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // Case 1: Ignore x* (skip 2 characters in pattern)
            // Case 2: Use x* (if first character matched, advance s by 1)
            result = dp(i, j + 2, s, p) || (firstMatch && dp(i + 1, j, s, p));
        } else {
            // Standard character match
            result = firstMatch && dp(i + 1, j + 1, s, p);
        }

        memo[i][j] = result;
        return result;
    }
}