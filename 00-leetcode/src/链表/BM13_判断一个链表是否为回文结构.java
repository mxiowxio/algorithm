package 链表;

import java.util.Stack;

/**
 * @author mxio
 *
 * https://www.nowcoder.com/practice/3fed228444e740c8be66232ce8b87c2f?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Foj
 */
public class BM13_判断一个链表是否为回文结构 {

    /**
     * 方法一：栈
     */
    public boolean isPail1 (ListNode head) {
        // write code here
        if (head == null) {
            return true;
        }
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        // 链表的长度
        int len = 0;
        // 把链表节点的值存入到栈中
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
            len++;
        }
        // len长度除以2
        len >>= 1;
        // 然后再出栈
        while (len-- >= 0) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 方法二:快慢指针
     */
    public boolean isPail2 (ListNode head) {
        // write code here
        ListNode fast = head;
        ListNode slow = head;
        // 通过快慢指针找到中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 如果fast不为空，说明链表的长度是奇数个
        if (fast != null) {
            slow = slow.next;
        }
        // 反转后半部分链表
        slow = reverse(slow);

        fast = head;
        while (slow != null) {
            // 然后比较，判断节点值是否相等
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    /** 反转链表：双链表法反转链表*/
    public ListNode reverse(ListNode head) {
        // 新链表
        ListNode prev = null;
        while (head != null) {
            // 先保留访问的节点的下一个节点，保存起来
            // 留着下一步访问的
            ListNode next = head.next;
            // 每次访问的原链表节点都会成为新链表的头节点
            // 其实就是把链表挂到访问的原链表节点的后面就行了
            head.next = prev;
            // 更新新链表
            prev = head;
            // 重新赋值，继续访问
            head = next;
        }
        // 返回新链表
        return prev;
    }

}
