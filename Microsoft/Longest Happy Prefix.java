/* Naive Approach
 *  TLE 61/75 test cases passed





 * A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).
 * 
 * Given a string s, return the longest happy prefix of s. Return an empty string "" if no such prefix exists.

 
 */

 //Naive Approach
class Solution {
    public String longestPrefix(String s) {
        int n=s.length();
        String happy="",Prefix="",Suffix="";
        for(int i=0,j=n-1; i<n-1;i++,j--){
            Prefix =s.substring(0,i+1);
            Suffix =s.substring(j);

            if(Prefix.equals(Suffix))
            happy=Prefix;
        }
        return happy;
    }
}