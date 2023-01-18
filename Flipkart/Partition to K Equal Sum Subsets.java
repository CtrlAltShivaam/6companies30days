/* 698. Partition to K Equal Sum Subsets */

/* Given an integer array nums and an integer k, 
* return true if it is possible to divide this array into k non-empty subsets whose sums are all equal. 
*/

//Sab upar se gya

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int N=nums.length;
        if(k==1) return true;
        if(N<k) return false;
        int sum=0;
        for(int i: nums) sum+=i;
        if(sum%k!=0) return false;
        int target=sum/k;
        int[] targetsum=new int[k];
        boolean[] taken= new boolean[N];

        //intitalize sum of each subset from 0
        for(int i=0;i<k;i++) targetsum[i]=0;
        //and mark element as not taken
        for(int i=0;i<N;i++) taken[i]=false;

        targetsum[0]=nums[N-1];
        taken[N-1]=true;

        return isKpartitionPossible(nums,targetsum,taken,target,k,N,0,N-1);
    }
    static boolean isKpartitionPossible(int nums[],int targetsum[],boolean taken[],int target,int k,int N,int currIndex,int limitIndex){
        if(targetsum[currIndex]==target){
            if(currIndex==k-2) return true;
            return isKpartitionPossible(nums,targetsum,taken,target,k,N,currIndex+1,N-1);
        }
        for(int i=limitIndex;i>=0;i--){
            if(taken[i]) continue;
            int tmp= targetsum[currIndex] + nums[i];
            if(tmp<=target){
                taken[i]=true;
                targetsum[currIndex]+=nums[i];
                boolean nxt = isKpartitionPossible(nums,targetsum,taken,target,k,N,currIndex,i-1);
                taken[i]= false;
                targetsum[currIndex] -= nums[i];
                if(nxt) return true;
            }
        }
        return false;
    }
}