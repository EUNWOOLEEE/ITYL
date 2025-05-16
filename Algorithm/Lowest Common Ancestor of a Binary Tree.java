/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode answer = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return answer;
    }

    public TreeNode dfs(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null)
            return null;

        if (cur == p || cur == q) {
            TreeNode a = dfs(cur.left, p, q);
            TreeNode b = dfs(cur.right, p, q);
            if (a != null || b != null)
                answer = cur;
            return cur;
        }

        TreeNode a = dfs(cur.left, p, q);
        TreeNode b = dfs(cur.right, p, q);

        if (a != null && b != null)
            answer = cur;
        
        return a != null ? a : b;
    }
}
