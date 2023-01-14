package lanqiao.wordAnalyze;

import java.util.Scanner;

/**
 * 题目描述
 * 小蓝正在学习一门神奇的语言，这门语言中的单词都是由小写英文字母组 成，有些单词很长，远远超过正常英文单词的长度。小蓝学了很长时间也记不住一些单词，他准备不再完全记忆这些单词，而是根据单词中哪个字母出现得最多来分辨单词。
 * 现在，请你帮助小蓝，给了一个单词后，帮助他找到出现最多的字母和这 个字母出现的次数。
 * 输入描述
 * 输入一行包含一个单词，单词只由小写英文字母组成。
 * 对于所有的评测用例，输入的单词长度不超过 1000。
 * 输出描述
 * 输出两行，第一行包含一个英文字母，表示单词中出现得最多的字母是哪 个。如果有多个字母出现的次数相等，输出字典序最小的那个。
 * 第二行包含一个整数，表示出现得最多的那个字母在单词中出现的次数。
 * 输入输出样例
 * 示例 1
 * 输入
 * lanqiao
 * copy
 * 输出
 * a
 * 2
 * copy
 * 示例 2
 * 输入
 * longlonglongistoolong
 * copy
 * 输出
 * o
 * 6
 * copy
 * 运行限制
 * 最大运行时间：1s
 * 最大运行内存: 256M
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
        int[] alphaArray = new int[26];//用来存放26个字母 按顺序，例如存放a[3]就相当于'd'
        for (int i = 0; i < s.length(); i++) {
            alphaArray[s.charAt(i) - 'a']++;
        }
        char ch='a';
        int max=0;
        for(int i=0;i<26;i++) {
            if(alphaArray[i]>max) {
                max=alphaArray[i];
                ch=(char)('a'+i);
            }//因为是从前往后 所以相等时 无需考虑
        }
        System.out.println(ch);
        System.out.println(max);
    }
}
