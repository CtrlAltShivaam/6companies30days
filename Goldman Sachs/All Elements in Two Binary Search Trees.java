/*
 * Given two binary search trees root1 and root2, 
 * return a list containing all the integers from both trees sorted in ascending order.

 */

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans=new ArrayList<>();
        traverse(root1,ans);
        traverse(root2,ans);
        Collections.sort(ans);
        return ans;
    }
    void traverse(TreeNode node,List<Integer> ans)
    {
        if (node == null)
            return;
        traverse(node.left,ans);
        ans.add(node.val);
        traverse(node.right,ans);
    }
}