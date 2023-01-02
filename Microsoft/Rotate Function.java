//Bruteforce

class Solution {
    public int maxRotateFunction(int[] nums) {
        int n=nums.length,max=0;
        if(n==0 || n==1) return 0;
        for(int x = 0; x < n; x++){
                max+=x*nums[x];//25
            }
        for(int i = 1; i < n; i++){
            Rotate(i,nums);   
            int F=0;
            for(int x = 0; x < n; x++){
                F+=x*nums[x];
            }
            if(F>max) max=F;
               
        }  
        return max;
    }
    public void Rotate(int d,int nums[])  {
            int n=nums.length;
            int arr[]=new int[n];
            arr[0]=nums[n-1];
            for(int i = 1; i < n; i++){ 
                arr[i]=nums[i-1];
            }
            for(int i=0; i < n; i++)  
            nums[i]=arr[i];
        }
}