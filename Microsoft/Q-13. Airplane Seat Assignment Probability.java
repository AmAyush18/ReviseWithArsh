// LeetCode Problem Link: https://leetcode.com/problems/airplane-seat-assignment-probability/description/

class Solution {
    public double nthPersonGetsNthSeat(int n) {
        // there's just two possibility either you get your seat or you don't
        // that is 50-50 probability
        // so if there's just one seat than it's sure you'll get your seat
        if(n == 1){
            return 1.00;
        }
        // else you got 50% chances of getting
        return 0.500;
    }
}
