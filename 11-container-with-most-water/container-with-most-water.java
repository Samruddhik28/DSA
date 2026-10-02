class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // Calculate current width and height
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            
            // Update max area
            int currentArea = width * currentHeight;
            maxWater = Math.max(maxWater, currentArea);

            // Move the pointer corresponding to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}