

/* 2523. Closest Prime Numbers in Range */

/* Given two positive integers left and right, find the two integers num1 and num2 such that:
 left <= nums1 < nums2 <= right .
 nums1 and nums2 are both prime numbers.
 nums2 - nums1 is the minimum amongst all other pairs satisfying the above conditions.
 Return the positive integer array ans = [nums1, nums2]. If there are multiple pairs satisfying 
 these conditions, return the one with the minimum nums1 value or [-1, -1] if such numbers do not exist.

 A number greater than 1 is called prime if it is only divisible by 1 and itself.

  */
import java.util.*;
  class Solution {
    public int[] closestPrimes(int left, int right) {
        List<Integer> primes = getPrimes(left,right);

        int[] ans = new int[]{0,Integer.MAX_VALUE}; 
        int max = ans[1]-ans[0];
        for( int i =0;i< primes.size()-1;i++){  
                int diff = primes.get(i+1)-primes.get(i);
                if(diff < max){
                    ans[0] = primes.get(i);
                    ans[1] = primes.get(i+1);
                    max = ans[1]-ans[0];
                }
        }
        if(max == Integer.MAX_VALUE) return new int[]{-1,-1};
        return ans;


    }
    public List<Integer> getPrimes(int left,int right ){
        List<Integer> primes = new ArrayList<>();
        int[] sieve = new int[1_000_001];
        Arrays.fill(sieve,1);
        for(int i = 2;i<=right;i++){
            if(sieve[i] == 1){
                if(i>=left) primes.add(i);
                for(int j=2*i ; j<=right;j+=i){
                    sieve[j]=0;
                }
            }
        }
        return primes;
    }
}