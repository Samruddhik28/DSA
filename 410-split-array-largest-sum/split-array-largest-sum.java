class Solution {
    public int splitArray(int[] nums, int k) {
         int n = nums.length;
         int low = Arrays.stream(nums).max().getAsInt();
         int high = 0;
         for(int piece:nums){
            high += piece;
         }
         int ans = high;
         while(low <= high){
            int mid = low + (high - low)/2;
            if(possible(nums,k,mid)){
               ans = mid;
               high = mid - 1;
            }else{
               low = mid + 1;
            }
         }
            return ans;
    }
    public boolean possible(int[] nums, int k, int mid){
         int sub = 1;
         int sum = 0;
         for(int i = 0;i < nums.length;i++){
            if(sum+ nums[i] > mid){
                sub++;
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            if(sub > k){
                return false;
            }
         }
         return true;
    }
}