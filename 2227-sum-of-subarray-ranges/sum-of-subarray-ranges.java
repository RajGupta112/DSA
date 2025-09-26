public class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long[] leftMax = new long[n], rightMax = new long[n];
        long[] leftMin = new long[n], rightMin = new long[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();
            leftMax[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }

        st.clear();
        // RIGHT for max → use <=
        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                int idx = st.pop();
                rightMax[idx] = i - idx;
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int idx = st.pop();
            rightMax[idx] = n - idx;
        }

        st.clear();
        // LEFT for min
        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            leftMin[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }

        st.clear();
        // RIGHT for min → use >=
        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                int idx = st.pop();
                rightMin[idx] = i - idx;
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int idx = st.pop();
            rightMin[idx] = n - idx;
        }

        long sumMax = 0L, sumMin = 0L;
        for (int i = 0; i < n; ++i) {
            sumMax += (long) nums[i] * leftMax[i] * rightMax[i];
            sumMin += (long) nums[i] * leftMin[i] * rightMin[i];
        }

        return sumMax - sumMin;
    }
}
