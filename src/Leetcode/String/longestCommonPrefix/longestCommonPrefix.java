package Leetcode.String.longestCommonPrefix;
/*
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串""

https://leetcode.cn/problems/longest-common-prefix/

示例 1：
输入：strs = ["flower","flow","flight"]
输出："fl"

示例 2：
输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。

提示：
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] 仅由小写英文字母组成
通过次数1,011,617提交次数2,343,919

*/

class Solution { //使用subString
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return ""; //如果字符串数组长度为0，则直接返回空串
        //公共前缀比所有字符串都短，随便选一个先
        String s = strs[0];
        for (String string : strs) { //依次遍历字符串数组中的每一个字符串
            while (!string.startsWith(s)) { //如果遇到遍历到的字符串与前面定义的公共字符串开头不一样，
                //公共前缀不匹配就让它变短！
                s = s.substring(0, s.length() - 1); //定义的公共字符串的长度 - 1，
            }
        }
        return s;
    }
}

public class longestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String[] strs1 = {"dog", "racecar", "car"};
        Solution solution = new Solution();
        String s = solution.longestCommonPrefix(strs);
        String s1 = solution.longestCommonPrefix(strs1);
        System.out.println(s + "   " + s1);
    }
}
