package leetCode.heap;

/**
 * 描述：<br>
 * 找到未排序数组中的第k大元素。
 * @ClassName FindKthLargest
 * @Author liucan
 * @Date 2019/10/26 下午10:17
 * @Version 1.0
 **/
public class FindKthLargest {

	public static int findKthLargest(int[] nums, int k) {
		if (nums == null || k <= 0 || k > nums.length) {
			throw new NullPointerException();
		}
		//创建一个堆。i为数组长度/2-1，在0～i之间的结点属于有子节点的结点
		for (int i = nums.length / 2 - 1; i >= 0; i--) {
			perDown(nums, i, nums.length);
		}
		//每次删除最大值，将其放入数组末尾，并将数组的有效容量i减1，
		int result = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			//交换root值和有效容量内的最后一个值，相当于删除方法
			int temp = nums[0];
			nums[0] = nums[i];
			nums[i] = temp;
			if (i == nums.length - k) {
				result = nums[i];
			}
			perDown(nums, 0, i);
		}
		return result;
	}

	private static void perDown(int[] target, int parentIndex, int size) {
		int childIndex = 0;
		int parentTemp = 0;
		for (parentTemp = target[parentIndex]; leftChildIndex(parentIndex) < size; parentIndex = childIndex ) {
			//左儿子结点的位置
			childIndex = leftChildIndex(parentIndex);
			//如果结点存在两个子节点，且左儿子结点小于右儿子节点，将子节点的位置指向右儿子结点
			if (childIndex != size - 1 && target[childIndex] < target[childIndex + 1]) {
				childIndex++;
			}
			//父节点的值小于子节点的值，将父节点的值替换为子节点的值,否则不做处理。
			if (parentTemp < target[childIndex]) {
				target[parentIndex] = target[childIndex];
			} else {
				break;
			}
			//位置交换后更新之前的父节点(现子节点)的位置，在for循环中更新
		}
		//回复之前的父节点的值
		target[parentIndex] = parentTemp;
	}

	private static int leftChildIndex(int parentIndex) {
		return parentIndex * 2 + 1;
	}

	public static void main(String[] args) {
		int[] a = {3,2,3,1,2,4,5,5,6};
		//输出应为4
		System.out.println(findKthLargest(a, 4));

	}
}
