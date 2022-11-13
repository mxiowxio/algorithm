package 链表;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author mxio
 *
 * https://www.nowcoder.com/practice/b49c3dc907814e9bbfa8437c251b028e?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Foj
 */
public class BM3_链表中的节点每k个一组翻转 {

    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if (k <= 1 || head == null) {
            return head;
        }

        // 模拟栈
        Deque<ListNode> st = new ArrayDeque<ListNode>();
        ListNode result = new ListNode(0);
        ListNode now = result;
        int cnt = 0;
        while (true) {
            // 将当前链表前k个存入栈中
            for (int i = 0; i < k; i++) {
                st.push(head);
                head = head.next;
                cnt++;
                if (head == null) {
                    break;
                }
            }

            // 如果当前链表已经达到k个元素，则弹出
            if (cnt == k) {
                while (!st.isEmpty()) {
                    now.next = st.pop();
                    now = now.next;
                    now.next = null;
                }
            }

            // 链表取完，跳出循环
            if (head == null) {
                break;
            }
            cnt = 0;
        }

        ListNode end = null;
        // 如果栈中还有剩下的就说明是最后的一块直接取栈底即可
        while (!st.isEmpty()) {
            end = st.pop();
        }
        now.next = end;
        return result.next;

    }

}
