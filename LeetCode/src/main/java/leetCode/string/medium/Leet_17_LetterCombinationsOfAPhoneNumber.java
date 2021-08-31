package leetCode.string.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 17 电话号码的组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */
public class Leet_17_LetterCombinationsOfAPhoneNumber {

    /**
     * 回溯法。
     * 首先使用哈希表存储每个数字对应的所有可能的字母，然后经行回溯操作
     * 回溯过程中维护一个字符串，表示已有的字母排列(如果未遍历完短话号码的所有数字，则已有的字母排列是不完整的)
     * 该字符串初始为空。每次去电话号码的一位数字，从哈希表中获得该数字对应的所有可能的字母，
     * 并将其中的一个字母插入到已有的字母排列后面，然后继续处理电话号码的后一位数字，
     * 直到处理完电话号码中的所有数字，即得到一个完整的字母排列,
     * 然后进行回退操作，遍历其余的字母排列
     * @param digits 输入数据
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits.length() == 0) {
            return results;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        backtack(results, phoneMap, digits, 0, new StringBuilder());
        return results;
    }

    /**
     * 回溯进行字符的排列组合.
     * 回溯常用操作：循环体内进行递归处理,递归结束后清理删除上一次结果
     * @param results 结果集
     * @param phoneMap 预定义字符列表
     * @param digits 输入的字符串
     * @param index 输入串当前遍历的位置
     * @param combination 存放当前排列字符串
     */
    private void backtack(List<String> results, Map<Character, String> phoneMap, String digits, int index, StringBuilder combination) {
        if (index == digits.length()) {
            //遍历到最后一个字符，添加当前排列结果
            results.add(combination.toString());
        } else {
            char digit = digits.charAt(index);//当前要组合的数字
            String letters = phoneMap.get(digit);//当前数字对应的字母集合
            int letterCount = letters.length();
            for (int i = 0; i < letterCount; i++) {
                //添加字母集合中第i个字母到当前排列字符串，然后递归遍历下一个数字
                combination.append(letters.charAt(i));
                backtack(results, phoneMap, digits, index + 1, combination);
                //回溯，递归结束后删除上一次添加的字符，进行下一个位置的遍历
                combination.deleteCharAt(index);
            }
        }
    }


    public static void main(String[] args) {
        String input = "234";
        Leet_17_LetterCombinationsOfAPhoneNumber instance = new Leet_17_LetterCombinationsOfAPhoneNumber();
        System.out.println(instance.letterCombinations(input));
    }
}
