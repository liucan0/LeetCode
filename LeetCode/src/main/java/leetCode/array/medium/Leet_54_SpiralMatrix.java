package leetCode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 54 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Leet_54_SpiralMatrix {

    /**
     * 定义4个变量分别表示矩阵的上下左右四边，从矩阵最外层逐渐往内遍历
     * (左到右，上到下，右到左，下到上)，每一层的每一边遍历完成后自增对应的变量值
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int left = 0, right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int count = matrix.length * matrix[0].length;//要遍历的元素的个数
        while (count >= 1) {
            for (int i = left; i <= right && count >= 1; i++) {
                result.add(matrix[top][i]);
                count--;
            }
            top++;
            for (int i = top; i <= bottom && count >= 1; i++) {
                result.add(matrix[i][right]);
                count--;
            }
            right--;
            for (int i = right; i >= left && count >= 1; i--) {
                result.add(matrix[bottom][i]);
                count--;
            }
            bottom--;
            for (int i = bottom; i >= top && count >= 1; i--) {
                result.add(matrix[i][left]);
                count--;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        Leet_54_SpiralMatrix instance = new Leet_54_SpiralMatrix();
        List<Integer> result = instance.spiralOrder(matrix);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
