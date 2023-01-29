package 程序员面试金典_第六版.面试题01.一次编辑;

/*
字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。

示例1:
输入:
first = "pale"
second = "ple"
输出: True

示例2:
输入:
first = "pales"
second = "pal"
输出: False
 */
class Solution {
    public boolean oneEditAway(String first, String second) {
        int d = first.length() > second.length() ? first.length() - second.length() : second.length() - first.length();
        if (d > 1) {
            return false;
        }
        if (d == 1) {
            if (first.length() == 0 || second.length() == 0) {
                return true;
            }
            for (int i = 0; i < (Math.min(first.length(), second.length())); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    return false;
                }
            }
        }
        if (d == 0) {
            int count = 0;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    count++;
                }
            }
            return count <= 1;
        }
        return true;
    }
}

public class oneEditAway {
    public static void main(String[] args) {
        String first = "mart";
        String second = "karma";
        Solution solution = new Solution();
        boolean b = solution.oneEditAway(first, second);
        System.out.println(b);
    }
}
