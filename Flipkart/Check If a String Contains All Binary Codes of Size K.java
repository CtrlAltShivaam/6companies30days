/* 1461. Check If a String Contains All Binary Codes of Size K */

/* Given a binary string s and an integer k, 
return true if every binary code of length k is a substring of s. 
Otherwise, return false. */

class Solution {
    public boolean hasAllCodes(String s, int k) {
        int len = s.length(), count = 1 << k;
        if (k > len) return false;
        int num = k > 1 ? Integer.parseInt(s.substring(len - k + 1), 2) << 1 : 0;
        boolean[] seen = new boolean[count];
        for (int i = len - k; i >= 0; i--) {
            num = (((s.charAt(i) - '0') << k) + num) >> 1;
            if (!seen[num]) {
                seen[num] = true;
                count--;
            }
            if (count == 0) return true;
            if (i < count) return false;
        }
        return false;
    }
}