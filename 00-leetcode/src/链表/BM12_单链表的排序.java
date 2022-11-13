package 链表;

/**
 * @author mxio
 *
 * https://www.nowcoder.com/practice/f23604257af94d939848729b1a5cda08?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Foj
 */
public class BM12_单链表的排序 {

    /**
     * 快慢指针
     */

    /** 合并两段有序链表*/
    ListNode merge(ListNode pHead1, ListNode pHead2) {
        // 一个已经空了，直接返回另一个
        if (pHead1 == null) {
            return pHead2;
        }
        if (pHead2 == null) {
            return pHead1;
        }
        // 加一个表头
        ListNode head = new ListNode(0);
        ListNode cur = head;
        // 两个链表都不要为空
        while (pHead1 != null && pHead2 != null) {
            // 取较小值的节点
            if (pHead1.val <= pHead2.val) {
                cur.next = pHead1;
                // 只移动取值的指针
                pHead1 = pHead1.next;
            } else {
                cur.next = pHead2;
                // 只移动取值的指针
                pHead2 = pHead2.next;
            }
            // 指针后移
            cur = cur.next;
        }
        // 那个链表还有剩，直接连到后面
        if (pHead1 != null) {
            cur.next = pHead1;
        } else {
            cur.next = pHead2;
        }
        // 返回去掉表头
        return head.next;
    }

    public ListNode sortInList (ListNode head) {
        // write code here
        // 链表为空或者只有一个元素，直接就是有序
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode mid = head.next;
        ListNode right = head.next.next;
        // 右边指针到达末尾时，之间的指针指向该段链表的中间
        while (right != null && right.next != null) {
            left = left.next;
            mid = mid.next;
            right = right.next.next;
        }
        // 左边指针指向左段的左右一个节点，这里开始断开
        left.next = null;
        // 分成两段排序，合并排好序的两端
        return merge(sortInList(head), sortInList(mid));
    }

}
