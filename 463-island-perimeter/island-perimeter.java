class Solution {
    int n,m;
    int peri;
    public int islandPerimeter(int[][] grid) {
       m=grid.length;
       n=grid[0].length;
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]==1){
                dfs(grid,i,j);
            }
        }
       }
       return peri;
    }
    public void dfs(int[][] grid,int i,int j){
        if(i<0 ||i>=m || j<0 || j>=n || grid[i][j]==0){
            peri++;
            return;
        }
        if(grid[i][j]==-1) return ;
        grid[i][j]=-1;

        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}