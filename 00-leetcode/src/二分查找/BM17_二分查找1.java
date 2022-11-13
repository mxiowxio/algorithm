package 二分查找;

/**
 * @author mxio
 *
 * https://www.nowcoder.com/practice/d3df40bd23594118b57554129cadf47b?tpId=295&tqId=1499549&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
 */
public class BM17_二分查找1 {

    /**
     * 分治
     */
    public int search(int[] nums, int target) {
        // write code here
        int l = 0;
        int r = nums.length - 1;
        // 从数组首尾开始，直到二者相遇
        while (l <= r) {
            // 每次检查中间的值
            int m = (l + r) >> 1;
            if (nums[m] == target) {
                return m;
            }
            // 进入左的区间
            if (nums[m] > target) {
                r = m - 1;
            }
            // 进入右区间
            else {
                l = m + 1;
            }
        }
        // 未找到
        return -1;
    }
}



