package leetCode.string.simple;

/**
 * leetcode 383 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * <p>
 *  
 * <p>
 * 注意：
 * <p>
 * 你可以假设两个字符串均只含有小写字母。
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class Leet_383_CanConstruct {

    /**
     * 方法1：使用hashMap保存magazine中所有字符和其出现次数
     * 方法2：因为字符串中只包含小写字母，用固定26长度数组索引映射a-z，值为出现次数
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) {
            return false;
        }

        int[] countArr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            countArr[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            countArr[ransomNote.charAt(i) - 'a']--;
            if (countArr[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "hello";
        String b = "hasesdlosdl";
        Leet_383_CanConstruct instance = new Leet_383_CanConstruct();
        System.out.println(instance.canConstruct(a, b));
    }
}
