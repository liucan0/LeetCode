package leetCode.array.medium;

import java.util.Arrays;

/**
 * leetcode 59 螺旋矩阵2
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 */
public class Leet_59_SpiralMatrix_Two {

    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return null;
        }
        if (n == 1) {
            return new int[][]{{1}};
        }
        int[][] result = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1, count = 1, total = n * n;
        while (count <= total) {
            //从上边从左往右遍历，遍历完成后top++;
            for (int i = left; i <= right && count <= total; i++) {
                result[top][i] = count++;
            }
            top++;
            //从右边从上(top)往下(bottom)遍历，遍历完成后right--;
            for (int i = top; i <= bottom && count <= total; i++) {
                result[i][right] = count++;
            }
            right--;
            //从下边从右往左遍历，遍历完成后bottom--
            for (int i = right; i >= left && count <= total; i--) {
                result[bottom][i] = count++;
            }
            bottom--;
            //从左边从下往上遍历，遍历完成后left++;
            for (int i = bottom; i >= top && count <= total ; i--) {
                result[i][left] = count++;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        Leet_59_SpiralMatrix_Two instance = new Leet_59_SpiralMatrix_Two();
        int n = 3;
        int[][] result = instance.generateMatrix(n);
        for (int[] temp : result) {
            System.out.println(Arrays.toString(temp));
        }
    }
}
