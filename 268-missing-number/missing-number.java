class Solution {
    public int missingNumber(int[] arr) {
        int n=arr.length;
        int nsum= n*(n+1)/2;
        int sum=0;
        for(int i=0;i<n;i++){
        sum=sum+arr[i];
        }
        int ans=nsum-sum;
        return ans;
    }
}