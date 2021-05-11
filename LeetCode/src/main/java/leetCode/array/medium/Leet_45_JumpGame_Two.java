package leetCode.array.medium;

/**
 * leetcode 45 跳跃游戏2
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: [2,3,0,1,4]
 * 输出: 2
 */
public class Leet_45_JumpGame_Two {

    /**
     * 贪心算法。
     * 维护当前能够到达的最大下标位置maxPosition记为边界，我们从左往右遍历数组，
     * 到达边界时，更新边界并将跳跃次数增加1.
     * 遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置，
     * 否则就无法调到最后一个位置了。如果访问最后一个元素，在边界正好为最后一个位置的情况下，我们会增加一次
     * 不必要的跳跃次数，因此不必访问最后一个元素
     * @param nums
     * @return
     */
    public int jump(int[] nums) {

        int steps = 0;//次数
        int maxPosition = 0;//下一个区间的最大索引值
        int end = 0;//下一个区间内的最大值
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        Leet_45_JumpGame_Two instance = new Leet_45_JumpGame_Two();
        int[] input = {2,1,1,1,1};
        System.out.println(instance.jump(input));
    }
}
