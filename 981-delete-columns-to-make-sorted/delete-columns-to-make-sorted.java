class Solution {
    public int minDeletionSize(String[] strs) {
         int deleteCount = 0;
        int numRows = strs.length;
        int numCols = strs[0].length();

        for (int col = 0; col < numCols; col++) {
            for (int row = 1; row < numRows; row++) {
                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    deleteCount++;
                    break; // This column is unsorted, no need to check further
                }
            }
        }

        return deleteCount;
    }
}