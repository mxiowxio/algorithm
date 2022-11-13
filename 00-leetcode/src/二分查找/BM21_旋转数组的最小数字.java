package 二分查找;

import java.util.*;
import java.util.ArrayList;

/**
 * @author mxio
 *
 * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=295&tqId=23260&ru=%2Fexam%2Foj&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 */
public class BM21_旋转数组的最小数字 {

    /**
     * 方法一：遍历
     */
    public int minNumberInRotateArray1(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        int ans = array[0];
        for (int i = 1; i < array.length; i++) {
            ans = Math.min(ans, array[i]);
        }
        return ans;
    }

    /**
     * 方法二：二分查找
     */
    public int minNumberInRotateArray2(int [] array) {
        // 如果数组无元素，那么返回0
        if (array.length <= 0) {
            return 0;
        }
        // 定义左边界
        int left = 0;
        // 定义右边界------在二分查找中，左边界的值一定小于或等于右边界的值
        int right = array.length - 1;
        while (left <= right) {
            // 计算左右区间最中间的索引
            int mid = left + ((right - left) >> 1);
            // 如果中间的值小于右边的值，说明此时数组最小值在左半部
            // 挪动右边界的指针到中间索引，为了避免此时的中间索引就是最小值，所以mid不能够-1
            if (array[mid] < array[right]) {
                right = mid;
            }
            // 如果中间的值大于右边的值，说明此时的最小值在右半部，挪动左边界的指针到当前中间索引的后一个
            else if (array[mid] > array[right]) {
                left = mid + 1;
            }
            // 如果中间的值与右边界的值相同，那么挪动右边界向左靠一位，这样就可以在下次循环的时候重新计算出中间索引值
            else {
                right--;
            }
        }
        // 左边界永远小于或等于右边界，那么就直接返回左边界所对应的数组值
        return array[left];
    }
}
