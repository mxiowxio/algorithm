package 链表;

/**
 * @author mxio
 *
 * https://www.nowcoder.com/practice/71cef9f8b5564579bf7ed93fbe0b2024?tpId=295&tqId=1073463&ru=%2Fpractice%2F3fed228444e740c8be66232ce8b87c2f&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 */
public class BM16_删除有序链表中重复的元素2 {

    /**
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 空链表
        if (head == null) {
            return head;
        }
        ListNode res = new ListNode(0);
        // 在链表前加一个表头
        res.next = head;
        ListNode cur = res;

        while (cur.next != null && cur.next.next != null) {
            // 遇到相邻两个节点值相同
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                // 将所有相同的都跳过
                while (cur.next != null && cur.next.val == temp) {
                    cur.next = cur.next.next;
                }
            }
            else {
                cur = cur.next;
            }
        }
        // 返回时去掉表头
        return res.next;
    }

}
