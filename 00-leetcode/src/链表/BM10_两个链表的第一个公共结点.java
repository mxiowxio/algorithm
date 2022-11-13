package 链表;

/**
 * @author mxio
 *
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Foj
 */
public class BM10_两个链表的第一个公共结点 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        for (ListNode h1 = pHead1; h1 != null ; h1 = h1.next) {
            for (ListNode h2 = pHead2; h2 != null ; h2 = h2.next) {
                if (h1 == h2) {
                    return h1;
                }
            }
        }
        return null;
    }

}
