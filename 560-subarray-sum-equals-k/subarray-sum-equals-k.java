class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int res=0;
    Map<Integer,Integer> pre= new HashMap<>();
    pre.put(0,1);
    for(int i=0;i<nums.length;i++){
        sum=sum+nums[i];
        if(pre.containsKey(sum-k)){
            res=res+pre.get(sum-k);
        }
          pre.put(sum,pre.getOrDefault(sum,0)+1);
        
    }
    return res;
    }
}