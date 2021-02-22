package leetCode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * leetcode 20 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 */
public class Leet_20_ValidParentheses {
    private static Map<Character, Character> mathMap = new HashMap<Character, Character>() {
        {
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }
    };

    /**
     * 规则：先遇到的右括号要和最后遇到的左括号匹配。
     * 字符串从左往右遍历，将遇到的左括号类型的字符都放入栈中，
     * 遇到右括号时和栈顶的左括号对比看是否匹配，不匹配返回false,否则继续遍历。
     * 遍历完成后栈为空返回true,否则返回false
     * @param s
     * @return
     */
    public boolean isValid(String s) {
      if (s == null || s.length() == 0) {
          return false;
      }
      if (s.length() % 2 != 0) {
          return false;
      }
      Stack<Character> leftStack = new Stack<>();
      for (char temp : s.toCharArray()) {
          //当前字符不是左括号并且栈为空，返回false
          if (!isLeft(temp) && leftStack.isEmpty()) {
              return false;
          }
          if (!isLeft(temp) && !leftStack.isEmpty()) {
            //当前字符不是左括号并且栈里有值，比较当前字符和栈顶的括号是否匹配
              char stackValue = leftStack.pop();
              if (mathMap.get(stackValue) != temp) {
                  return false;
              }
          } else {
              leftStack.push(temp);
          }
      }
      return leftStack.isEmpty();
    }

    /**
     * 判断字符是否是左括号
     * @param value
     * @return
     */
    private boolean isLeft(char value) {
        return mathMap.get(value) != null;
    }

    public static void main(String[] args) {
        String s = "{[]}";
        Leet_20_ValidParentheses instance = new Leet_20_ValidParentheses();
        System.out.println(instance.isValid(s));
    }
}
