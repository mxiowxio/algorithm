package 链表;

/**
 * @author mxio
 * <p>
 * https://www.nowcoder.com/practice/b58434e200a648c589ca2063f1faf58c?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Foj
 */
public class _BM2_链表内指定区间反转 {

    /**
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        // 设置虚拟头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        // 1. 走left-1步到left前一个节点
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        // 2. 走right-left+1步到right节点
        for (int i = 0; i < n - m + 1; i++) {
            rightNode = rightNode.next;
        }

        // 3. 截取出一个子链表
        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;

        //4. 切断链接
        pre.next = null;
        rightNode.next = null;

        // 5.反转局部链表
        reverseLinkedList(leftNode);

        // 6. 接回原来的链表
        pre.next = rightNode;
        leftNode.next = cur;
        return dummyHead.next;
    }

    /**
     * 反转局部链表
     *
     * @param head
     */
    private void reverseLinkedList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // cur_next 指向cur节点的下一个节点
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }

    }

}
