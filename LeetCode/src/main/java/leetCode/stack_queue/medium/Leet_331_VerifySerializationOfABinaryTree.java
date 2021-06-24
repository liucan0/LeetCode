package leetCode.stack_queue.medium;

/**
 * leetcode 331 验证二叉树的前序序列化
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 *
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 *
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 *
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 *
 * 示例 1:
 *
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 示例 2:
 *
 * 输入: "1,#"
 * 输出: false
 * 示例 3:
 *
 * 输入: "9,#,#,1"
 * 输出: false
 */
public class Leet_331_VerifySerializationOfABinaryTree {

    /**
     * 将当前二叉树中正在等待被节点填充的位置称为槽位。
     * 每当遇到一个节点时，如果遇到了空节点，则要消耗一个槽位；
     * 如果遇到了非空节点，除了消耗一个槽位外，还会增加两个槽位；
     * 我们使用一个计数器num，代表所有槽位之和，遇到空节点时，num减一，
     * 遇到非空节点时，num加一。遍历结束后，若num==0说明合法，反之不合法
     * @param preorder
     * @return
     */
    public boolean isValidSerialization(String preorder) {
        int length = preorder.length();
        int slots = 1;//slots槽位数量
        for (int i = 0; i < length;) {
            char temp = preorder.charAt(i);
            if (slots == 0) {
                return false;
            }
            switch (temp) {
                case ',' :
                    i++;
                    break;
                case '#' :
                    slots--;
                    i++;
                    break;
                default:
                    while (i < length && preorder.charAt(i) != ',') {
                        i++;
                    }
                    slots++;
            }
        }
        return slots == 0;
    }

    public static void main(String[] args) {
        Leet_331_VerifySerializationOfABinaryTree instance = new Leet_331_VerifySerializationOfABinaryTree();
        String preorder = "1,#";
        System.out.println(instance.isValidSerialization(preorder));
    }
}
