package 程序员面试金典_第六版.面试题01.判断字符是否唯一;
/*
实现一个算法，确定一个字符串 s 的所有字符是否全都不同。

示例 1：

输入: s = "leetcode"
输出: false
示例 2：

输入: s = "abc"
输出: true
限制：

0 <= len(s) <= 100
s[i]仅包含小写字母
如果你不使用额外的数据结构，会很加分。
通过次数141,944提交次数199,239

 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution { //使用HashSet集合，如果添加元素失败，证明有重复字符
    public boolean isUnique(String str) {
        char[] s = str.toCharArray(); //将给定字符串转换为字符数组
        Set<Character> set = new HashSet<>(); //HashSet不可存储重复元素
        for (char c : s) {
            if (!set.add(c))
                return false;
        }
        return true;
    }
}

class Solution2 { //先排序 判断数组相邻元素是否相等
    public boolean isUnique(String str) {
        if (str.length() > 26) //如果给定字符串长度超过26 则一定有重复元素
            return false;
        char[] s = str.toCharArray(); //将字符串转换为char数组
        Arrays.sort(s); //对数组进行排序
        for (int i = 0; i < s.length - 1; i++) { //判断数组相邻元素是否相同 如果相同，则证明有重复元素
            if (s[i] == s[i + 1])
                return false;
        }
        return true;
    }
}

class Solution3 { //for 循环暴力枚举
    public boolean isUnique(String str) {
        if (str.length() > 26) //如果给定字符串长度超过26 则一定有重复元素
            return false;
        char[] s = str.toCharArray();
        int len = s.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (s[i] == s[j])
                    return false;
            }
        }
        return true;
    }
}

public class isUnique {
    public static void main(String[] args) {

    }
}
