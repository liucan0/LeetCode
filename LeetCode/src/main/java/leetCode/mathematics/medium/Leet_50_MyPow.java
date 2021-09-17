package leetCode.mathematics.medium;

/**
 * leetcode 50 实现pow(x, n)函数，计算x的n次方;
 */
public class Leet_50_MyPow {

    /**
     * 快速幂算法.迭代
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        int index = n > 0 ? n : -n;
        double result = 1, diff = x;
        while (index > 0) {
            if (index % 2 == 1) {
                result *= diff;
            }
            diff *= diff;
            index /= 2;
        }
        return n > 0 ? result : 1 / result;
    }

    /**
     * 快速幂算法。递归实现(分治法)
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        int index = n;
        return n > 0 ? quickMul(x, n) : 1 / quickMul(x, -n);
    }

    private double quickMul(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double result = quickMul(x, n / 2);
        //若n为偶数，计算result * result,n为奇数，则再乘上x
        return n % 2 == 0 ? result * result : result * result * x;
    }

    public static void main(String[] args) {
        Leet_50_MyPow instance = new Leet_50_MyPow();
        double x = 2;
        int n = 3;
        System.out.println(instance.myPow2(x, n));
        System.out.println(Math.pow(x, n));
    }
}
