package 链表;

import java.util.LinkedList;

/**
 * @author mxio
 *
 * https://www.nowcoder.com/practice/c56f6c70fb3f4849bc56e33ff2a50b6b?tpId=295&tqId=1008772&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
 */
public class BM11_链表相加2 {

    /**
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    /**
     * 方法一：栈
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        putData(list1, head1);
        putData(list2, head2);
        ListNode newNode = null;
        ListNode head = null;

        // 标记进位
        int cur = 0;
        while (!list1.isEmpty() || !list2.isEmpty() || cur != 0) {
            // 依次从栈中取出
            int x = (list1.isEmpty()) ? 0 : list1.pop();
            int y = (list2.isEmpty()) ? 0 : list2.pop();
            // 与进位符一起相加
            int sum = x + y +cur;
            // 更新进位
            cur = sum / 10;
            // 将计算值放入节点
            newNode = new ListNode(sum % 10);
            // 更新下一个节点的指向
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    private static void putData(LinkedList<Integer> s1, ListNode head1) {
        if (s1 == null) {
            s1 = new LinkedList<>();
        }
        // 遍历节点将其插入栈中
        while (head1 != null) {
            s1.push(head1.val);
            head1 = head1.next;
        }
    }

}
