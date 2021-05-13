package leetCode.array.medium;

/**
 * leetcode 55 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class Leet_55_JumpGame {

    /**
     * 贪心算法。
     * 定义maxStep为能到达的最大位置。
     * 如果maxStep大于等于nums.length - 1,说明能够到达。
     * 反之说明不能到达
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int maxStep = 0;//到达的最大长度
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxStep) {
                maxStep = Math.max(maxStep, i + nums[i]);
                if (maxStep >= length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] data = {2,3,1,1,4};
        Leet_55_JumpGame instance = new Leet_55_JumpGame();
        System.out.println(instance.canJump(data));
    }
}
