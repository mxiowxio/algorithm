package 二分查找;

/**
 * @author mxio
 *
 * https://www.nowcoder.com/practice/fcf87540c4f347bcb4cf720b5b350c76?tpId=295&tqId=1499549&ru=%2Fexam%2Foj&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 */
public class BM19_寻找峰值 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 方法一：for
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int findPeakElement1 (int[] nums) {
        // write code here
        int idx = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 方法二：二分法
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int findPeakElement2 (int[] nums) {
        // write code here
        // 关键思想:下坡的时候可能找到波峰，但是可能也找不到，一直向下走
        // 上坡的时候一定要找到波峰，因为nums[-1] = nums[n] = -无穷
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            // 证明右边的路是下坡路，不一定有波峰
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            }
            else {
                // 这里是右边的路都是上坡路
                left = mid + 1;
            }
        }
        return right;
    }
}
