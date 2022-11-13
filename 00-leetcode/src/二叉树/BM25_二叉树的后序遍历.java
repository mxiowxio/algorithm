package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mxio
 *
 * https://www.nowcoder.com/practice/1291064f4d5d4bdeaefbf0dd47d78541?tpId=295&tqId=23269&ru=%2Fexam%2Foj&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 *
 *  public class TreeNode {
 *     int val = 0;
 *     TreeNode left = null;
 *     TreeNode right = null;
 *     public TreeNode(int val) {
 *       this.val = val;
 *     }
 *   }
 */
public class BM25_二叉树的后序遍历 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */

    public void postorder(List<Integer> list, TreeNode root) {
        // 遇到空节点就返回
        if (root == null) {
            return;
        }
        // 先去左子树
        postorder(list, root.left);
        // 再去右子树
        postorder(list, root.right);
        // 最后根节点
        list.add(root.val);
    }

    public int[] postorderTraversal (TreeNode root) {
        // write code here
        // 添加遍历结果的数组
        List<Integer> list = new ArrayList<>();
        // 递归中序遍历
        postorder(list, root);
        // 返回的结果
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
