// LeetCode Problem Link: https://leetcode.com/problems/increasing-triplet-subsequence/description/

class Solution {
    public boolean increasingTriplet(int[] nums) {

        if(nums.length < 3){
            return false;    
        }
        
        int x = nums[0];
        int y = Integer.MAX_VALUE;
        int n = nums.length;
        int i = 1;

        while(i<n){
            // this gives us a first number
            if(nums[i]<x){
                x = nums[i];
            }
            // this gives the middle element
            if(nums[i]>x && nums[i]<y){ 
                y = nums[i];
            }
            // if this condition meet, means we got our third
            if(nums[i]>y) return true;
            
            i++;
        }
        
        return false;
    }
}
