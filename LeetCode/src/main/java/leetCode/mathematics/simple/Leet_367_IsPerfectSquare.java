package leetCode.mathematics.simple;

/**
 * leetcode 367 有效的完全平方数
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：num = 16
 * 输出：true
 * 示例 2：
 *
 * 输入：num = 14
 * 输出：false
 */
public class Leet_367_IsPerfectSquare {

    /**
     * 暴力法此处不予考虑。
     * 此处使用牛顿迭代法用于求根
     * 1.区num/2作为初始近似值x
     * 2.当x * x > num,用牛顿迭代法取下一个近似值x = (x + num / x) / 2;
     * 返回x * x == num;
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }

    public static void main(String[] args) {
        Leet_367_IsPerfectSquare instance = new Leet_367_IsPerfectSquare();
        System.out.println(instance.isPerfectSquare(14));
    }
}
