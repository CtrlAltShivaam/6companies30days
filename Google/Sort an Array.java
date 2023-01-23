/* 912. Sort an Array */

/* Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

  */

  //Merge Sort

  class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        sort(nums,0,n-1);
        return nums;
    }
    public void sort(int nums[],int l,int r){
        if(l<r){
            int m=l+(r-l)/2;
            sort(nums,l,m);
            sort(nums,m+1,r);

            merge(nums,l,m,r);
        }

    }
    public void merge(int[] nums, int l,int m,int r){              
        int n1=m-l+1;
        int n2=r-m;

        //temp arrays
        int L[]=new int[n1];
        int R[]=new int[n1];

        for (int i = 0; i < n1; ++i)
            L[i] = nums[l + i];
        for (int i = 0; i < n2; ++i)
            R[i] = nums[m + 1 + i];

        int i=0,j=0;
        int k=l;
        while(i<n1 && j<n2){
            if(L[i]<=R[j])nums[k]=L[i++];
            else nums[k]=R[j++];
            k++;
        }
        while(i<n1) nums[k++]=L[i++];
        while(j<n2) nums[k++]=R[j++];
    }
}
