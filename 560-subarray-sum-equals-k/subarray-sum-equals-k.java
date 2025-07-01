class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        int count=0;
        HashMap<Integer,Integer> res= new HashMap<>();
        res.put(0,1);

        for(int i=0;i<n;i++){
            sum=sum+nums[i];
           int rem=sum-k;
            if(res.containsKey(rem)){
                count=count+res.get(rem);
            }

            res.put(sum,res.getOrDefault(sum,0)+1);
        }
        return count;
    }
}