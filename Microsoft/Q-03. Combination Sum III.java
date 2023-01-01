// LeetCode Problem Link: https://leetcode.com/problems/combination-sum-iii/

class Solution {
    List<List<Integer>> allCombinations;
    List<Integer> currentCombination;
    public List<List<Integer>> combinationSum3(int k, int n) {
        allCombinations = new ArrayList<>();
        currentCombination = new ArrayList<>();
        findCombinations(k, n, 1);

        return allCombinations;
    }

    private void findCombinations(int k, int sum, int startIdx){
        if(sum == 0 && k == 0){
            allCombinations.add(new ArrayList(currentCombination));
            return;
        }

        for(int i = startIdx; i <= 9; i++){
            currentCombination.add(i);
            findCombinations(k-1, sum-i, i+1);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
