class Solution {
    public boolean iscycle(int curr,  boolean vis[], boolean rec[],List<List<Integer>> g){
        vis[curr]=true;
        rec[curr]=true;
        for(int i:g.get(curr)){
            if(!vis[i] && iscycle(i,vis,rec,g)){
                return true;
            }else if(rec[i]==true){
                return true;
            }

        }
        rec[curr]=false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v= graph.length;
        List<List<Integer>> g= new ArrayList<>();
        List<Integer> l= new ArrayList<>();
         boolean vis[]= new boolean[v];
         boolean rec[]= new boolean[v];
         for(int i=0;i<v;i++){
            g.add(new ArrayList<>());
            for(int u:graph[i]){
                g.get(i).add(u);
            }
         }
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                iscycle(i, vis, rec, g);
            }
        }


         for(int i=0;i<v;i++){
            if(rec[i]==false)
        l.add(i);

         }
         return l;
    }
}