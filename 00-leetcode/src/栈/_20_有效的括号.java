package 栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author mxio
 *
 * https://leetcode.cn/problems/valid-parentheses/
 */
public class _20_有效的括号 {

    /**
     * 解法一。效率最低
     */
    public boolean isValid1(String s) {
        while(s.contains("{}") || s.contains("[]") || s.contains("()")){
            s.replace("{}", "");
            s.replace("[]", "");
            s.replace("()", "");
        }
        return s.isEmpty();
    }

    /**
     * 解法二:栈
     */
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){ // 左括号
                stack.push(s.charAt(i)); // 左字符入栈
            }else{ // 右括号
                if(stack.isEmpty()) {
                    return false; // 没有左括号, 却匹配到了右括号，false
                }

                char left = stack.pop();
                if(left == '(' && c != ')') {
                    return false; // 左右括号不匹配
                }
                if(left == '[' && c != ']') {
                    return false; // 左右括号不匹配
                }
                if(left == '{' && c != '}') {
                    return false; // 左右括号不匹配
                }
            }
        } // 扫描完毕
        return stack.isEmpty();
    }

    /**
     * 解法三：哈希表
     */
    static HashMap<Character, Character> map = new HashMap<>();
    static {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){ // 左括号，哈希表中有该键则入栈
                stack.push(c);
            }else{ // 右括号
                if(stack.isEmpty()) {
                    return false;
                }
                char left = stack.pop();
                if(c != map.get(left)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
