package 链表;

/**
 * https://leetcode.cn/problems/delete-node-in-a-linked-list/
 *
 * @author mxio
 */
public class _237_删除链表中的节点 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
