package leetCode.string.medium;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * leetcode 49 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 * <p>
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * <p>
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 */
public class Leet_49_GroupAnagrams {

    /**
     * hashMap加排序，用排序后的字符串作为key
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String temp : strs) {
            char[] charArr = temp.toCharArray();
            Arrays.sort(charArr);
            String key = String.valueOf(charArr);
            if (resultMap.containsKey(key)) {
                List<String> val = resultMap.get(key);
                val.add(temp);
            } else {
                List<String> val = new ArrayList<>();
                val.add(temp);
                resultMap.put(key, val);
            }
        }
        result.addAll(resultMap.values());
        return result;
    }

    public static void main(String[] args) {
        Leet_49_GroupAnagrams instance = new Leet_49_GroupAnagrams();
        String[] temp = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(JSON.toJSONString(instance.groupAnagrams(temp)));
    }
}
