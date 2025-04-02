class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
if(color==image[sr][sc]) return image;
dfs(image,sr,sc,color,image[sr][sc]);
return image;

    }
    public void dfs(int[][] image, int i, int j, int color,int oldcolor){
        if(i<0 || j<0 || i>=image.length ||j>=image[0].length || image[i][j]!=oldcolor) return;
        image[i][j]=color;
        dfs(image,i+1,j,color,oldcolor);
        dfs(image,i-1,j,color,oldcolor);
        dfs(image,i,j+1,color,oldcolor);
        dfs(image,i,j-1,color,oldcolor);
    }
}