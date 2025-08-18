class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        
        if (k == 0) {
            return nums;  // If k == 0, return nums as is
        }

        int[] result = new int[n];
        // Fill with -1 initially
        Arrays.fill(result, -1);

        if (n < 2 * k + 1) {
            return result; // Not enough elements to form a window
        }

        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];

        // Build prefix sum
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        // Compute averages
        for (int i = k; i < n - k; i++) {
            int leftIdx = i - k;
            int rightIdx = i + k;

            long sum = prefixSum[rightIdx];
            if (leftIdx > 0) {
                sum -= prefixSum[leftIdx - 1];
            }

            int avg = (int)(sum / (2 * k + 1));
            result[i] = avg;
        }

        return result;
    }
}
