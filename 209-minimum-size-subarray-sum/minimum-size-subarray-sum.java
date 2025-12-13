class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minlen = Integer.MAX_VALUE;
        int sum=0;
        int low=0,high=0;
     while(high<nums.length){
      sum=sum+nums[high];
      while(sum>=target){
        int length=high-low+1;
        minlen=Math.min(minlen,length);
        sum=sum-nums[low];
        low++;
      }
      high++;
     }
       
     return minlen==Integer.MAX_VALUE ? 0 :minlen;
    
    }
}
