class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int min=-1;
        int max=-1;
        int lb=-1;
        long ans=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<minK || nums[i]>maxK){
                lb=i;
            }

            if(nums[i]==minK){
                min=i;
            }

            if(nums[i]==maxK){
                max=i;
            }
            int small= Math.min(min,max);
            int temp=small-lb;
            if(temp>0){
                ans=ans+temp;
            }
        }
        return ans;
    }
}