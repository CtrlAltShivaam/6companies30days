/* 334. Increasing Triplet Subsequence */

/* Given an integer array nums, return true if there exists a triple of indices (i, j, k) 
such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false. */

//naive approach
class Solution {
    public boolean increasingTriplet(int[] nums) {
        //naive approach
        boolean t=false;
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            for(int j=i;j<n-1;j++){
                for(int k=j;k<n;k++){
                    if((i<j && j<k) && (nums[i] < nums[j] && nums[j] < nums[k])) t=true;
                }
            }
        }
        return t;
    }
}

//optimized
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length,left=Integer.MAX_VALUE,mid=Integer.MAX_VALUE;
        if(n<3) return false;
        for(int i=0;i<n;i++){
            if(nums[i]>mid) return true;
            else if(nums[i]>left && nums[i]<mid) mid=nums[i];
            else if(left>nums[i]) left=nums[i];
        }
        return false;
    }
}
