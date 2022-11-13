package 二分查找;

/**
 * @author mxio
 * <p>
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=295&tqId=1499549&ru=%2Fexam%2Foj&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 */
public class BM18_二维数组中的查找 {

    /**
     * 暴力法
     */
    public boolean Find1(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 方法二：从左下找
     * 利用该二维数组的性质：
     * <p>
     * 每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序
     * 改变个说法，即对于左下角的值 m，m 是该行最小的数，是该列最大的数
     * 每次将 m 和目标值 target 比较：
     * <p>
     * 当 m < target，由于 m 已经是该列最大的元素，想要更大只有从行考虑，取值右移一位
     * 当 m > target，由于 m 已经是该行最小的元素，想要更小只有从列考虑，取值上移一位
     * 当 m = target，找到该值，返回 true
     * 用某行最小或某列最大与 target 比较，每次可剔除一整行或一整列
     */
    public boolean Find2(int target, int[][] array) {
        int rows = array.length;
        if (rows == 0) {
            return false;
        }
        int cols = array[0].length;
        if (cols == 0) {
            return false;
        }
        // 左下
        int row = rows - 1;
        int col = 0;
        while (row >= 0 && col < cols) {
            if (array[row][col] < target) {
                col++;
            } else if (array[row][col] > target) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 方法三:从右上找 道理同上
     */
    public boolean Find3(int target, int[][] array) {
        int rows = array.length;
        if (rows == 0) {
            return false;
        }
        int cols = array[0].length;
        if (cols == 0) {
            return false;
        }
        // 右上
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            if (array[row][col] < target) {
                row++;
            } else if (array[row][col] > target) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }

}
