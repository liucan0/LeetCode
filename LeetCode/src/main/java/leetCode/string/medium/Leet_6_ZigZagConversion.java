package leetCode.string.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 6 z字形变换
 */
public class Leet_6_ZigZagConversion {

    /**
     * 从左到右迭代s，将每个字符添加到合适的行，可以使用当前行和当前方向这两个
     * 变量对合适的行进行跟踪。
     * 只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会改变
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        //初始化rows列表，rows大小为非空行数量，即numRows和s长度中的较小值
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int currRow = 0;//当前行数量
        boolean goingDown = false;//是否向下遍历行
        for (char c : s.toCharArray()) {
            rows.get(currRow).append(c);
            if (currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currRow += goingDown ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Leet_6_ZigZagConversion instance = new Leet_6_ZigZagConversion();
        System.out.println(instance.convert("ABCDE", 4));
    }
}
