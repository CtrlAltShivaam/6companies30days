import java.util.*;

/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. 
 * The list must not contain the same combination twice, and the combinations may be returned in any order.
 */
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result=new ArrayList();
            combination(1,k,n,new LinkedList(),result);
            return result;
        }
        private void combination(int start,int k,int n, LinkedList l1,List<List<Integer>>result){
            if(k<0 || n<0)
            return;
            if(k==0 && n==0){
                result.add(new ArrayList(l1));
                return;
            }
            for(int i=start; i<=9;i++){
                l1.add(i);
                combination(1+i,k-1,n-i,l1,result);
                l1.removeLast();
            }
        }
    }

