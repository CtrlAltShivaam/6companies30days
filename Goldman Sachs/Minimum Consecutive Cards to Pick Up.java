/* 2260. Minimum Consecutive Cards to Pick Up */

/* You are given an integer array cards where cards[i] represents the value of the ith card. 
 A pair of cards are matching if the cards have the same value.

Return the minimum number of consecutive cards you have to pick up to have a pair of matching cards 
among the picked cards. If it is impossible to have matching cards, return -1. 
*/

class Solution {
    public int minimumCardPickup(int[] cards) {
        int[] lastIndex=new int[1000001];
        Arrays.fill(lastIndex,-1);
        int ans=Integer.MAX_VALUE;
        for(int i = 0;i<cards.length;i++){
            if(lastIndex[cards[i]]!=-1) ans=Math.min((i-lastIndex[cards[i]]+1),ans);
            lastIndex[cards[i]] = i;
        }
        return ans==Integer.MAX_VALUE ? -1:ans;
    }
}