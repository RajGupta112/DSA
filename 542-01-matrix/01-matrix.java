class Solution {
    int m,n;
    int [][] directions= {{-1,0},{1,0},{0,-1},{0,1}};

    public int[][] updateMatrix(int[][] mat) {
        m=mat.length;
        n=mat[0].length;
        Queue<int[]> q= new LinkedList<>();
        int [][] res=new int [m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    res[i][j]=0;
                    
                    q.offer(new int[] {i,j});
                }else{
                    res[i][j]=-1;
                }
            }
        }
        while(!q.isEmpty()){
            int [] cell=q.poll();
            int i=cell[0];
            int j=cell[1];
            for(int[] di:directions){
                int ni=i+di[0];
                int nj=j+di[1];

                if(ni>=0 && ni<m && nj>=0 && nj<n && res[ni][nj]==-1){
                res[ni][nj]=res[i][j]+1;
                q.offer(new int []{ni,nj});
                }
            }
        }
        return res;
    }
}