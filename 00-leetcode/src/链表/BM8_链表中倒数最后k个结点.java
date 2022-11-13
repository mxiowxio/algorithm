package 链表;

import java.util.Stack;

/**
 * @author mxio
 *
 * https://www.nowcoder.com/practice/886370fe658f41b498d40fb34ae76ff9?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Foj
 */
public class BM8_链表中倒数最后k个结点 {

    /**
     * 方法1：双指针法
     */
    public ListNode FindKthToTail1 (ListNode pHead, int k) {
        // write code here
        if (pHead == null) {
            return null;
        }

        ListNode first = pHead;
        ListNode second = pHead;

        // 第一个指针先走k步
        while (k-- > 0) {
            if (first == null) {
                return null;
            }
            first = first.next;
        }

        // 这时两个指针同时前进
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // 当first到达链表尾部时，second刚好处在最后第k个，返回即可
        return second;
    }

    /**
     * 方法2：栈
     */
    public ListNode FindKthToTail2 (ListNode pHead, int k) {
        // write code here
        Stack<ListNode> stack = new Stack<>();
        // 链表节点压栈
        int count = 0;
        while (pHead != null) {
            stack.push(pHead);
            pHead = pHead.next;
            count++;
        }
        if (count < k || k == 0) {
            return null;
        }
        // 在出栈时串成新的链表
        ListNode newNode = stack.pop();
        while (--k > 0) {
            ListNode temp = stack.pop();
            temp.next = newNode;
            newNode = temp;
        }
        return newNode;
    }

    /**
     * 方法3：递归
     */
    int size;
    public ListNode FindKthToTail3 (ListNode pHead, int k) {
        // write code here
        // 边界判断条件
        if (pHead == null) {
            return null;
        }
        ListNode node = FindKthToTail3(pHead.next, k);
        ++size;
        // 从后面数节点数小于k，返回空
        if (size < k) {
            return null;
        } else if (size == k) {
            return pHead;
        } else {
            // 从后面数访问的节点数大于k，说明我们已经找到了
            return node;
        }
    }
}
