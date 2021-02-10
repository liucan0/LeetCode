package leetCode.array;

/**
 * leetcode 167 两数之和_2
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，
 * 所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 *
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 */
public class Leet_167_TwoSum2 {

    /**
     * 定义头指针a和尾指针b,因为数组已经升序排序，a指向最小值，b指向最大值
     * 若numbers[a] + number[b]小于target,则a++，大于target则b--，两指针相邻时若和还不等于target,
     * 则判定无满足的值。
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        int first = 0, last = numbers.length - 1;
        while (first < last) {
            int sum = numbers[first] + numbers[last];
            if (sum < target) {
                first++;
            } else if (sum > target) {
                last--;
            } else {
                return new int[] {first + 1, last + 1};
            }
        }
        return null;
    }
}
