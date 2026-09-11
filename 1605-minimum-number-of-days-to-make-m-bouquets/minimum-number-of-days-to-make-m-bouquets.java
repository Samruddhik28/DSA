class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long)m *k > bloomDay.length){
            return -1;
        }
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if (calculate(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean calculate(int[] bloomDay, int m, int k, int day) {
        int flower = 0;
        int bouquets = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) { 
                flower++;
                if (flower == k) {
                    bouquets++;
                    flower = 0; 
                }
            } else {
                flower = 0;
            }
        }
        return bouquets >= m;
    }
}