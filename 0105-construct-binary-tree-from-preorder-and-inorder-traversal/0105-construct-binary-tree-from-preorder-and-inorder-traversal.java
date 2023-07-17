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
    public TreeNode buildTree(int[] pre, int[] in) {
        return creat(pre, in, 0, in.length-1);
    }
    int preIndex = 0;
    TreeNode creat(int[] pre, int[] in, int is, int ie){
        if(is > ie){
            return null;
        }
        TreeNode root = new TreeNode(pre[preIndex++]);
        int inIndex = -2;
        for(int i = is; i <= ie; i++){
            if(in[i] == root.val){
                inIndex = i;
            }
        }

        root.left = creat(pre, in, is, inIndex-1);
        root.right = creat(pre, in, inIndex+1, ie);
        return root;
    }
}