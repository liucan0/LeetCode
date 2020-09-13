package base;

import java.util.List;

/**
 * 描述:<br>
 * N叉树节点
 * @ClassName Node
 * @Author liucan
 * @Date 2020/9/7 下午8:40
 * @Version 1.0.0
 */
public class Node {
    private int val;
    private List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
