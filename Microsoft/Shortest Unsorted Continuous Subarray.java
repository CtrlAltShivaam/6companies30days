/*
 * Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray 
 * in ascending order, then the whole array will be sorted in ascending order.
 * Return the shortest such subarray and output its length.
 * 
 * 
 */

 class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE,left=1,right=0;
        int n=nums.length;
        if(n<2) return 0;
        for(int i = 0, j = n - 1; i < n; ++i, --j){
            if(max > nums[i])
                right = i;
            else
                max = nums[i];
            if(min < nums[j])
                left = j;
            else
                min = nums[j];
        }
        return right-left+1;
    }
}