class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0; // Pointer to place the next valid element
        
        for (int i = 0; i < nums.length; i++) {
            // If the current element is not equal to val, keep it
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        
        return index; // index represents k, the number of valid elements
    }
}