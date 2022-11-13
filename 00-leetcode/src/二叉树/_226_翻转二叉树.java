package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mxio
 * <p>
 * https://leetcode.cn/problems/invert-binary-tree/
 * <p>
 * 层次遍历
 */
public class _226_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode treeNode = node.left;
            node.left = node.right;
            node.right = treeNode;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

}
