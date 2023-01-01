// LeetCode Problem Link: https://leetcode.com/problems/bulls-and-cows/description/

// Approach - 1 
// T.C: O(N) | S.C: O(N)
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

// Approach - 2
// T.C: O(N) | S.C: O(1)
class Solution {
    public String getHint(String secret, String guess) {
        
        int bulls = 0, cows = 0;
        // to keep track of all the numbers;
        int[] track = new int[10];

        for(int i = 0; i < secret.length(); i++){
            int a = secret.charAt(i)-'0';
            int b = guess.charAt(i)-'0';
            // if both numbers are different
            // means they are either misplaced or extra number
            if(a != b){
                // if track[a] < 0 means it was guessed earlier but at wrong place
                if(track[a] < 0) cows++;
                // if track[b] > 0 means the number b is present in secret number but at different place
                if(track[b] > 0) cows++;

                track[a]++; // increment the current number found in secret
                track[b]--; // decrement the current number guessed
            }
            // if a and b are same means bulls++
            else bulls++;
        }

        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }
}
