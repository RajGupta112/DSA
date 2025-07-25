class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int max=n/2;
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int c:map.keySet()){
           int count= map.get(c);
           if(count>max){
            return c;
           }
        }
        return -1;
    }
}
    
