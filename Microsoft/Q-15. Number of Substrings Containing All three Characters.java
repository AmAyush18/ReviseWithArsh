// LeetCode Problem Link: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/

class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq = new int[3];

        int ans = 0;
        int n = s.length();
        int left = 0;
        for(int i = 0; i < n; i++){
            int ch = s.charAt(i);
            freq[ch - 'a']++;

            while(left < n && freq[0] >= 1 && freq[1] >= 1 && freq[2] >= 1){
                ans+=(n-i);
                ch = s.charAt(left);
                freq[ch-'a']--;    
                left++;
            }
        }

        return ans;        
    }
}
