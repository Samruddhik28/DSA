class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        long low = 1;
        long high = x;
        int ans = 0;

        while(low <= high){
            long mid = low + (high - low)/2;
            if(mid*mid <= x){
              ans = (int)mid;
              low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
}