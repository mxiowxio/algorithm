package 力扣热题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mxio
 * <p>
 * https://leetcode.cn/problems/3sum/
 */
public class _15_三数之和 {

    /**
     * 解法：定义三个指针，保证遍历数组中的每一个结果
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 定义一个结果集
        List<List<Integer>> res = new ArrayList<>();
        // 数组的长度
        int len = nums.length;
        // 当前数组长度为空，或者长度小于3时，直接退出
        if (nums == null || len < 3) {
            return res;
        }
        // 对数组进行排序
        Arrays.sort(nums);
        // 遍历数组中的每一个元素
        for (int i = 0; i < len; i++) {
            // 如果遍历的起始元素大于0，就直接退出
            // 原因：此时的数组为有序数组，第一个都大于0了，三数之和就不会等于0
            if (nums[i] > 0) {
                break;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 定义双指针
            int l = i + 1;
            int r = len - 1;
            // 当 l 不等于 r 时就继续遍历
            while (l < r) {
                // 将三数进行相加
                int sum = nums[i] + nums[l] + nums[r];
                // 如果等于0，就将结果对应的索引位置的值加入到结果集中
                if (sum == 0) {
                    // 将三数的结果加入到结果集中
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 再将左指针和右指针移动的时候，先对左右指针的值进行判断
                    // 如果右重复，直接跳过
                    // 去重，因为 i 不变，当此时 l 取的数的值与前一个数相同，所以不用在计算，直接跳
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    // 去重，因为 i 不变，当此时 r 取的数的值与前一个相同，所以不用在计算
                    while( l < r && nums[r] == nums[r - 1]){
                        r--;
                    }
                    // 将左指针右移，右指针左移
                    l++;
                    r--;
                    // 如果结果小于0，将左指针右移
                } else if (sum < 0) {
                    l++;
                    // 如果结果大于0，将右指针左移
                } else {
                    r--;
                }
            }
        }
        return res;
    }

}
