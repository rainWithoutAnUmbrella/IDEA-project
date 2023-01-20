package Leetcode.Array.plusOne;
/*
给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。

https://leetcode.cn/problems/plus-one/

示例1：

输入：digits = [1,2,3]
输出：[1,2,4]
解释：输入数组表示数字 123。
示例2：

输入：digits = [4,3,2,1]
输出：[4,3,2,2]
解释：输入数组表示数字 4321。
示例 3：

输入：digits = [0]
输出：[1]

提示：
1 <= digits.length <= 100
0 <= digits[i] <= 9
*/

import Arrayutil.Util;

class Solution { //分3种情况讨论-时间复杂度：O(n) 空间复杂度：O(1)
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (digits[len - 1] != 9) {
            digits[len - 1] = digits[len - 1] + 1;
            return digits;
        }
        for (int i = len - 1; i >= 0; i--) { //对给定数组degits进行逆序循环
            if (digits[i] != 9) { //如果digits[i] != 9 就是逆序找到第一个不为9的数
                digits[i] = digits[i] + 1; //加一
                for (int j = i + 1; j < len; j++) { //将digits[i]后面的元素都赋值为0
                    digits[j] = 0;
                }
                return digits;
            }
        }
        int[] specialArray = new int[len + 1]; //执行到此时说明所有数组对应值都是9，就创建一个新数组，让数组的第一个元素为1
        specialArray[0] = 1; //剩下未赋值的元素默认值为0
        return specialArray;
    }
}

public class plusOne {
    public static void main(String[] args) {
        int[] digits = new int[]{1, 2, 9};
        int[] digits2 = new int[]{9, 9, 9};
        Solution solution = new Solution();
        int[] ints = solution.plusOne(digits);
        int[] ints1 = solution.plusOne(digits2);
        System.out.println("[1,2,9]加一的结果是：");
        Util.displayNums(ints);
        System.out.println("=========================");
        System.out.println("[9,9,9]加一的结果是：");
        Util.displayNums(ints1);
    }
}
