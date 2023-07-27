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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            TreeNode temp = new TreeNode(val);
            return temp;
        }
        if(root.val > val){
            if(root.left == null){
                TreeNode temp = new TreeNode(val);
                root.left = temp;
            }else{
            insertIntoBST(root.left, val);}
        }else{
            if(root.right == null){
                TreeNode temp = new TreeNode(val);
                root.right = temp;
            }else{
            insertIntoBST(root.right, val);}
        }
        return root;
    }
}