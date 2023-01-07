// LeetCode Problem Link: https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/

class Solution {
    final int mod = (int)(1e9 + 7);
    int shortest = Integer.MAX_VALUE;
    int ways = 0;
    public int countPaths(int n, int[][] roads) {
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] road : roads){
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }

        PriorityQueue<int []> pq = new PriorityQueue<>((a, b)-> a[1]- b[1]);
        pq.offer(new int[]{0, 0});
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;


        int[] count = new int[n];
        count[0] = 1;
        while(!pq.isEmpty()){
            int[] front = pq.poll();

            for(int[] e: adj.get(front[0])){

                if(e[1]+ front[1] < dist[e[0]]){
                    dist[e[0]] = e[1]+ front[1];
                    pq.offer(new int[]{e[0], dist[e[0]]});
                    count[e[0]] = count[front[0]];
                }
                else if(e[1]+ front[1] == dist[e[0]]){
                    count[e[0]] = (count[e[0]]+ count[front[0]]) %mod;
                }
            }
        }
        return count[n-1]%mod;
    }
}
