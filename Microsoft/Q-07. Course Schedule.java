// LeetCode Problem Link: https://leetcode.com/problems/course-schedule/description/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        int[] indeg = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            for(Integer node : adj.get(i)){
                indeg[node]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indeg[i] == 0) q.add(i);
        }

        // to count number of tasks being able to complete
        int i = 0;
        while(!q.isEmpty()){
            Integer node = q.poll();
            i++;

            for(Integer a : adj.get(node)){
                indeg[a]--;
                if(indeg[a] == 0) q.add(a);
            }
        }

        // if i is equal to number of courses
        // that means we are able to take all courses
        return i == numCourses;
    }
}
