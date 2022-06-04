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
    public int diameterOfBinaryTree(TreeNode root) {  
        if(root == null){
            return 0;
        }
        
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int height = getHeight(root.left) + getHeight(root.right);
        
        return Math.max(height, Math.max(left, right));
    }
    
    private int getHeight(TreeNode node){
        if (node == null){
            return 0;
        }

        int left = getHeight(node.left);
        int right = getHeight(node.right);
        
        return Math.max(left, right) + 1;
    }
}
