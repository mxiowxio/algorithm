package 链表;

/**
 * @author mxio
 *
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 */
public class _83_删除排序链表中重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

}
