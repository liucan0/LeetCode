package leetCode.mathematics.simple;

import java.util.Arrays;

/**
 * leetcode 204 计算质数数量
 * 统计所有小于非负整数 n 的质数的数量。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 */
public class Leet_204_CountPrimes {

    /**
     * 方法1：枚举(O(根号n))
     * 质数定义：在大于1的自然数中，除1和自身以为，该数不存在其他因数(不会被其他数整除)
     * 如果y是x的因数，那么x/y也必然是x的因数，因此只要校验y或x/y即可。如果每次选择校验两者中
     * 的最小值，则最小数一定落在|2,根号x|的区间中，因此只需要枚举2到根号x区间内的所有数即可，
     * 将枚举时间复杂度从O(n)降低到O(根号n)
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int result = 0;
        for (int i = 2; i < n; i++) {
            result  += isPrime(i) ? 1 : 0;
        }
        return result;
    }

    private boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 方法2：埃氏筛(O(NlogNlogN))
     * 如果x是质数，那么大于x的x的倍数2x,3x等一定不是质数
     *
     * @param n
     * @return
     */
    public int isPrimes2(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                result += 1;
                if (1L * i * i < n) {
                    for (int j = i * i; j < n; j+= i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return result;
    }
}
