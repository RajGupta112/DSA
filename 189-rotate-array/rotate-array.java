class Solution {
    public void reverse( int [] nums,int start,int end){
       
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n=nums.length;
       k=k%n; ;
       reverse(nums,0,n-k-1);
       reverse(nums,n-k,n-1);
       reverse(nums,0,n-1);
    }
}