package tao.contest.monthly.challenge202006;
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
class Solution0601 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        if (root.left == null && root.right == null) return root;
        if (root.left!=null){
            invertTree(root.left);
        }
        if (root.right!=null){
            invertTree(root.right);
        }
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        return root;
    }

    public static void main(String[] args) {
        Solution0601 s = new Solution0601();
        TreeNode root = new TreeNode(4);
        TreeNode firstLeft = new TreeNode(2);
        firstLeft.left = new TreeNode(1);
        firstLeft.right = new TreeNode(3);
        TreeNode firstRight = new TreeNode(7);
        firstRight.left = new TreeNode(6);
        firstRight.right = new TreeNode(9);
        root.left = firstLeft;
        root.right = firstRight;
        final TreeNode result = s.invertTree(root);
    }
}