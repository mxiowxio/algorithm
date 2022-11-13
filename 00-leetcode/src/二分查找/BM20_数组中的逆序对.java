package 二分查找;

/**
 * @author mxio
 * <p>
 * https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5?tpId=295&tqId=23260&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
 */
public class BM20_数组中的逆序对 {

    /**
     * 归并排序
     */
    int[] nums, temp;

    public int merge_sort(int l, int r) {
        if (l >= r) {
            return 0;
        }
        int m, i, j, k;
        long res;

        m = (l + r) >> 1;
        res = (merge_sort(l, m) + merge_sort(m + 1, r)) % 1000000007;

        //merge
        for (k = l; k <= r; k++) {
            temp[k] = nums[k];
        }
        i = l;
        j = m + 1;
        k = l;
        for (k = l; k <= r; k++) {
            if (i == m + 1) {
                nums[k] = temp[j++];
            } else if (j == r + 1 || temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                res = (res + m - i + 1) % 1000000007;
                nums[k] = temp[j++];
            }
        }
        return (int) res;
    }

    public int InversePairs(int[] array) {
        nums = array;
        temp = new int[array.length];
        return merge_sort(0, array.length - 1);
    }

}
