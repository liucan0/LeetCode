package leetCode.array.simple;

/**
 * leetcode 169 数组中的多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Leet_169_MajorElement {

    /**
     * 四种方法：1.使用hashMap, 2.排序数组在返回数组中间值
     * 3.分治法，4.波伊-摩尔投票算法。
     * 此处采用投票算法。
     * 1.维护一个候选众数num和他的出现次数count，初始时nums可以为任何数，count为0。
     * 2.遍历数组nums中的所有元素，对于每个元素x，在判断x之前，如果count的值为0,先将x的赋予num,
     * 随后判断：a.如果x与num相等，count的值加一，如果不等，则值减一。
     * 3.遍历完成后，num即为整个数组的众数
     * @param nums
     * @return
     */
    public int majorElement(int[] nums) {
        int num = 0, count = 0;
        for (int temp : nums) {
            if (count == 0) {
                num = temp;
            }
            count = temp == num ? count + 1 : count - 1;
        }
        return num;
    }
}
