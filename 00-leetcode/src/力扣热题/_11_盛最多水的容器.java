package 力扣热题;

/**
 * @author mxio
 *
 * https://leetcode.cn/problems/container-with-most-water/
 */
public class _11_盛最多水的容器 {

    public int maxArea(int[] height) {

        // 定义左指针和右指针
        int l = 0, r = height.length - 1;
        // 最大面积
        int maxRes = 0;
        // 左指针比右指针小
        while (l < r) {
            // 当前面积
            int res = (r - l) * Math.min(height[l], height[r]);
            // 取出左右指针较短的
            int minH = Math.min(height[l], height[r]);
            // 对比面积
            maxRes = Math.max(maxRes, res);
            // 快速跳过: 若当前指到的比之前的所有都短，直接跳过
            while (height[l] <= minH && l < r) {
                l++;
            }
            // 同上
            while (height[r] <= minH && l < r) {
                r--;
            }

        }
        return maxRes;
    }

}
