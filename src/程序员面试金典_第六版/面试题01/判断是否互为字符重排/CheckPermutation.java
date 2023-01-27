package 程序员面试金典_第六版.面试题01.判断是否互为字符重排;


/*
给定两个由小写字母组成的字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。

示例 1：

输入: s1 = "abc", s2 = "bca"
输出: true
示例 2：

输入: s1 = "abc", s2 = "bad"
输出: false

说明：

0 <= len(s1) <= 100
0 <= len(s2) <= 100

 */

import java.util.Arrays;

class Solution { //字符串是否能重排相当于排序后字符串是否相等
    public boolean CheckPermutation(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2); //由于数组是引用类型非值类型，只需要比较两个char数组的值，如果用 ”==“,是比较对象的地址值和值
        //显然地址值是不相同的
    }
}

class Solution2 { //创建数组替代哈希表
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int[] ASCII_Hash = new int[128]; //因为ASCII码范围是(0~127) 一共有128种不同字符 int和char可以自动转换
        for (int i = 0; i < s1.length(); i++) {
            ASCII_Hash[s1.charAt(i)] = ASCII_Hash[s1.charAt(i)] + 1; //记录每种char字符出现的次数
        }
        for (int i = 0; i < s2.length(); i++) {
            ASCII_Hash[s2.charAt(i)] = ASCII_Hash[s2.charAt(i)] - 1;
            if (ASCII_Hash[s2.charAt(i)] < 0) //两个字符串元素类型不一致
                return false;
        }
        return true;
    }
}

public class CheckPermutation {
    public static void main(String[] args) {
        String str1 = "aba";
        String str2 = "acc";
        String str3 = "!@";
        String str4 = "@!";
        Solution2 solution = new Solution2();
        boolean b = solution.CheckPermutation(str1, str2);
        boolean b1 = solution.CheckPermutation(str3, str4);
        System.out.println(b + " " + b1);
    }
}