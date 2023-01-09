// LeetCode Problem Link: https://leetcode.com/problems/number-of-pairs-satisfying-inequality/description/

class Solution {
    private int dif;

    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        dif = diff;
        int n = nums1.length;
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = nums1[i] - nums2[i];
        }

        return mergeSort(nums, 0, n - 1);
    }

    //Time: O(lgN * N); Space:O(lgN)
    private long mergeSort(int[] nums, int left, int right) {
        if (right == left) return 0;

        int mid = (left + right) / 2;
        long count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        for (int i = mid, j = right; i >= left && j >= mid + 1;){
            if (nums[i] <= nums[j] + dif) {
                count += i - left + 1;j--;
            } 
            else{ 
                i--;
            }
        }
        merge(nums, left, mid, mid + 1, right);
        return count;
    }

    //Time: O(N); Space:O(N)
    private void merge(int[] nums, int left1, int right1, int left2, int right2){
        if (left1 == left2){ 
            return;
        }

        int[] data = Arrays.copyOfRange(nums, left1, right1 + 1);
        int idx = 0;
        while (idx < data.length && left2 <= right2) {
            nums[left1++] = data[idx] <= nums[left2] 
                            ? data[idx++] 
                            : nums[left2++];
        }
        while (idx < data.length){ 
            nums[left1++] = data[idx++];
        }
        
        while (left2 <= right2){ 
            nums[left1++] = nums[left2++];
        }
    }
}
