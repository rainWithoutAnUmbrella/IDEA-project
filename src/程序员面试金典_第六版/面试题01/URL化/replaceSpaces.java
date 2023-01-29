package 程序员面试金典_第六版.面试题01.URL化;
/*
URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）

示例 1：

输入："Mr John Smith    ", 13
输出："Mr%20John%20Smith"

示例 2：

输入："               ", 5
输出："%20%20%20%20%20"


提示：

字符串长度在 [0, 500000] 范围内。
 */

class Solution { //使用StringBuilder 根据要求append字符串
    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        char[] s = S.toCharArray(); //转换为数组
        for (int i = 0; i < length; i++) {
            if (s[i] == ' ')
                sb.append("%20");
            else {
                sb.append(s[i]);
            }
        }
        return sb.toString(); //将sb类型打印成字符串
    }
}

public class replaceSpaces {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "Mr John Smith    ";
        String ans = solution.replaceSpaces(str, 16);
        System.out.println(ans);
    }
}
