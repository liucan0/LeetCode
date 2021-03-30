package leetCode.mathematics.simple;

/**
 * leetcode 342 4的幂
 */
public class Leet_342_IsPowerOfFour {

    /**
     * 此处不考虑暴力法(3的幂中使用的方法)
     * 先与n-1做与运算判断是否是2的幂,再对3取模，值为1说明是4的幂
     * @param n
     * @return
     */
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }

    public static void main(String[] args) {
        Leet_342_IsPowerOfFour instance = new Leet_342_IsPowerOfFour();
        System.out.println(instance.isPowerOfFour(8));
    }
}
