package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mxio
 *
 * https://www.nowcoder.com/practice/0bf071c135e64ee2a027783b80bf781d?tpId=295&tqId=23269&ru=%2Fexam%2Foj&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 *
 * public class TreeNode {
 *     int val = 0;
 *     TreeNode left = null;
 *     TreeNode right = null;
 *     public TreeNode(int val) {
 *       this.val = val;
 *     }
 *   }
 */
public class BM24_二叉树的中序遍历 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */

    public void inorder(List<Integer> list, TreeNode root) {
        // 遇到空节点就返回
        if (root == null) {
            return;
        }
        // 先去左子树
        inorder(list, root.left);
        // 再访问根节点
        list.add(root.val);
        // 最后访问右子树
        inorder(list, root.right);
    }

    public int[] inorderTraversal (TreeNode root) {
        // write code here
        // 添加遍历结果的数组
        List<Integer> list = new ArrayList<>();
        // 递归中序遍历
        inorder(list, root);
        // 返回的结果
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
