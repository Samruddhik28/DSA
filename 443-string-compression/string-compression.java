class Solution {
    public int compress(char[] chars) {
        int write = 0; // Pointer to write the compressed characters
        int read = 0;  // Pointer to scan the array

        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;

            // Count occurrences of the current character group
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            // Write the character
            chars[write++] = currentChar;

            // If character repeated more than once, write the count digits
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write; // Return the new length of the array
    }
}