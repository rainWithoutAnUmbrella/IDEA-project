package 程序员面试金典_第六版.面试题01.字符串压缩;

/**
 * @author MR.Wang
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * 示例1:
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * 示例2:
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 * 字符串长度在[0, 50000]范围内。
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
class Solution { //遍历依次字符串，判断下一个字符是否与上一个相同，相同，计数器++，不同，append字符 + 计数器
    public String compressString(String S) {
        if (S.length() == 0) { //如果空串，则直接返回
            return S;
        }
        StringBuilder sb = new StringBuilder();
        char headChar = S.charAt(0); //先将字符串的第一个字符append
        int charTime = 1; //定义元素出现的次数
        for (int i = 1; i < S.length(); i++) { //从后依次遍历元素
            char nextChar = S.charAt(i); //获取遍历到的元素
            if (nextChar == headChar) { //如果获取到的元素和之前append的元素相同，则计数器++
                charTime++;
            } else {
                sb.append(headChar).append(charTime); //如果遍历到的元素和当前获取的nextChar不同 就把之前的headChar和charTime添加到sb中
                headChar = nextChar; //将下一个不同元素赋值与headChar 比如说"aaabb" 此时nextChar为b 而headChar还是a 就要赋值headChar为nextChar以便比较
                charTime = 1; //将计数器重置为1
            }
        }
        sb.append(headChar).append(charTime); //由于遍历到数组末尾后没有下一个不同的元素，所以else不会执行，要手动append
        String ans = sb.toString(); //获取String类型的StringBuilder对象
        return ans.length() < S.length() ? ans : S; //对返回值进行三元操作判断
    }
}

public class compressString {
    public static void main(String[] args) {
        String str = "aaabb";
        Solution solution = new Solution();
        String b = solution.compressString(str);
        System.out.println(b);
    }
}
