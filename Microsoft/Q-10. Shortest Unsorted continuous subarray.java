LeetCode Problem Link: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        // making clone of original array
        int[] sort=nums.clone();
        // sort the clone array to compare later
        Arrays.sort(sort);
        
        // index of first element in unsorted subarray
		int l=-1;        
        // index of last element in unsorted subarray
		int h=-1;
        
        // finding the index of first element in unsorted subarray
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=sort[i]){
                l=i;
                break;
            }
        }
        
        // finding the index of last element in unsorted subarray
        for(int j=nums.length-1;j>=0;j--){
            if(nums[j]!=sort[j]){
                h=j;
                break;
            }
        }
        
        // if l == h means length is zero
        if(l==h) 
            return 0;
        
        // else return the length of unsorted subarray
        return h-l+1;
    }
}
