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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        TreeNode curr = root;
        int left = 0;
        while(curr != null){
            left++;
            curr = curr.left;
        }
        curr = root;
        int right = 0;
        while(curr != null){
            right++;
            curr = curr.right;
        }

        if(left == right){
            return (int)Math.pow(2, left)-1;
        }else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}