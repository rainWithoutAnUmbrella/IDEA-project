package 程序员面试金典_第六版.面试题01.回文排列;



/*
给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
回文串不一定是字典当中的单词。


示例1：

输入："tactcoa"
输出：true（排列有"tacocat"、"atcocta"，等等）
 */

import java.util.HashSet;

class Solution { //回文的特点是字符串从两侧都是成对出现，直到中间字符串是唯一存在（偶数长度字符串不存在）
    public boolean canPermutePalindrome(String s) {
        if (s == null) //如果字符串空
            return false;
        HashSet<Character> hashSet = new HashSet<>();
        char[] str = s.toCharArray();
        for (char c : str) {
            if (hashSet.contains(c)) //如果集合中已经添加了元素，由于回文串，该元素必然会再次被添加，由于下次添加时，集合中已经有对应的字符串，添加方法不会生效
                hashSet.remove(c); //此时直接从集合中移出遇到的元素 有关回文串中该对应字符已经判断完毕
            else {
                hashSet.add(c); //正常向集合中添加元素
            }
        }
        return hashSet.size() <= 1; //如果剩下一个元素，那么这个元素就是回文串的中间元素，如果没有元素，则回文串是一个偶数长度的串
    }
}

public class canPermutePalindrome {
    public static void main(String[] args) {

    }
}
