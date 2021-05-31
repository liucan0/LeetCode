package leetCode.array.medium;

/**
 * leetcode 74 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 * 示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 */
public class Leet_74_SerachMatrix {

    public boolean serachMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int i = 0, j = column - 1;
        while (i < row && j >= 0) {
            int curr = matrix[i][j];
            if (curr == target) {
                return true;
            } else if (curr > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Leet_74_SerachMatrix instance = new Leet_74_SerachMatrix();
        int[][] matrix = new int[][]{{1}};
        System.out.println(instance.serachMatrix(matrix,2));
    }
}
