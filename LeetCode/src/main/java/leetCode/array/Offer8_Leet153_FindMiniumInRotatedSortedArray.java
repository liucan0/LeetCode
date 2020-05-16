package leetCode.array;

/**
 * 描述：<br>
 * 寻找旋转数组中的最小值.
 * 从头到尾遍历找到最小值，O(n);
 * 修改后的二分查找，O(logN)
 * @ClassName Offer8_Leet153_FindMiniumInRotatedSOrtedArray
 * @Author liucan
 * @Date 2019/11/3 下午8:52
 * @Version 1.0
 **/
public class Offer8_Leet153_FindMiniumInRotatedSortedArray {

	public int findMin(int[] array) {
		if (array == null || array.length == 0) {
			throw new RuntimeException();
		}
		int left = 0;
		int right = array.length - 1;
		int mid = left;
		while (array[left] > array[right]) {
			if (right - left == 1) {
				mid = right;
				break;
			}
			if (array[mid] > array[right]) {
				left = mid;
			} else {
				right = mid;
			}
			mid = (left + right) / 2;
		}
		return array[mid];
	}
}
