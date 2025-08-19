import java.util.Arrays;

class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        
        if (k == 0) {
            return nums;  // If k == 0, return nums as is
        }

        int[] result = new int[n];
        Arrays.fill(result, -1);

        if (n < 2 * k + 1) {
            return result; // not enough elements for even one window
        }

        int left = 0;
        int right = 2 * k;
        long sum = 0;

        // compute sum of first window
        for (int j = left; j <= right; j++) {
            sum += nums[j];  // ✅ fixed
        }

        int i = k; // window center
        result[i] = (int)(sum / (2 * k + 1));
        i++;
        right++;

        // sliding window
        while (right < n) {
            sum += nums[right] - nums[left];
            result[i] = (int)(sum / (2 * k + 1));

            i++;
            left++;
            right++;
        }

        return result;
    }
}
