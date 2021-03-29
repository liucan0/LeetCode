package leetCode.string.simple;

/**
 * 罗马数字转整数
 */
public class Leet_13_RomanToInteger {
    /**
     * 较小的数字a在大数b的左边时，代表b-a,a在b的右边时，代表b+a.
     * 从右往左遍历，暂存前一个遍历的数用来判断
     * @param s
     * @return
     */
    public int romanToInteger(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        char[] romanArr = s.toCharArray();
        int result = 0, temp = getIntValue(romanArr[romanArr.length - 1]);
        for (int i = romanArr.length - 1; i >= 0; i--) {
            int value = getIntValue(romanArr[i]);
            if (temp > value) {
                result -= value;
            } else {
                result += value;
            }
            temp = value;
        }
        return result;
    }

    private int getIntValue(char romanChar) {
        int result = 0;
        switch (romanChar) {
            case 'I' :
                result = 1;
                break;
            case 'V' :
                result = 5;
                break;
            case 'X' :
                result = 10;
                break;
            case 'L' :
                result = 50;
                break;
            case 'C' :
                result = 100;
                break;
            case 'D' :
                result = 500;
                break;
            case 'M' :
                result = 1000;
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        Leet_13_RomanToInteger isntance = new Leet_13_RomanToInteger();
        System.out.println(isntance.romanToInteger("LVIII"));
    }
}
