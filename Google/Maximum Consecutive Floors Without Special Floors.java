/*2274. Maximum Consecutive Floors Without Special Floors */

/*Alice manages a company and has rented some floors of a building as office space. Alice has decided some of these floors should be special floors, used for relaxation only.

You are given two integers bottom and top, which denote that Alice has rented all the floors from bottom to top (inclusive). You are also given the integer array special, where special[i] denotes a special floor that Alice has designated for relaxation.

Return the maximum number of consecutive floors without a special floor. */


class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        //O(n)
        Arrays.sort(special);
        int ans=Integer.MIN_VALUE;
        for(int j=0;j<special.length;j++){
            ans=Math.max(special[j]-bottom,ans);
            bottom=special[j]+1;
        }
        ans=Math.max(top-special[special.length-1],ans);
        return ans;


        /* O(n^2)
        int max=Integer.MIN_VALUE;
        int count=0;
        for(int i=bottom;i<=top;i++){
            count++;
            for(int j=0;j<special.length;j++){
                if(special[j]==i)
                count=0;
            }
            max=Math.max(max,count);
        }
        return max;
*/
    }
}