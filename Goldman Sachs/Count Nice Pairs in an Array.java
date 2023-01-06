/*
 * You are given an array nums that consists of non-negative integers. 
 * Let us define rev(x) as the reverse of the non-negative integer x. For example, rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it satisfies all of the following conditions:
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * Return the number of nice pairs of indices. 
 * Since that number can be too large, return it modulo 109 + 7.
 */

//83/84 test cases passed

 class Solution {
    int reverse(int n){
        int result=0;
        while(n!=0){
            result=result*10+(n%10);
            n/=10;
        }
        return result;
    }
    public int countNicePairs(int[] nums) {
        Map<Integer, Long> map = new HashMap<>();;
        int d=nums.length,count=0,mod=1_000_000_007;
        for(int i: nums){
            int diff=i-reverse(i);
            map.put(diff,map.getOrDefault(diff,0L)+1);
        }
        for(long freq: map.values()){
            count+=freq*(freq-1)/2;
            count%=mod;
        }
        return count;
    }
}