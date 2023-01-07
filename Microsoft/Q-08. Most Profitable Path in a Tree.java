// LeetCode Problem Link: https://leetcode.com/problems/most-profitable-path-in-a-tree/description/

class Solution {
    int[] parent; int[] dist;
    ArrayList<ArrayList<Integer>> tree;

    Set<Integer> vis;
    int ans;
    int maxAns;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {

        int n = edges.length;
        
        // constructing tree as adjacency list
        tree = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            tree.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        // finding parent of each node 
        parent = new int[n + 1];
        dist = new int[n + 1];
        
        Arrays.fill(parent, -1);
        Arrays.fill(dist, -1);

        findParent(0, 0, 0);

        vis = new HashSet<>();
        ans = 0;
        maxAns = Integer.MIN_VALUE;

        int curr = bob;
        int currDist = 0;
        while(curr > 0){
            //if distance of current Node is greater than current
            // Distance means Bob reaches this node first hence alice is not concerned
            // about the payment of this node so we do amount[curr] = 0;
            if(dist[curr] > currDist){
                amount[curr] = 0;
            }
            // if by chance they both reach at same time
            // so we divide the amount into halves
            else if(dist[curr] == currDist){
                amount[curr] /= 2;
            }
            // now we send bob to it's parent bcoz his ultimate goal is to reach root('0')
            curr = parent[curr];
            currDist++;
        }      
        // so we start our dfs from 0th node bcoz that's where alice is
        // and also pass the amount array for reference
        dfs(0, amount); 

        return maxAns;
    }

    // function to find parent of each node
    private void findParent(Integer currNode, int currParent, int currDist){
        dist[currNode] = currDist;
        parent[currNode] = currParent;

        for(Integer neighbour : tree.get(currNode)){
            if(neighbour == currParent){
                continue;
            }
            findParent(neighbour, currNode, currDist + 1);
        }
    }

    private void dfs(int node, int[] amount){
        vis.add(node);
        // add the amount of current node to temporary answer
        ans += amount[node];
        // variable to count how many node we're visiting from this
        int trav = 0;

        for(Integer neighbour : tree.get(node)){
            if(vis.contains(neighbour)){
                continue;
            }
            trav++;
            dfs(neighbour, amount);
        }

        // if number of nodes traversed from this current node is zero then it's a leaf node so we update the maxAns
        if(trav == 0){
            maxAns = Math.max(ans, maxAns);
        }
        // backtrack so that you can explore other paths
        ans -= amount[node];
    }
    
}
