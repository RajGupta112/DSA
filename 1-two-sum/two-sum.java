class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m= new HashMap<>();
        int rem=0;
        for(int i=0;i<nums.length;i++){
        rem=target-nums[i];
        if(m.containsKey(rem)){
            return new int[]{m.get(rem),i};
        }
        m.put(nums[i],i);
        }
        return new int[]{};
    }
}