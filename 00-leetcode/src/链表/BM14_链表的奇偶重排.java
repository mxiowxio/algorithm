package 链表;

/**
 * @author mxio
 *
 * https://www.nowcoder.com/practice/02bf49ea45cd486daa031614f9bd6fc3?tpId=295&tqId=1073463&ru=%2Fpractice%2F3fed228444e740c8be66232ce8b87c2f&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 */
public class BM14_链表的奇偶重排 {

    public ListNode oddEvenList (ListNode head) {
        // write code here
        // 如果链表为空，不用重排
        if (head == null) {
            return head;
        }
        // even开头指向第二个节点，可能为空
        ListNode even = head.next;
        // odd开头指向第一个节点
        ListNode odd = head;
        // 指向even开头
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            // odd连接even的后一位，即奇数位
            odd.next = even.next;
            // odd进入下一位奇数位
            odd = odd.next;
            // even链接后一位奇数位的后一位，即偶数位
            even.next = odd.next;
            // even进入下一位偶数位
            even = even.next;
        }
        // even整体接在odd后面
        odd.next = evenHead;
        return head;
    }

}
