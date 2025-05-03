import java.util.*;

public class Solution {
    boolean isCycle(int curr, boolean vis[] ,boolean rec[], List<List<Integer>> graph){
        vis[curr]=true;
        rec[curr]=true;
        for( int i:graph.get(curr)){
            if(!vis[i] && isCycle(i,vis,rec,graph)){
                return true;
            }
            else if(rec[i]==true){
                return true;
            }
           
        }
        rec[curr]=false;
        return false;

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

       boolean vis[] = new boolean [numCourses];
         boolean rec[]= new   boolean [numCourses];

       
       

        
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            graph.get(prereq).add(course); 
          
        }

        for(int i=0;i<numCourses;i++){
            if(!vis[i] && isCycle(i,vis,rec,graph)){
                return false;
            }
        }
        return true;

       
        
    }
}
