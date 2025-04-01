class Solution {
    public int findCircleNum(int[][] isConnected) {
List<List<Integer>> adj = new ArrayList<>();
        int n=isConnected.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                }
            }
        }

        boolean vis[]= new boolean[n];
        int count =0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,adj,vis);
                count++;
            }
        }
        return count;
    }
    public void dfs(int node,List<List<Integer>> adj,boolean vis[]){
        vis[node]=true;
        for(int it:adj.get(node)){
            if(!vis[it]){
                dfs(it,adj,vis);
            }
        }
    }
}