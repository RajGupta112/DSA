import java.util.Stack;

class Solution {

    public int largestRectangleArea(int heights[]){
        int n= heights.length;
        Stack<Integer> st = new Stack<>();
        int area=0,maxarea=0;

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int ids = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                area = heights[ids] * (nse - pse - 1);
                maxarea = Math.max(area, maxarea);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int ind = st.pop();
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();
            area = heights[ind] * (nse - pse - 1);
            maxarea = Math.max(maxarea, area);
        }
        return maxarea; 
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if(n == 0) return 0;
        int m = matrix[0].length;
        int sum[][] = new int[n][m];

        // Build sum[][] as row-wise histogram heights
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int val = matrix[i][j] - '0';
                if(i == 0){
                    sum[i][j] = val;
                } else {
                    sum[i][j] = (val == 0) ? 0 : sum[i-1][j] + 1;
                }
            }
        }

        int maxarea = 0;
        for(int i=0;i<n;i++){
            int area = largestRectangleArea(sum[i]);
            maxarea = Math.max(maxarea, area);
        }

        return maxarea;
    }
}
