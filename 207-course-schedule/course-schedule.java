import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build the graph (adjacency list)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 2: Create in-degree array
        int[] inDegree = new int[numCourses];

        // Step 3: Fill the graph and in-degree
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            graph.get(prereq).add(course); // prereq → course
            inDegree[course]++;
        }

        // Step 4: Initialize queue with courses that have no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 5: Process the courses
        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            completedCourses++;

            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 6: If all courses are completed, return true
        return completedCourses == numCourses;
    }
}
