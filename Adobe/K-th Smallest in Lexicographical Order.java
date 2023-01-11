/* 440. K-th Smallest in Lexicographical Order
 * 
 * Given two integers n and k, return the kth lexicographically smallest integer in the range [1, n].
 */
//29/69 cases passed
 class Solution {
    public int findKthNumber(int n, int k) {

        // Naive Aproach
        List<String> s = new ArrayList<String>();
    
        for (int i = 1; i <= n; i++)
        {
            s.add(String.valueOf(i));
        }
    
        Collections.sort(s);
        int[] nums=new int[n];
        int l=0;
        for (int i = 0; i < n; i++)
            nums[l++]=Integer.valueOf(s.get(i));
        
        return nums[k-1];
        
    }
}


//Working Soln
class Solution {
    public int findKthNumber(int n, int k) {
        if (n < k || k < 1) return 0;
        else if (n < 10) return k;
        int cur = 1;
        --k;
        while (k > 0) {
            long step = 0, first = cur, last = cur + 1;
            while (first <= n) {
                step =step + Math.min((long)n + 1, last) - first;
                first *= 10;
                last *= 10;
            }
            if (step <= k) {
                ++cur;
                k -= step;
            } 
            else {
                cur *= 10;
                --k;
            }
        }
        return cur;
    }
}

