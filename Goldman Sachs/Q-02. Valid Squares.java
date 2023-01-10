// LeetCode Problem Link: https://leetcode.com/problems/valid-square/description/

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] sides = new int[][]{p1, p2, p3, p4};

        Set<String> s = new HashSet<>();

        for(int[] side : sides){
            s.add(side[0] + " " + side[1]);
        }

        if(s.size() != 4) return false;

        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < 4; i++){
            for(int j = i+1; j < 4; j++){
                
                int side = calcDist(sides[i], sides[j]);
                // System.out.print(side + " ");
                mp.put(side, mp.getOrDefault(side, 0)+1);
            }
        }

        if(mp.size() > 2) return false;

        // System.out.println(mp.size());

        if(mp.size() == 1 && mp.containsKey(0)){
            return false;
        }

        for(int side : mp.keySet()){
            // System.out.print(mp.get(side));
            if(mp.get(side) != 2 && mp.get(side) != 4 && mp.get(side) != 6){
                return false;
            }
        }
        
        return true;
    }

    private int calcDist(int[] p1, int[] p2){
        int side = (((p2[0] - p1[0])*(p2[0] - p1[0])) + ((p2[1] - p1[1])*(p2[1] - p1[1])));
        return side;
    }
}
