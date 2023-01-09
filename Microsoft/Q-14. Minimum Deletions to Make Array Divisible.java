// LeetCode Problem Link: https://leetcode.com/problems/minimum-deletions-to-make-array-divisible/description/

class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        // first let's find the gcd of numsDivide
        int g = numsDivide[0];
        for(int i = 1; i < numsDivide.length; i++){
            g = gcd(g, numsDivide[i]);
        }
        // Sort to the array to find the first number that divides all of numsDivide
        Arrays.sort(nums);

        int i = 0;
        for( ; i < nums.length; i++){
            if((g % nums[i]) == 0){
                break;
            }
        }
        // if we didn't found any such element that divides gcd of numsDivide
        if(i == nums.length){
            return -1;
        }
        // otherwise return i because that's number of deletions you need
        return i;
    }

    // finding gcd using euclidean formula
    private int gcd(int num1, int num2){
        if(num2 == 0) return num1;

        return gcd(num2, num1%num2);
    }
}
