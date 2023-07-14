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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
      TreeNode root = attach(nums, 0, nums.length-1);
      return root;
    }
    TreeNode attach(int[] nums, int s, int e){
        if(s > e){
            return null;
        }
        if(s == e){
            return new TreeNode(nums[s]);
        }
        int max = make(nums, s, e);
        TreeNode temp = new TreeNode(nums[max]);
        temp.left = attach(nums, s, max-1);
        temp.right = attach(nums, max+1, e);
        return temp;
    }
    int make(int[] nums, int s, int e){
      int max = s;
      for(int i = s; i <= e; i++){
          if(nums[i] > nums[max]){
              max = i;
          }
      }  
    //   TreeNode temp = new TreeNode(nums[max]);
    // System.out.println(nums[max]);
      return max;
    }
}