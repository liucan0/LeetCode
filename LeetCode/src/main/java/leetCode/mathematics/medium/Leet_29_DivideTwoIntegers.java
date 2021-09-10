package leetCode.mathematics.medium;

/**
 * leetcode 29 两数相除
 * 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法，出发
 * 和mod运算符。返回被除数dividend除以除数divisor得到的商。
 * 整数除法的结果应当截取其小数部分
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 */
public class Leet_29_DivideTwoIntegers {

    /**
     * 递归。
     * 将除数翻倍，若被除数还比除数大，则再将除数翻倍，逐渐逼近被除数。
     * 若除数翻倍后比被除数大，则记录翻倍前除数的值，再用被除数减去除数，
     * 再用差重新执行上述流程，直至差小于除数
     * @param dividend 被除数
     * @param divisor 除数
     * @return
     */
    public int divide(int dividend, int divisor) {
        if(divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE; // 溢出
        int sign = 1;
        if((dividend > 0 && divisor < 0)||(dividend < 0 && divisor > 0))
            sign = -1;
        // if(divisor == 1) return dividend;
        // if(divisor == -1) return -dividend;
        int a = dividend>0 ? -dividend : dividend;
        int b = divisor>0 ? -divisor : divisor;
        // 都改为负号是因为int 的范围是[2^31, 2^31-1]，如果a是-2^32，转为正数时将会溢出
        //System.out.println(a + " " + b);
        if(a > b) return 0;
        int ans = div(a,b);
        return sign == -1 ? -ans : ans;
    }

    private int div(int dividend, int divisor) {
        if(dividend > divisor) return 0;
        int count = 1;
        int tb = divisor;
        while(tb+tb >= dividend && tb+tb < 0){ // 溢出之后不再小于0
            tb += tb;
            count += count;
            //System.out.println(tb + " " + count + " " + count*b);
        }
        return count+div(dividend-tb,divisor);
    }

    public static void main(String[] args) {
        Leet_29_DivideTwoIntegers instance = new Leet_29_DivideTwoIntegers();
        System.out.println(instance.divide(12, 3));
    }
}
