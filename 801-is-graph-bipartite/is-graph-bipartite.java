class Solution {
    public boolean dfs( int node, int color[] ,int[][] graph,int currcolor){
        color[node]= currcolor;
        for(int i:graph[node]){
            if(color[i]==color[node]){
                return false;
            }
            if(color[i]==-1){
               int  currcolorofi=1-currcolor;
                if(dfs(i,color,graph,currcolorofi)==false){
                    return false;
                }
            }
        }
        return  true;

    }
    public boolean isBipartite(int[][] graph) {
        int v= graph.length;
        int color[] = new int[v];
        Arrays.fill(color,-1);
        for(int i=0;i<v;i++){
         if(color[i]==-1){
           if(dfs(i,color,graph,0)==false){
            return false;
           }   
         }
        }
        return true;
    }
}