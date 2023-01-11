/* 659. Split Array into Consecutive Subsequences */

/* 
 * You are given an integer array nums that is sorted in non-decreasing order.
 * Determine if it is possible to split nums into one or more subsequences such that 
 * both of the following conditions are true:
 * Each subsequence is a consecutive increasing sequence 
 * (i.e. each integer is exactly one more than the previous integer).
 * 
 * All subsequences have a length of 3 or more
 * Return true if you can split nums according to the above conditions, or false otherwise.
 * 
 //A subsequence of an array is a new array that is formed from the original 
 //array by deleting some (can be none) of the elements without disturbing the 
 //relative positions of the remaining elements. (i.e., [1,3,5] is a subsequence of 
 //[1,2,3,4,5] while [1,3,2] is not).
 */

 class Solution {
    public boolean isPossible(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1] == b[1]){
                return (a[1]-a[0]+1)-(b[1]-b[0]+1);
            }
            return a[1]-b[1];
        });
        for(int i:nums){
            while(pq.size() > 0 && pq.peek()[1]+1<i){
                int[] r=pq.remove();
                if(r[1]-r[0] +1<3) return false;
            }

            if(pq.size()==0 || pq.peek()[1]==i) pq.add(new int[]{i,i});
            else{
                int[] pr=pq.remove();
                pq.add(new int[]{pr[0],i});
            }
        }
        while(pq.size()>0){
            int[] s = pq.remove();
            if(s[1]-s[0]+1 < 3) return false;
        }
        return true;
    }
}