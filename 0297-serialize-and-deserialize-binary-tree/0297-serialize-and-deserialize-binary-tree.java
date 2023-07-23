/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = "";
        if(root == null){
            res = res+"N,";
            return res;
        }
        res = res + root.val + ",";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    int index = 0;
    public TreeNode deserialize(String data) {
        if(data.length() == index){
            return null;
        }
        if(data.charAt(index) == ','){
            index++;
        }
        if(data.charAt(index) == 'N'){
            index++;
            return null;
        }
        String convert = "";
        while(data.charAt(index) != ','){
            convert += data.charAt(index);
            index++;
        }
        int i = Integer.parseInt(convert); 
        System.out.println(convert);
        TreeNode res = new TreeNode(i);
        res.left = deserialize(data);
        res.right = deserialize(data);
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));