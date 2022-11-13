package 二分查找;

/**
 * @author mxio
 * <p>
 * https://www.nowcoder.com/practice/2b317e02f14247a49ffdbdba315459e7?tpId=295&tqId=23269&ru=%2Fexam%2Foj&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 */
public class BM22_比较版本号 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 方法一：双指针
     * step 1：利用两个指针表示字符串的下标，分别遍历两个字符串。
     * step 2：每次截取点之前的数字字符组成数字，即在遇到一个点之前，直接取数字，加在前面数字乘10的后面。（因为int会溢出，这里采用long记录数字）
     * step 3：然后比较两个数字大小，根据大小关系返回1或者-1，如果全部比较完都无法比较出大小关系，则返回0.
     * <p>
     * 比较版本号
     *
     * @param version1 string字符串
     * @param version2 string字符串
     * @return int整型
     */
    public int compare1(String version1, String version2) {
        // write code here
        int n1 = version1.length();
        int n2 = version2.length();
        int i = 0, j = 0;
        // 直到某个字符结束
        while (i < n1 || j < n2) {
            long num1 = 0;
            // 从下一个点前截取数字
            while (i < n1 && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }
            // 跳过点
            i++;
            long num2 = 0;
            // 从下一个点前截取数字
            while (j < n2 && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }
            // 跳过点
            j++;
            //比较数字大小
            if (num1 > num2) {
                return 1;
            }
            if (num1 < num2) {
                return -1;
            }
        }
        // 版本号相同
        return 0;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 方法二:分割截取
     * step 1：使用split函数或者字符串流输入，按照点将两个原始字符串分割，使每个修订号的数字单独呈现在数组中。
     * step 2：遍历数组，每次各自取出一个数字比较，较短的版本号没有可取的数字了，就直接取0。
     * step 3：遍历取出的数字字符串，将其转换成数字，然后比较数字大小。根据大小关系返回1或者-1，如果全部比较完都无法比较出大小关系，则返回0.
     *
     * 比较版本号
     * @param version1 string字符串
     * @param version2 string字符串
     * @return int整型
     */
    public int compare2 (String version1, String version2) {
        // write code here
        // 按照，划分
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        for (int i = 0; i < nums1.length || i < nums2.length; i++) {
            // 较短的版本号后续都取0
            String str1 = i < nums1.length ? nums1[i] : "0";
            String str2 = i < nums2.length ? nums2[i] : "0";
            long num1 = 0;
            // 字符串转数字
            for (int j = 0; j < str1.length(); j++) {
                num1 = num1 * 10 + (str1.charAt(j) - '0');
            }
            long num2 = 0;
            for (int j = 0; j < str2.length(); j++) {
                num2 = num2 * 10 + (str2.charAt(j) - '0');
            }
            // 比较数字大小
            if (num1 > num2) {
                return 1;
            }
            if (num1 < num2) {
                return -1;
            }
        }
        // 版本相同
        return 0;
    }

}
