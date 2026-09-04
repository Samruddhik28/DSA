class Solution{
    public int minEatingSpeed(int[] piles,int h){
      int maxPile = Arrays.stream(piles).max().getAsInt();
      
      int low = 1;
      int high = maxPile;
      int ans = maxPile;

      while(low <= high){
        int mid = low +(high -low)/2;
        long totalH = calculateTotalHours(piles,mid);

        if(totalH <= h){
            ans = mid;
            high = mid -1;
        }else{
            low = mid + 1;
        }
      }
      return ans;
    }
    private long calculateTotalHours(int[] piles,int speed){
        long totalH = 0;
        for(int banana: piles){
            totalH += (long)Math.ceil((double)banana / speed);
        }
        return totalH;
}
}