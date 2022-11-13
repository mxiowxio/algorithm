package 力扣热题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mxio
 * <p>
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?favorite=2cktkvj
 */
public class _17_电话号码的字母组合 {

    /**
     * 回溯算法
     */
    private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};

    private StringBuilder sb = new StringBuilder();

    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        backtrack(digits, 0);
        return res;
    }

    /**
     * 回溯函数
     */
    private void backtrack(String digits, int index) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String val = map[digits.charAt(index) - '0'];
        for (char ch : val.toCharArray()) {
            sb.append(ch);
            backtrack(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * 法2：未理解，还需要研究
     * 不用回溯，先求总可能性有多少种，再用求余拿到每一种
     * （可以当做是状态压缩吧，000代表都是第0位，001代表前两个第0位，第三个第1位，002。。。以此类推）
     */
    public List<String> letterCombinations2(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] strs = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //1.先算出一共有几种
        int len = 1;
        for (int i = 0; i < digits.length(); i++) {
            int c = digits.charAt(i) - '0';
            len *= strs[c].length();
        }

        //再用求余方法拿到每一种
        for (int i = 0; i < len; i++) {
            int last = i;
            StringBuilder sb = new StringBuilder();
            for (int j = digits.length() - 1; j >= 0; j--) {
                int c = digits.charAt(j) - '0';
                int pos = last % strs[c].length();
                sb.append(strs[c].charAt(pos));
                last = last / strs[c].length();
            }
            result.add(sb.reverse().toString());
        }


        return result;
    }
}
