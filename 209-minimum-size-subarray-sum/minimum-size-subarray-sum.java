class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int i=0,j=0;
        int maxl=Integer.MAX_VALUE;
        int sum=0;
        while(j<n){
            sum+=nums[j];

            while(sum>= target){
                maxl=Math.min(maxl,j-i+1);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return maxl==Integer.MAX_VALUE ? 0 :maxl;
    }
}