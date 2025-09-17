class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int res[]= new int[nums1.length];
        Map<Integer,Integer> mp= new HashMap<>();
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<nums2.length;i++){
         while(!st.isEmpty() && nums2[i]>nums2[st.peek()]){
            mp.put(nums2[st.pop()],nums2[i]);
         }
        st.push(i);
        }

        for(int i=0;i<nums1.length;i++){
            res[i]=mp.getOrDefault(nums1[i],-1);
        }
       return res;
    }
}