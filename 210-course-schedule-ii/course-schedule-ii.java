class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph= new ArrayList<>();
        int deg[] = new int[ numCourses];
        for(int i=0;i< numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] i:prerequisites){
            int cor=i[0];
            int pre=i[1];
            graph.get(pre).add(cor);
            deg[cor]++;
        }

        Queue<Integer> q= new LinkedList<>();
        List<Integer> res= new ArrayList<>();
        int count=0;
        for(int i=0;i<numCourses;i++){
            if(deg[i]==0){
                res.add(i);
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.poll();
            count++;
            for(int i:graph.get(node)){
                deg[i]--;
                if(deg[i]==0){
                    res.add(i);
                    q.add(i);
                }
            }

        }
        if(count==numCourses){
            return res.stream().mapToInt(x -> x).toArray();

        }else{
            return  new int[0];
        }
    }
}