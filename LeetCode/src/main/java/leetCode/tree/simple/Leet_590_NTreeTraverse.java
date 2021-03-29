package leetCode.tree.simple;

import base.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的遍历
 */
public class Leet_590_NTreeTraverse {

    /**
     * n叉树后续遍历
     * @param root
     * @return
     */
    public List<Integer> postOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        postOrder(result, root);
        return result;
    }

    private List<Integer> postOrder(List<Integer> list, Node root) {
        if (root == null) {
            return list;
        }
        List<Node> children = root.getChildren();
        if (children != null && !children.isEmpty()) {
            for (Node child : children) {
                postOrder(list, child);
            }
            list.add(root.getVal());
        }
        return list;
    }
}
