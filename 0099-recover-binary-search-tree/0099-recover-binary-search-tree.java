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
    public void recoverTree(TreeNode root) {
        // creating array to store the values of inorder travarsal
        ArrayList<TreeNode> arr = new ArrayList<TreeNode>();

        // calling inorder method
        inorder(root, arr);

        // helper nodes to store the two defect nodes
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        TreeNode first = null;
        TreeNode second = null;

        // finding the two elements
        for(int i = 0; i < arr.size(); i++){
            TreeNode temp = arr.get(i);
            if(pre.val > temp.val){
                if(first == null){
                    first = pre;
                }
                second = temp;
            }
            pre = temp;
        }

        // swaping
        if(first != null){
            TreeNode temp = new TreeNode(0);
            temp.val = first.val;
            first.val = second.val;
            second.val = temp.val;
        }
    }

    // inorder traversal
    void inorder(TreeNode root, ArrayList<TreeNode> arr){
        if(root == null){
            return;
        }
        inorder(root.left, arr);
        arr.add(root);
        inorder(root.right, arr);
    }
}