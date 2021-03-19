package leetCode.bitManipulation;

/**
 * leetcode 136 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class Leet_136_SingleNumber {
    /**
     * 可以使用额外空间存储遍历过的数字，此处不使用额外空间，采用异或运算处理
     * 异或运算性质；
     * 1.任何数和0异或，结果仍是原来的数
     * 2.任何数和自身异或，结果为0
     * 3.异或运算满足交换律和结合律
     *
     * 数组中全部元素的异或运算结果即为数组中只出现一次的数字
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int temp : nums) {
            single ^= temp;
        }
        return single;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,1,2,3,4};
        Leet_136_SingleNumber instance = new Leet_136_SingleNumber();
        System.out.println(instance.singleNumber(a));
    }
}
