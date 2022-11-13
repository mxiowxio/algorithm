package 链表;

/**
 * @author mxio
 * <p>
 * https://www.nowcoder.com/practice/f95dcdafbde44b22a6d741baf71653f6?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Foj
 */
public class BM9_删除链表的倒数第n个节点 {

    /**
     * 方法2：快慢指针
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        // write code here
        // 添加表头
        ListNode res = new ListNode(0);
        res.next = head;
        // 当前节点
        ListNode cur = head;
        // 前序节点
        ListNode pre = res;
        ListNode fast = head;
        // 快指针先走n步
        while (n != 0) {
            fast = fast.next;
            n--;
        }
        // 快慢指针同步，快指针到达末尾，慢指针就刀了倒数第n个位置
        while (fast != null) {
            fast = fast.next;
            pre = cur;
            cur = cur.next;
        }
        // 删除该位置的节点
        pre.next = cur.next;
        // 返回去掉头
        return res.next;
    }

    /**
     * 正常方法
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // write code here
        ListNode pre = head;
        int last = length(head) - n;
        // 如果last等于0则表示删除的是头节点
        if (last == 0) {
            return head.next;
        }
        // 这里首先要找到要删除链表的前一个节点
        for (int i = 0; i < last - 1; i++) {
            pre = pre.next;
        }
        // 然后让前一个节点的next指向要删除节点的next
        pre.next = pre.next.next;
        return head;
    }

    /**
     * 求链表的长度
     */
    private int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
