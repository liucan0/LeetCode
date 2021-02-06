package leetCode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class Leet_118_YangHuiTriangleGenerate {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return result;
        }
        List<Integer> preList = null;
        for (int i = 0; i < numRows; i++) {
            List<Integer> tempList = new ArrayList<>();
            tempList.add(1);
            if (preList != null && numRows > 1) {
                int j = 0, k = 1;
                while (k < preList.size()) {
                    int temp = preList.get(j++) + preList.get(k++);
                    tempList.add(temp);
                }
                tempList.add(1);
            }
            preList = tempList;
            result.add(tempList);
        }
        return result;
    }

    public static void main(String[] args) {
        int num = 5;
        Leet_118_YangHuiTriangleGenerate instance = new Leet_118_YangHuiTriangleGenerate();
        List<List<Integer>> result = instance.generate(num);
        System.out.println(result);
    }
}
