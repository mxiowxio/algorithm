package 链表;

/**
 * @author mxio
 *
 * https://leetcode.cn/problems/remove-linked-list-elements/
 */
public class _203_移除链表元素 {
    /**
     * 迭代
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;      // 新建新的头节点
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {     // 如果当前值等于给定的值
                temp.next = temp.next.next; // 删除当前节点
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 递归
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

}
