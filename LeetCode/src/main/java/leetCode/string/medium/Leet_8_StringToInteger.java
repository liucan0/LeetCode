package leetCode.string.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 8 字符串转为整数
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 */
public class Leet_8_StringToInteger {

    /**
     * 有限自动机解法。
     * 程序在每个时刻有一个状态s,每次从序列中输入一个字符c,并根据字符c转移到下一个状态s'.
     * 这样，只需要建立一个覆盖所有情况的从s与c映射到状态s'的表格即可解决。
     *
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        Automaton automaton = new Automaton();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            automaton.get(s.charAt(i));
        }
        return (int)(automaton.sign * automaton.ans);
    }

    class Automaton {
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        //定义状态机的几种状态
        private Map<String, String[]> table = new HashMap<String, String[]>(){
            {
                put("start", new String[]{"start", "signed", "in_number", "end"});
                put("signed", new String[]{"end", "end", "in_number", "end"});
                put("in_number", new String[]{"end", "end", "in_number", "end"});
                put("end", new String[]{"end", "end", "end", "end"});
            }
        };

        /**
         * 根据读取的字符更新状态机状态。in_number状态计算和，signed状态更新正负号
         * @param c
         */
        public void get(char c) {
            state = table.get(state)[getCol(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, (long)Integer.MAX_VALUE) : Math.min(ans, -(long)Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        /**
         * 根据读取的字符获取相应状态值
         * @param c
         * @return
         */
        private int getCol(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }
    }

    /**
     * 常规解法
     * @param s
     * @return
     */
    public int myAtoi1(String s) {
        char[] str = s.toCharArray();
        int flag = 2;
        int lijk = 0;
        long res = 0;
        for (int i = 0; i < str.length; i++) {
            if (lijk == 0 && str[i] == 32)
                continue;
            if (lijk == 0 && str[i] != '+' && str[i] != '-' && (str[i] < '0' || str[i] > '9')) {
                lijk = -1;
                break;
            }
            // 负号

            if (flag == 2 && str[i] == '-') {
                flag = -1;
                lijk = 1;
                continue;
            }

            if (flag == 2 && str[i] == '+') {
                flag = 1;
                lijk = 1;
                continue;
            }

            // 数字
            if (str[i] >= '0' && str[i] <= '9') {
                lijk = 1;
                if (i == 0)
                    flag = 1;
                else {

                    if (flag == 2 && str[i - 1] == 32 || str[i - 1] == '+')
                        flag = 1;
                    if (flag == 2 && str[i] == '-')
                        flag = -1;


                }
                res = res * 10 + (str[i] - 48);
                if (flag == -1 && res > 2147483647) {

                    break;
                }
                if (flag == 1 && res > 2147483647) {
                    res = 2147483647;
                    break;
                }


            }
            // 非数字
            if (str[i] < '0' || str[i] > '9')
                break;


        }


        if (lijk == -1 || lijk == 0)
            return 0;
        else {
            if (flag == -1 && res > 2147483647)
                return -2147483648;
            else if (flag == -1)
                res = 0 - res;


            return (int) res;
        }
    }

    public static void main(String[] args) {
        String s = "   +0 123";
        Leet_8_StringToInteger instance = new Leet_8_StringToInteger();
        System.out.println(instance.myAtoi(s));
    }
}
