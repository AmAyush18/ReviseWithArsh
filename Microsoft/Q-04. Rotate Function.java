// LeetCode Problem Link: https://leetcode.com/problems/rotate-function/description/

class Solution {
    public int maxRotateFunction(int[] nums) {
        int max = 0, 
        f0 = 0,   // to store F(0) = 0*nums[0] + 1*nums[1] + 2*nums[2]...
        n = nums.length,
        sum = 0; // to store sum = nums[0] + nums[1] + nums[2]...

        for(int i = 0; i < n; i++){
            f0 += (i * nums[i]);
            sum += nums[i];
        }

        max = f0;
        int prev = f0;
        int curr;

        for(int i = 1; i < n; i++){
            // F(k) = F(k-1) + sum - n*nums[n-k]
            curr = prev + sum - n*nums[n-i];
            max = Math.max(max, curr);
            prev = curr;  //updating previous
        }

        return max;
    }
}
