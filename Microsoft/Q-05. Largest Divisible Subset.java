// LeetCode Problem Link: https://leetcode.com/problems/largest-divisible-subset/description/

class Solution {
    List<Integer> ans;
    int[] dp;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        ans = new ArrayList<>();
        // recursive approach
        // recur(nums, 0, new ArrayList<>(), 1);

        // recursive + memoization
        // we store length of current list at any particular index
        dp = new int[nums.length]; 
        Arrays.fill(dp, -1);
        recMem(nums, 0, new ArrayList<>(), 1);

        return ans;
    }

    private void recur(int[] nums, int idx, List<Integer> curr, int prev){
        if(curr.size() > ans.size()){
            ans = new ArrayList<>(curr);
        }

        for(int i = idx; i < nums.length; i++){
            if(nums[i] % prev == 0){
                curr.add(nums[i]);
                recur(nums, i + 1, curr, nums[i]);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private void recMem(int[] nums, int idx, List<Integer> curr, int prev){
        if(curr.size() > ans.size()){
            ans = new ArrayList<>(curr);
        }

        for(int i = idx; i < nums.length; i++){
            if(curr.size() > dp[i] && nums[i] % prev == 0){
                dp[i] = curr.size();
                curr.add(nums[i]);
                recMem(nums, i + 1, curr, nums[i]);
                curr.remove(curr.size()-1);
            }
        }
    }
}
