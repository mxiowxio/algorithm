package 力扣热题;

/**
 * @author mxio
 *
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 * 分治法
 *
 */
public class _23_合并K个升序链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    /**划分合并区间函数*/
    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        // 从中间分成两段，再将合并好的两段合并
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        // 若一个为空，则直接返回另一个
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        // 新增一个表头
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        // 两个链表都不要为空
        while (aPtr != null && bPtr != null) {
            // 取较小值的节点
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                // 只移动取值的指针
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                // 只移动取值的指针
                bPtr = bPtr.next;
            }
            // 指针后移
            tail = tail.next;
        }
        // 哪个链表还有剩，直接连在后面
        tail.next = (aPtr != null ? aPtr : bPtr);
        // 返回值去掉表头
        return head.next;
    }

}
