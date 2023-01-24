package Leetcode.String.romanToInt;

import java.util.HashMap;

/*
罗马数字包含以下七种字符:I，V，X，L，C，D和M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做II，即为两个并列的 1 。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。
数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
给定一个罗马数字，将其转换成整数。

示例1:
输入:s = "III"
输出: 3

示例2:
输入:s = "IV"
输出: 4

示例3:
输入:s = "IX"
输出: 9

示例4:
输入:s = "LVIII"
输出: 58
解释: L = 50, V= 5, III = 3.

示例5:
输入:s = "MCMXCIV"
输出: 1994
解释: M = 1000, CM = 900, XC = 90, IV = 4.

提示：
1 <= s.length <= 15
s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
通过次数763,219提交次数1,224,924

*/

class Solution { //哈希表 时间复杂度：O(n) 空间复杂度：O(1)
    public int romanToInt(String s) {
        int len = s.length();
        HashMap<Character, Integer> romanToIntVal = new HashMap<>(); //建立哈希表存放罗马字符与值的关系
        romanToIntVal.put('I', 1);
        romanToIntVal.put('V', 5);
        romanToIntVal.put('X', 10);
        romanToIntVal.put('L', 50);
        romanToIntVal.put('C', 100);
        romanToIntVal.put('D', 500);
        romanToIntVal.put('M', 1000);
        int returnVal = 0;
        for (int i = 0; i < len; i++) {
            int val = romanToIntVal.get(s.charAt(i)); //依次获取HashMap中对应键的值
            if (i < len - 1 && val < romanToIntVal.get(s.charAt(i + 1))) { //如果出现IV的情况，即后一个罗马字符对应的值大于前一个字符对应的值
                returnVal = returnVal - val; //则返回值 - 这个特殊情况下的值，比如说XIV就相当于 10 - 1 + 5
            } else { //一般情况
                returnVal = returnVal + val; //正常情况下值相加即可
            }
        }
        return returnVal;
    }
}

public class romanToInt {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        Solution solution = new Solution();
        int val = solution.romanToInt(s);
        System.out.println(val);

    }
}
