// LeetCode Problem Link: https://leetcode.com/problems/bulls-and-cows/description/

class Solution {
    public String getHint(String secret, String guess) {
      
        int bulls = 0;
        HashMap<Character, Integer> s = new HashMap<>();
        HashMap<Character, Integer> g = new HashMap<>();
        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
            }else{
                s.put(secret.charAt(i), s.getOrDefault(secret.charAt(i), 0) + 1);
                g.put(guess.charAt(i), g.getOrDefault(guess.charAt(i), 0) + 1);
            }
        }     
        int cows = 0;
        for(Character key : s.keySet()){
            if(g.containsKey(key)){
                cows += Math.min(s.get(key), g.get(key));
            }
        }

        String ans = bulls + "A" + cows + "B";

        return ans;
    }
}
