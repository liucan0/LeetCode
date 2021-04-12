package leetCode.string.medium;

/**
 * leetcode 4 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 */
public class Leet_4_LongestPalindrome {

    /**
     * 1.动态规划法。对于一个子串，如果他是回文串，并且长度大于2，那么将它收尾的两个字母去掉后，
     * 它仍然是个回文串。我们可以用P(i,j)表示字符串s的第i到j字母组成的串是否为回文串，
     * 结果为true或false,为false时有两种情况：A.子串s[i,j]本身不是一个回文串，
     * B.i>j,此时子串s[i,j]本身并不合法。
     * 那么就可以写出动态规划的状态转移方程：
     * P(i,j) = p(i+1,j-1)^(Si==Sj)  (Si和Sj表示第i个和第j个子串)
     * 即：只有s[i+1:j-1]是回文串，并且s的第i个和j个字母相同时，s[i:j]才是回文串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }

    /**
     * 中心扩展算法：
     * 遍历所有字符，分别以每个字符作为回文中心，尝试向两边扩展(left--,right++)，
     * 直到无法扩展为止(left和right位置处的字符不相等)，此时的回文串长度即为次回文中心下的回文串长度
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++ ) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        Leet_4_LongestPalindrome instance = new Leet_4_LongestPalindrome();
        System.out.println(instance.longestPalindrome1("babad"));
    }
}
