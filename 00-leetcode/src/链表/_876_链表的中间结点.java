package 链表;

/**
 * @author mxio
 *
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 */
public class _876_链表的中间结点 {
    /**
     * 数组
     * @param head
     * @return
     */
    public ListNode middleNode1(ListNode head) {

        // 建立一个空数组
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;  // 将链表元素放入数组中
            head = head.next;
        }
        return A[t/2];
    }

    /**
     * 单指针法
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        // 第一次遍历：统计链表的总数
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            ++n;
            cur = cur.next;
        }
        // 第二次遍历，返回链表的中间节点
        int k = 0;
        cur = head;
        while (k < n / 2) {
            ++k;
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 快慢指针法
     * @param head
     * @return
     */
    public ListNode middleNode3(ListNode head) {
        // 当快指针走到末尾时，慢指针刚好到中间节点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            // 快慢指针同时指向头节点，快指针走两步，慢指针走一步
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
