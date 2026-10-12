import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Map to store the most recent index of each character
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0; // Left pointer of the sliding window

        // Right pointer 'end' expands the window
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the character is already in the window, shrink the window from the left
            if (map.containsKey(currentChar)) {
                start = Math.max(start, map.get(currentChar) + 1);
            }

            // Update/insert the last seen index of the character
            map.put(currentChar, end);

            // Calculate the current window length and update maxLength
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
