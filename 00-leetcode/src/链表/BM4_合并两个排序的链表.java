package 链表;

/**
 * @author mxio
 *
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=295&tqId=722&ru=%2Fexam%2Foj&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 *
 * public class ListNode {
 *     int val;
 *     ListNode next = null;
 *
 *     ListNode(int val) {
 *         this.val = val;
 *     }
 * }
 */
public class BM4_合并两个排序的链表 {

    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode cur = result;
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
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return result.next;
    }

}
