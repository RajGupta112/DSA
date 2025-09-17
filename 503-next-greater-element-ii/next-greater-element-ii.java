class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int res[]= new int [n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(res,-1);
        for(int i=0;i<2*n;i++){
            int idx=nums[i%n];
      while(!st.isEmpty() && idx>nums[st.peek()]){
        res[st.pop()]=idx;
      }
            if(i<n){
                st.push(i);
            }
        }
        return res;
    }
}