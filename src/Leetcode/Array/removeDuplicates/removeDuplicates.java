package Leetcode.Array.removeDuplicates;

/*
给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。
将最终结果插入nums 的前 k 个位置后返回 k 。
不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

https://leetcode.cn/problems/remove-duplicates-from-sorted-array/

判题标准:

系统会用下面的代码来测试你的题解:

int[] nums = [...]; // 输入数组
int[] expectedNums = [...]; // 长度正确的期望答案

int k = removeDuplicates(nums); // 调用

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
如果所有断言都通过，那么您的题解将被 通过。

示例 1：

输入：nums = [1,1,2]
输出：2, nums = [1,2,_]
解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
示例 2：

输入：nums = [0,0,1,1,1,2,2,3,3,4]
输出：5, nums = [0,1,2,3,4]
解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。

提示：

1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums 已按 升序 排列
 */

import Arrayutil.Util;

import java.util.Set;
import java.util.TreeSet;

class Solution { //使用了额外的空间，即开辟一个新数组 时间复杂度:O(n^2) 空间复杂度:O(n)
    public int removeDuplicates(int[] nums) {
        Set<Integer> setNums = new TreeSet<>(); //创建set集合，利用set集合中元素不相同规则，可以直接去除相同元素 --不能使用HashSet，因为HashSet在添加元素的时候是无序的
        for (int num : nums) {
            setNums.add(num); //依次添加元素，此时如果出现相同的元素，则setNums.add方法返回false，不会继续执行
        }
        int numIndex = 0;
        for (Integer setNum : setNums) { //把TreeSet中的值重新赋给数组nums
            nums[numIndex] = setNum;
            numIndex++;
        }
        return numIndex;
    }
}

class Solution2 { //使用双指针的解法，原地修改数组 时间复杂度:O(n) 空间复杂度:O(1)
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int left = 0; //左指针指向第一个元素的位置
        int right = left + 1; //有指针指向下一个元素的位置，首先判断两个指针指向元素位置的情况
        if (len == 0) { //特殊情况，数组长度为0 即空数组
            return 0;
        }
        if (len == 2 && nums[0] != nums[1]) { //如果数组长度为2且两个元素都不相等，那么不用判断，直接返回原数组的长度
            return len;
        }
        while (right < len - 1) { //如果数组只有两个元素，那么不会执行这语句，因为此时 right = 1 while条件内的（1不可能小于1） 及所给数组长度3或以上才能用本算法
            if (nums[left] == nums[right]) { //如遇到相等元素，right指针继续向前走
                right++;
            }
            if (nums[left] != nums[right]) { //如果元素不相等，先让left++，然后把当前right指向的元素赋给nums对应left++后的位置
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1; //left是数组的索引，数组的长度是索引+1
    }
}

public class removeDuplicates {
    public static void main(String[] args) {
        int[] returnNum = new int[]{1, 1, 2};
        int[] returnNum2 = new int[]{-3, -3, 0, 0, 1, 1, 88, 89};
        int[] nullptr = new int[]{};
        Solution solution = new Solution();
        int i = solution.removeDuplicates(returnNum);
        System.out.println("=========================");
        System.out.println("数组returnNum中的元素：");
        for (int j = 0; j < i; j++) {
            System.out.print(" " + returnNum[j]);
        }
        int i1 = solution.removeDuplicates(returnNum2);
        System.out.println("=========================");
        System.out.println("数组returnNum2中的元素：");
        for (int j = 0; j < i1; j++) {
            System.out.print(" " + returnNum2[j]);
        }
        int i2 = solution.removeDuplicates(nullptr);
        System.out.println("=========================");
        System.out.println("空数组测试");
        for (int j = 0; j < i2; j++) {
            System.out.print(" " + returnNum[j]);
        }
    }
}
