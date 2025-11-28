class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n= nums.length;
        int sum=0;
        int mindiff=Integer.MAX_VALUE;
        int ans=0;
         Arrays.sort(nums);
         for(int i=0;i<n-2;i++){
            int left=i+1,right=n-1;
            while(left<right){
            sum=nums[i]+nums[left]+nums[right];
             int  diff =Math.abs(sum-target);
           if(diff<mindiff){
              mindiff=diff;
              ans=sum;
           }
          if(sum<target){
          
           left++;
           }else{
            
            right--;
           }
            }
         }
         return ans;
    }
}