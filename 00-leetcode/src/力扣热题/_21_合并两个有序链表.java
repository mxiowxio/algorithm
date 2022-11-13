package 力扣热题;

/**
 * @author mxio
 *
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 */
public class _21_合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 创建一个新链表存放
        ListNode result = new ListNode(0);
        ListNode cur = result;
        // 排序
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            }
            else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        // 若还有残余元素
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return result.next;
    }

}
