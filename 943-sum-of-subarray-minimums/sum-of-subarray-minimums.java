class Solution {
    public int sumSubarrayMins(int[] arr) {
         long sum=0;
         int mod=1_000_000_007;
         int n= arr.length;
         int left[]= new int[n];
         int right[]= new int [n];
         Stack<int[]> st= new Stack<>();
         for(int i=0;i<arr.length;i++){
            int count=1;
            while(!st.isEmpty() && st.peek()[0] > arr[i]){
                count+=st.pop()[1];
            }
            left[i]=count;
            st.push(new int[]{arr[i], count});
         }

         st.clear();
         for(int i=n-1;i>=0;i--){
            int count=1;
            while(!st.isEmpty() && st.peek()[0] >= arr[i]){
                count+=st.pop()[1];
            }
            right[i]=count;
            st.push(new int[]{arr[i], count});
         }

         for(int i=0;i<n;i++){
            sum=(sum+(long)arr[i]*left[i]*right[i])%mod;
         }
         return (int)sum;
    }
}