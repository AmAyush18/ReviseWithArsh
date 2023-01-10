// LeetCode Problem Link: https://leetcode.com/problems/factorial-trailing-zeroes/description/

class Solution {
    public int trailingZeroes(int n) {
        int x = 0;

        while(n > 0){
            x += (n/5);
            n /= 5;
        }

        return x;
    }
}
