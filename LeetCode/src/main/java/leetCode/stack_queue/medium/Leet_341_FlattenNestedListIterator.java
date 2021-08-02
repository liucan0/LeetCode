package leetCode.stack_queue.medium;

import base.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * leetcode 341 扁平化嵌套列表迭代器
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 *
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 */
public class Leet_341_FlattenNestedListIterator implements Iterator<Integer> {

    /**
     * 方法一：深度优先搜索，嵌套的整型模型是一个树形结构,树上的叶子节点对应一个整数，非叶字节点对应一个列表
     * 在这棵树上深度优先搜索的顺序就是迭代器遍历的顺序。我们可以先遍历整数嵌套列表，将所有整数存入一个数组，
     * 然后遍历该数组从而实现next和hasNext方法
     * @return
     */
    private List<Integer> vals;
    private Iterator<Integer> cur;

    public Leet_341_FlattenNestedListIterator(List<NestedInteger> nestedIntegerList) {
        this.vals = new ArrayList<>();
        dfs(nestedIntegerList);
        cur = vals.iterator();
    }

    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }

    @Override
    public Integer next() {
        return cur.next();
    }

    /**
     * 深度优先遍历，若当前元素是整数，加入到结果集，如果是列表，则对此列表进行深度优先遍历
     * @param nestedList
     */
    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                vals.add(nest.getInteger());
            } else {
                dfs(nest.getList());
            }
        }
    }
}
