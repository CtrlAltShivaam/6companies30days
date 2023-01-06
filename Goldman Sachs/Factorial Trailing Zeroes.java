/*
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 */

 class Solution {
    public int trailingZeroes(int n) {
        if(n==0) return 0;
        int count=0;
        for (int i = 5; n / i >= 1; i *= 5)
            count += n / i;
        return count;
    }
}