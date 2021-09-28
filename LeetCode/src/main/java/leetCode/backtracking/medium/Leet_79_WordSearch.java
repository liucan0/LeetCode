package leetCode.backtracking.medium;

/**
 * leetcode 79 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例1：
 * 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCCED'
 * 输出：true
 * 示例2：
 * 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'SEE'
 * 输出：true
 * 示例3：
 * 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCB'
 * 输出：false
 *
 */
public class Leet_79_WordSearch {
    //偏移量数组，用来指明下一次遍历的位置,{x,y}格式
    private static final int[][] DIRECTIONS = {{-1,0}, {0, -1}, {0, 1}, {1, 0}};
    private int rows;//行数
    private int cols;//列数
    private int len;//输入字符串长度
    private boolean[][] visited;//状态数组，标记元素是否已被使用
    private char[] charArray;//输字符串转化的char数组
    private char[][] board;//输入字符矩阵


    /**
     * 回溯法
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        if (rows == 0) {
            return false;
        }
        cols = board[0].length;
        visited = new boolean[rows][cols];
        len = word.length();
        charArray = word.toCharArray();
        this.board = board;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 使用DIRECTIONS偏移量，记录偏移位置
     * @param x
     * @param y
     * @param begin
     * @return
     */
    private boolean dfs(int x, int y, int begin) {
        if (begin == len - 1) {
            return board[x][y] == charArray[begin];
        }
        //矩阵中当前元素与目标字符相同时
        if (board[x][y] == charArray[begin]) {
            //设置当前位置为已使用
            visited[x][y] = true;
            for (int[] direction : DIRECTIONS) {
                //下一次遍历位置的x,y轴下标
                int newX = x + direction[0];
                int newY = y + direction[1];
                //如果新元素坐标合法且元素未被使用
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    //基于新元素继续进行遍历，寻找下一个元素位置
                    if (dfs(newX, newY, begin + 1)) {
                        return true;
                    }
                }
            }
            //未找到符合条件的元素，回溯，进行下一轮遍历
            visited[x][y] = false;
        }
        return false;
    }

    /**
     * 判断索引位置是否合法
     * @param x
     * @param y
     * @return
     */
    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','C'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        Leet_79_WordSearch instance = new Leet_79_WordSearch();
        System.out.println(instance.exist(board, word));
    }
}
