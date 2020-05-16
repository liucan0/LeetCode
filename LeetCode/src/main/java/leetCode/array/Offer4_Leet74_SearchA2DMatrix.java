package leetCode.array;

/**
 * 描述：<br>
 * offer:3 leetcode:74
 * 搜索二维矩阵中的数字
 *
 * @ClassName SearchA2DMatrix
 * @Author liucan
 * @Date 2019/8/22 上午10:55
 * @Version 1.0
 **/
public class Offer4_Leet74_SearchA2DMatrix {

	/**
	 * 从矩阵右上角顶点开始比较。比target小则行数加1，比target大则列数减1
	 * @param matrix
	 * @param target
	 * @return
	 */
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		for (int row = 0, column = matrix[0].length - 1; row < matrix.length && column >= 0;) {
			int curr = matrix[row][column];
			if (target == curr) {
				return true;
			} else if (target < curr) {
				column--;
			} else {
				row++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] input = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		System.out.println(searchMatrix(input, 2));
		System.out.println(searchMatrix(input, 0));
	}
}
