package leetCode.dynamicPlanning.medium;

/**
 * leetcode 63 不同路径2
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 *  
 *
 * 示例 1：
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 示例 2：
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 */
public class Leet_63_UniquePaths_Two {

    /**
     * 状态转移方程为dp(i,j)=dp(i-1,j) + dp(i,j-1),同leetcode 62。
     * 计算状态dp(i,j)需要的都是dp(i,j)相邻状态的时候，可以使用滚动数组优化空间复杂度，将dp二维状态数组压缩为一维。
     * 因为计算dp(i,j)位置的状态只需用到dp(i-1,j)和dp(i,j-1)位置处的状态，其他位置处的状态没有意义，
     * 因此将二维数组垂直投影到一维数组，使dp(i,j-1)和dp(i-1,j)两个状态处于同一列，
     * 即把i维度去掉，只留下j这个维度，压缩后的一维dp数组就是之前二维dp数组的dp(i,...)那一行
     *
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacle(int[][] obstacleGrid) {
        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;
        int[] f = new int[m];//使用一维数组存放上一行每个元素的值，
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;//判断起始位置是否为障碍物
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //设置障碍物位置处通路数量为0
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    /*
                     进行空间压缩后，当前f[j]值实际为上一轮遍历时j位置处的状态，即dp(i-1,j);
                     f[j-1]为本轮遍历时j-1位置的状态，即dp(i,j-1),因为dp(i,j-1)的状态计算出来后会覆盖dp(i-1,j-1)的值。
                     根据dp(i-1,j)【即f[j-1]】和dp(i,j-1)【即f[j]】处的两个状态可以得到当前dp(i,j)位置的状态，
                     然后覆盖保存为f[j],
                     */
                    f[j] += f[j - 1];
                }
            }
        }
        return f[m - 1];
    }

    public static void main(String[] args) {
        Leet_63_UniquePaths_Two instance = new Leet_63_UniquePaths_Two();
        int[][] data = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(instance.uniquePathsWithObstacle(data));
    }

}
