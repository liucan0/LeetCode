package leetCode.dynamicPlanning.medium;

/**
 * leetcode 62 不同路径(动态规划)
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 *
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 *
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 *
 * 输入：m = 3, n = 3
 * 输出：6
 */
public class Leet_62_UniquePaths {

    /**
     * 动态规划法。
     * 用f(i,j)表示从左上角走到(i,j)的路径数量，其中i和j的范围分别是[0,m)
     * 和[0,n).由于我们每一步只能从向下或向右移动一步，因此要想走到(i,j),
     * 如果向下走一步，那么会从(i-1,j)走过来，如果向右走一步，那么会从(i,j-1)走过来。
     * 因此可以写出动态规划状态转移方程：f(i,j)=f(i-1,j) + f(i,j-1)
     * 需要注意的是，如果i=0,那么f(i-1,j)并不是一个满足要求的状态，需要忽略。
     * 同理，如果j=0,那么f(i,j-1)也不是一个满足要求的状态。
     * 初始条件为f(0,0)=1,即从左上角走到左上角只有一种方法，最终答案为f(m-1,n-1)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        //为方便代码编写，将所有的f(0,j)以及f(i,0)都设为边界条件，他们的值都为1；
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            f[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3, n = 7;
        Leet_62_UniquePaths instance = new Leet_62_UniquePaths();
        System.out.println(instance.uniquePaths(m ,n));
    }
}
